package com.sg.controller;

import com.sg.model.sgdsRq.Parameter;
import com.sg.model.sgdsRq.ParametrizedReportRequest;
import com.sg.model.sgdsRq.RegReportRq;
import com.sg.model.sgdsRq.action.ActionDataRq;
import com.sg.model.sgdsRq.action.CheckWriteBackRq;
import com.sg.model.sgdsRq.paramRq.ParametersMainRq;
import com.sg.model.sgdsRq.writeback.WBData;
import com.sg.model.sgdsRq.writeback.WritebackRq;
import com.sg.model.sgdsRs.*;
import com.sg.model.sgdsRs.Tab;
import com.sg.model.sgdsRs.action.*;
import com.sg.model.sgdsRs.paramRs.ParametersMain;
import com.sg.model.sgdsRs.repdet.*;
import com.sg.model.sgdsRs.repdet.Column;
import com.sg.model.sgdsRs.repdet.Datum;
import com.sg.model.sgdsRs.repdet.Row;
import com.sg.model.sgdsRs.writeback.WritebackStatusRs;
import com.sg.model.slackRq.IntMessageRequest;
import com.sg.model.slackRq.TokenResponse;
import com.sg.model.slackRs.Action;
import com.sg.model.slackRs.Attachment;
import com.sg.model.slackRs.ButtonRes;
import com.sg.model.slackRs.SlackUserProfile;
import com.sg.model.slackRs.detail.Field;
import com.sg.model.slackRs.detail.RecordDetail;
import com.sg.redis.RedisManager;
import com.sg.sgds.SGDSClient;
import com.sg.utils.Config;
import com.sg.utils.JsonUtil;
import com.sg.utils.SGSlackConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by ayush on 7/14/16.
 */

@Service
public class GenericWorkFlowAsyncService {

    private static final Logger logger = LoggerFactory.getLogger(GenericWorkFlowAsyncService.class);

    /**
     * For any slack command or interactive message, this method asynchronously executes and sends back responses to the
     * given slack response url.
     * <p>
     * For a slash command the slack request is like:
     * token=gIkuvaNzQIHg97ATvDxqgjtO
     * team_id=T0001
     * team_domain=example
     * channel_id=C2147483705
     * channel_name=test
     * user_id=U2147483697
     * user_name=Steve
     * command=/weather
     * text=94070
     * response_url=https://hooks.slack.com/commands/1234/5678
     * <p>
     * For a interactive message the slack request is like:
     * <p>
     * {
     * "actions": [
     * {
     * "name": "recommend",
     * "value": "yes"
     * }
     * ],
     * "callback_id": "comic_1234_xyz",
     * "team": {
     * "id": "T47563693",
     * "domain": "watermelonsugar"
     * },
     * "channel": {
     * "id": "C065W1189",
     * "name": "forgotten-works"
     * },
     * "user": {
     * "id": "U045VRZFT",
     * "name": "brautigan"
     * },
     * "action_ts": "1458170917.164398",
     * "message_ts": "1458170866.000004",
     * "attachment_id": "1",
     * "token": "xAB3yVzGS4BQ3O9FACTa8Ho4",
     * "original_message": "{\"command\":\"New comic book alert!\",\"attachments\":[{\"title\":\"The Further Adventures of Slackbot\",\"fields\":[{\"title\":\"Volume\",\"value\":\"1\",\"short\":true},{\"title\":\"Issue\",\"value\":\"3\",\"short\":true}],\"author_name\":\"Stanford S. Strickland\",\"author_icon\":\"https://api.slack.com/img/api/homepage_custom_integrations-2x.png\",\"image_url\":\"http://i.imgur.com/OJkaVOI.jpg?1\"},{\"title\":\"Synopsis\",\"command\":\"After @episod pushed exciting changes to a devious new branch back in Issue 1, Slackbot notifies @don about an unexpected deploy...\"},{\"fallback\":\"Would you recommend it to customers?\",\"title\":\"Would you recommend it to customers?\",\"callback_id\":\"comic_1234_xyz\",\"color\":\"#3AA3E3\",\"attachment_type\":\"default\",\"actions\":[{\"name\":\"recommend\",\"command\":\"Recommend\",\"type\":\"button\",\"value\":\"recommend\"},{\"name\":\"no\",\"command\":\"No\",\"type\":\"button\",\"value\":\"bad\"}]}]}",
     * "response_url": "https://hooks.slack.com/actions/T47563693/6204672533/x7ZLaiVMoECAW50Gw1ZYAXEM"
     * }
     *
     * @param token
     * @param payload
     * @param command
     * @param slackUserId
     * @param teamId
     * @param responseUrl
     */

    @Async
    public void handleRequestsAsync(String token, String payload, String command, String slackUserId, String teamId, String responseUrl) throws IOException, InterruptedException {
        logger.debug("Executing request In new thread" + Thread.currentThread().getId());
        //validate request - get token and validate token
        logger.debug("token = " + token+" token from property="+Config.getPropertyValue("SLACK_RQ_VER_TOKEN_DEV"));


        if (Config.getPropertyValue("SLACK_RQ_VER_TOKEN_DEV").equals(token)) { //Validating that request is indeed from slack
            //This is either a slash command or a interactive message request
            if (payload == null || payload.isEmpty()) { //slash command
                logger.info("command  =" + command + " issued by " + slackUserId + " in team " + teamId);
                String sessionId = RedisManager.get(teamId + SGSlackConstants.DELIMITER +
                        slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SGDS_SESSIONID);

                if (sessionId != null && !sessionId.isEmpty()) {
                    logger.debug("Valid session=" + sessionId);
                    //get application list
                    if (SGSlackConstants.SLACK_COMMAND_APPS.equals(command) || command == null || command.isEmpty()) {
                        Application apps = null;
                            apps = getAppList(teamId, slackUserId, sessionId);
                        logger.debug("apps size = " + apps.getApplications().size());
                        List<Action> actions = new ArrayList<Action>(apps.getApplications().size());
                        for (Application_ app : apps.getApplications()) {
                            actions.add(populateAction(app.getApplicationName(), app.getApplicationName(), app.getApplicationID(), "default", "button"));
                        }
                        logger.debug("Actions size = " + actions.size());
                        sendAsyncResponse(responseUrl, getButtonRes("Please select an *application*",
                                    SGSlackConstants.GET_REPORT_NAMES, "#3AA3E3", actions, true));

                    }else if (SGSlackConstants.GET_ALL_FAV.equals(command)){ // get all favorites
                        Map<String, String> favs = RedisManager.getAllFavs(teamId + SGSlackConstants.DELIMITER + slackUserId +
                                SGSlackConstants.DELIMITER + SGSlackConstants.FAV_DATA + SGSlackConstants.DELIMITER);
                        if (favs != null && favs.size() >0) {
                            List<Action> actions = new ArrayList<Action>(favs.size());
                            for (Map.Entry<String, String> fav : favs.entrySet()) {
                                actions.add(populateAction(fav.getKey(), fav.getKey(), fav.getValue(), "default", "button"));
                            }

                            sendAsyncResponse(responseUrl, getButtonRes("Please select *favorite*",
                                        SGSlackConstants.GET_FAV_DATA, "#3AA3E3", actions, true));

                        }else{

                            sendAsyncResponse(responseUrl, "{\"text\": \"`No favorites saved yet.`\" }");

                        }
                    } else if (command != null && !command.isEmpty() && command.contains("~")) { //search for given text after ~
                        String searchText = command.substring(1, command.length());
                        if (searchText != null && !searchText.isEmpty()) {
                            searchText = searchText.trim();
                            logger.debug("Search text=" + searchText);
                            Set<String> repIds = RedisManager.getReportIds(searchText,
                                        teamId + SGSlackConstants.DELIMITER + slackUserId +
                                                SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER);

                            if (repIds == null || repIds.size() == 0) {
                                //error message
                                logger.debug("Can't find a report with this text");
                                sendAsyncResponse(responseUrl, "{\"text\": \"Could not find data with `" + searchText + "`\"}");

                            } else if (repIds.size() == 1) {
                                //go to report detail record OR multiple tabs, then drill down from tabs
                                handleSingleRepCaseFromSearch(repIds, searchText, teamId,
                                        slackUserId, sessionId, responseUrl,
                                        repIds.iterator().next());
                            } else if (repIds.size() > 1) {
                                //TODO multiple report search case
                                sendAsyncResponse(responseUrl, "{\"text\": \"`"+searchText+"` returns too many results to be useful.\"}");
                            }
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`No search text entered`\"}");                        }
                    } else if (SGSlackConstants.SLACK_COMMAND_HELP.equals(command)) {
                        //TODO help
                    }
                } else {//session invalid
                    sendAsyncResponse(responseUrl, getLoginLinkResponse(teamId, slackUserId));
                }
            } else if (payload != null && !payload.isEmpty()) {//interactive message via buttons
                ObjectMapper m = new ObjectMapper();
                IntMessageRequest ir = new IntMessageRequest();
                ir = m.readValue(payload, ir.getClass());
                String callbackId = ir.getCallbackId();
                logger.info("callback=" + callbackId + " issued by " + slackUserId + " in team " + teamId);
                String sessionId = RedisManager.get(teamId + SGSlackConstants.DELIMITER +
                        slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SGDS_SESSIONID);
                if (sessionId != null && !sessionId.isEmpty()) {
                    if (SGSlackConstants.GET_REPORT_NAMES.equals(callbackId)) { //button value is appId
                        String appId = ir.getActions().get(0).getValue();
                        logger.info("App id = " + appId);
                        Application app = getAppList(teamId, slackUserId, sessionId);
                        logger.info("Apps size = " + app.getApplications().size());
                        Application_ choosenApp = getApp(app.getApplications(), appId);
                        logger.info("Choosen app name=" + choosenApp.getApplicationName());
                        List<Report> reports = getReportsForApp(choosenApp);
                        List<Action> actions = new ArrayList<Action>(reports.size());
                        for (Report rep : reports) {
                            actions.add(populateAction(rep.getReportName(), rep.getReportName(), appId + SGSlackConstants.DELIMITER + rep.getReportID()
                                    +SGSlackConstants.DELIMITER+("Parameterized".equals(rep.getReportType())?"P":""), "default", "button"));
                        }
                        sendAsyncResponse(responseUrl, getButtonRes("Please select a *Report*", SGSlackConstants.GET_TAB_NAME, "#3AA3E3", actions, true));

                    } else if (SGSlackConstants.GET_TAB_NAME.equals(callbackId)) { //button value is appId:repId

                        String appId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[0];
                        String repId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[1];
                        boolean parametrized = false;
                        if (ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER).length == 3){
                            parametrized = "P".equals(ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[2]);
                        }
                        logger.info("AppId = " + appId + " RepId = " + repId);

                        ReportDetail rd = null;
                        if (parametrized){
                            ParametersMain pm = getParametersMain(appId, repId, sessionId,m);
                            List<Parameter> ps = new ArrayList<Parameter>(pm.getParameters().size());
                            for (com.sg.model.sgdsRs.paramRs.Parameter pfs: pm.getParameters()){
                                Parameter p = new Parameter();

                                p.setValueLabel("");
                                p.setValueID("");
                                p.setParameterLabel(pfs.getParameterName());
                                p.setParameterID(pfs.getID());
                                ps.add(p);
                            }


                            rd = getParamReport(sessionId, appId, repId,ps,m, teamId ,slackUserId );

                        }else{
                            rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true );
                        }


                        if (rd.getStatus() != 0) {
                            List<com.sg.model.sgdsRs.repdet.Tab> tabs = rd.getReportMetaData().getTabs();
                            if (tabs.size() > 1) {//choose tabs
                                List<Action> actions = new ArrayList<Action>(tabs.size());
                                for (com.sg.model.sgdsRs.repdet.Tab tab : tabs) {
                                    actions.add(populateAction(tab.getTabName(), tab.getTabName(), appId + SGSlackConstants.DELIMITER +
                                            repId + SGSlackConstants.DELIMITER + tab.getTabOrdinal(), "default", "button"));
                                }
                                sendAsyncResponse(responseUrl, getButtonRes("*" + rd.getReportMetaData().getReportName() + "* has multiple tabs. Please *select a tab* to continue.",
                                        SGSlackConstants.GET_REPORT_DETAIL, "#3AA3E3", actions, true));

                            } else {//Single tab - no need to choose tab
                                List<Column> columns = rd.getData().getData().get(0).getColumns();
                                List<Action> actions = new ArrayList<Action>();
                                for (Column col : columns) {
                                    actions.add(populateAction(col.getDataItemColumnName(), col.getDataItemColumnName(), appId + SGSlackConstants.DELIMITER +
                                            repId + SGSlackConstants.DELIMITER + "1" + SGSlackConstants.DELIMITER + col.getDataItemColumnID()+(parametrized?SGSlackConstants.DELIMITER+"P":"")
                                            , "default", "button"));
                                }
                                sendAsyncResponse(responseUrl, getButtonRes("Please *select a column name* to start narrowing to relevant data.",
                                        SGSlackConstants.GET_COL_VALUES, "#3AA3E3", actions, true));
                            }
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"``Unexpected Error` - please retry`\" }");
                        }
                    } else if (SGSlackConstants.GET_REPORT_DETAIL.equals(callbackId)) {//column names
                        logger.info("Rep detail value=" + ir.getActions().get(0).getValue());// appId:repId:tabOrd

                        String appId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[0];
                        String repId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[1];
                        int tabOrd = Integer.valueOf(ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[2]);

                        logger.info("AppId = " + appId + " RepId = " + repId+" tabOrd="+tabOrd);

                        ReportDetail rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                        if (rd.getStatus() != 0) {
                            List<GridColumn> gcs = rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getGridColumns();
                            List<Action> actions = new ArrayList<Action>(gcs.size());
                            for (GridColumn col : gcs) {
                                actions.add(populateAction(col.getColumnFriendlyName(), col.getColumnFriendlyName(), appId + SGSlackConstants.DELIMITER + repId +
                                        SGSlackConstants.DELIMITER + tabOrd + SGSlackConstants.DELIMITER + col.getDataItemColumnID(), "default", "button"));
                            }
                            sendAsyncResponse(responseUrl, getButtonRes("Please *select a column name* to start narrowing to relevant data.", SGSlackConstants.GET_COL_VALUES, "#3AA3E3",
                                    actions, true));
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }


                    } else if (SGSlackConstants.GET_COL_VALUES.equals(callbackId)) {
                        logger.info("get col value action value=" + ir.getActions().get(0).getValue());//appI:repId:tabOrd:colId

                        String appId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[0];
                        String repId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[1];
                        int tabOrd = Integer.valueOf(ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[2]);
                        String colId = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[3];
                        boolean parameterized = false;
                        if (ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER).length == 5){
                            parameterized = "P".equals(ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER)[4]);
                        }
                        ReportDetail rd = null;
                        if (parameterized){
                            ParametersMain pm = getParametersMain(appId, repId, sessionId,m);
                            List<Parameter> ps = new ArrayList<Parameter>(pm.getParameters().size());
                            for (com.sg.model.sgdsRs.paramRs.Parameter pfs: pm.getParameters()){
                                Parameter p = new Parameter();

                                p.setValueLabel("");
                                p.setValueID("");
                                p.setParameterLabel(pfs.getParameterName());
                                p.setParameterID(pfs.getID());
                                ps.add(p);
                            }


                            rd = getParamReport(sessionId, appId, repId,ps,m,teamId ,slackUserId );

                        }else {

                            rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                        }
                        //find unique col values for this col ID and respective row indexes.
                        if (rd.getStatus() != 0) {
                            Set<String> colIdUniqueValues = new HashSet<String>();
                            Map<String, StringBuffer> rowIndexes = new HashMap<String, StringBuffer>();
                            List<Row> rows = rd.getData().getData().get(tabOrd - 1).getRows();
                            for (Row row : rows) {
                                String v = row.getColVal(colId);
                                logger.debug("Col value=" + v);
                                colIdUniqueValues.add(v);

                                if (rowIndexes.get(v) == null) {
                                    rowIndexes.put(v, new StringBuffer(String.valueOf(rows.indexOf(row))));
                                } else {
                                    rowIndexes.put(v, rowIndexes.get(v).append(SGSlackConstants.DELIMITER).
                                            append(String.valueOf(rows.indexOf(row))));
                                }
                                logger.debug("row index=" + rowIndexes.get(v).toString());
                            }

                            Iterator<String> colValIter = colIdUniqueValues.iterator();
                            List<Action> actions = new ArrayList<Action>(colIdUniqueValues.size());
                            while (colValIter.hasNext()) {
                                String name = colValIter.next();
                                actions.add(populateAction(name, name, appId + SGSlackConstants.DELIMITER + repId +
                                        SGSlackConstants.DELIMITER + tabOrd + SGSlackConstants.DELIMITER +
                                        rowIndexes.get(name).toString()+(parameterized?SGSlackConstants.DELIMITER+"P":""), "default", "button"));
                            }

                            sendAsyncResponse(responseUrl, getButtonRes("*Last step* - please *select a column* value to view data", SGSlackConstants.GET_DETAIL_REC, "#3AA3E3",
                                    actions, true));
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }

                    } else if (SGSlackConstants.GET_DETAIL_REC.equals(callbackId)) {
                        logger.info("get record action value=" + ir.getActions().get(0).getValue());//appId:repId:tabOrd:rowIndexes
                        String appId = null, repId = null;
                        int tabOrd = 1;
                        List<Integer> rowIndexes = new ArrayList<Integer>();
                        String[] values = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER);
                        boolean parameterized = false;
                        for (int i = 0; i < values.length; i++) {
                            if (i == 0) {
                                appId = values[i];
                            } else if (i == 1) {
                                repId = values[i];
                            } else if (i == 2) {
                                tabOrd = Integer.valueOf(values[i]);
                            } else {
                                if (values[i] != null && !values[i].isEmpty() && !"P".equals(values[i]))
                                    rowIndexes.add(Integer.valueOf(values[i]));
                                if ("P".equals( values[i])){
                                    parameterized = true;
                                }
                            }
                        }
                        logger.debug("Row index size=" + rowIndexes.size());
                        ReportDetail rd = null;
                        if (parameterized){
                            ParametersMain pm = getParametersMain(appId, repId, sessionId,m);
                            List<Parameter> ps = new ArrayList<Parameter>(pm.getParameters().size());
                            for (com.sg.model.sgdsRs.paramRs.Parameter pfs: pm.getParameters()){
                                Parameter p = new Parameter();

                                p.setValueLabel("");
                                p.setValueID("");
                                p.setParameterLabel(pfs.getParameterName());
                                p.setParameterID(pfs.getID());
                                ps.add(p);
                            }


                            rd = getParamReport(sessionId, appId, repId,ps,m, teamId,slackUserId );

                        }else {

                            rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                        }

                        if (rd.getStatus() != 0) {
                            sendDetailRecord(rd, rowIndexes, responseUrl, tabOrd, appId, repId, teamId, slackUserId, sessionId,
                                    "*" + rd.getReportMetaData().getTabs().get(tabOrd - 1).getTabName() + "* data", true, parameterized);
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }

                    } else if (SGSlackConstants.GET_NAV_REP_DET.equals(callbackId)) {

                        String[] values = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER);
                        String appId = values[0], repId = values[1], filterColVal = values[2], tabId = values[3], typeOfNav = values[4];
                        logger.debug("TabId = "+tabId);

                        //get rowIndex row from report detail
                        ReportDetail rd = null;
                        int tabIndex = 0;
                        List<Integer> selectedRows = new ArrayList<Integer>();
                        if (SGSlackConstants.SLICER_NAV.equals(typeOfNav)) {
                            rd = getRegReport(teamId, slackUserId, sessionId, repId, appId,
                                    m, true);
                            tabIndex = getTabIndex(rd, tabId);
                            String slicerColId = rd.getReportMetaData().getReportSharedSlicers().get(0).getSlicerMappings()
                                    .get(0).getSourceDataItemColumn();
                            logger.debug("Clicer col id = " + slicerColId + " filter val = " + filterColVal + " row size in opps=" +
                                    rd.getData().getData().get(tabIndex).getRows().size());
                            List<Row> rows = rd.getData().getData().get(tabIndex).getRows();
                            for (Row row : rows) {
                                if (row.getColVal(slicerColId).equals(filterColVal))
                                    selectedRows.add(rows.indexOf(row));
                            }
                            logger.debug("Selected rows by slicr  size=" + selectedRows.size());
                        } else if (SGSlackConstants.PARAM_NAV.equals(typeOfNav)) {
                            //getparameterizedmainscreen call
                            ParametersMain pm = getParametersMain(appId, repId, sessionId, m);
                            if (pm.getStatus() != 0) {
                                List<Parameter> paramList = new ArrayList<Parameter>(pm.getParameters().size());
                                for (com.sg.model.sgdsRs.paramRs.Parameter paramMain : pm.getParameters()) {
                                    Parameter p = new Parameter();
                                    p.setParameterID(paramMain.getID());
                                    p.setParameterLabel(paramMain.getParameterName());
                                    p.setValueID(filterColVal); //from button value
                                    p.setValueLabel(filterColVal);//from button value
                                    paramList.add(p);
                                }

                                //get parameterized report call
                                rd = getParamReport(sessionId, appId, repId, paramList, m, teamId ,slackUserId );
                                tabIndex = getTabIndex(rd, tabId);
                                if (rd.getStatus() != 0) {
                                    for (int i = 0; i < rd.getData().getData().get(tabIndex).getRows().size(); i++) {
                                        selectedRows.add(i);
                                    }
                                } else {
                                    sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                                }
                            } else {
                                sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                            }


                        }//get column titles

                        if (rd.getStatus() != 0) {
                            sendDetailRecord(rd, selectedRows, responseUrl, 1, appId, repId, teamId, slackUserId, sessionId,
                                    "*" + rd.getReportMetaData().getTabs().get(tabIndex).getTabName() + "* data", false, SGSlackConstants.PARAM_NAV.equals(typeOfNav));
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }

                    } else if (SGSlackConstants.ACTION_REQ.equals(callbackId)) {
                        String[] values = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER);
                        logger.debug("values lenght"+values.length);
                        String appId = values[0], repId = values[1], tabNum = values[2], rowIndex = values[3],
                                actionId = values[4];
                        String actionParamId = "";
                        boolean parameterized = false;
                        if (values.length > 5){
                            if (!"P".equals(values[5])) {
                                actionParamId = values[5];
                            }else{
                                parameterized = true;
                            }
                        }
                        if (values.length >6){
                            parameterized = "P".equals(values[6]);
                        }
                        logger.debug("AppID = "+appId+" repid="+repId+" tabNum="+tabNum+" rowIndex="+rowIndex+
                                " actionId="+actionId+" actionParamId="+actionParamId+" parameterized="+parameterized);

                        ReportDetail rd = null;
                        if (parameterized){
                            ParametersMain pm = getParametersMain(appId, repId, sessionId,m);
                            List<Parameter> ps = new ArrayList<Parameter>(pm.getParameters().size());
                            for (com.sg.model.sgdsRs.paramRs.Parameter pfs: pm.getParameters()){
                                Parameter p = new Parameter();

                                p.setValueLabel("");
                                p.setValueID("");
                                p.setParameterLabel(pfs.getParameterName());
                                p.setParameterID(pfs.getID());
                                ps.add(p);
                            }


                            rd = getParamReport(sessionId, appId, repId,ps,m, teamId,slackUserId );
                        }else{
                            rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                        }
                        int tabOrd = Integer.valueOf(tabNum);
                        List<com.sg.model.sgdsRs.repdet.Action> actions =
                                rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getActions();
                        com.sg.model.sgdsRs.repdet.Action action = getActionById(actions, actionId);
                        boolean responseSent = false;

                        if (actionParamId != null && !actionParamId.isEmpty()) {
                            logger.debug("actionParamId = "+actionParamId);
                            List<Action> actParamActions = new ArrayList<Action>();
                            for (ActionParameter ap : action.getActionParameters()) {
                                if (actionParamId.equals(ap.getID())) {
                                    if (ap.getDataItemID() == null) {//list
                                        if (ap.getAllowedMembers() != null){
                                            for (AllowedMember am : ap.getAllowedMembers()) {
                                                actParamActions.add(populateAction(am.getValue(), am.getValue(),
                                                        appId + SGSlackConstants.DELIMITER + repId +
                                                                SGSlackConstants.DELIMITER + tabOrd +
                                                                SGSlackConstants.DELIMITER +
                                                                rowIndex + SGSlackConstants.DELIMITER +
                                                                actionId + SGSlackConstants.DELIMITER +
                                                                ap.getID() + SGSlackConstants.DELIMITER +
                                                                am.getID(), "default", "button"));
                                            }
                                            break;
                                        }else{//login
                                            logger.debug("Directly writing back as no params");

                                            WritebackRq wbrq = new WritebackRq();
                                            wbrq.setApplicationID(appId);
                                            wbrq.setReportID(repId);
                                            wbrq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                                            wbrq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                                            wbrq.setRequestID(sessionId);
                                            wbrq.setSessionID(sessionId);
                                            com.sg.model.sgdsRq.writeback.Action ac = new com.sg.model.sgdsRq.writeback.Action();
                                            ac.setActionID(actionId);
                                            //com.sg.model.sgdsRq.writeback.Parameter p = new com.sg.model.sgdsRq.writeback.Parameter();
                                            //p.setParameterID(actionParamId);
                                            //p.setSelectedValue(selectedVal);
                                            List<com.sg.model.sgdsRq.writeback.Parameter> ps = new ArrayList<com.sg.model.sgdsRq.writeback.Parameter>(1);
                                            //ps.add(p);
                                            ac.setParameters(ps);
                                            WBData wbData = new WBData();
                                            wbData.setAction(ac);
                                            List<com.sg.model.sgdsRq.writeback.Datum> datums =
                                                    new ArrayList<com.sg.model.sgdsRq.writeback.Datum>(1);
                                            for (Column column: rd.getData().getData().get(tabOrd-1).getColumns()){
                                                com.sg.model.sgdsRq.writeback.Datum datum = new com.sg.model.sgdsRq.writeback.Datum();
                                                datum.setName(column.getDataItemColumnName());
                                                datum.setValue(rd.getData().getData().get(tabOrd-1).getRows().
                                                        get(Integer.valueOf(rowIndex)).getColVal(column.getDataItemColumnID()));
                                                datums.add(datum);

                                            }
                                            com.sg.model.sgdsRq.writeback.Row row = new com.sg.model.sgdsRq.writeback.Row();
                                            row.setData(datums);
                                            List<com.sg.model.sgdsRq.writeback.Row> rows = new ArrayList<com.sg.model.sgdsRq.writeback.Row>(1);
                                            rows.add(row);
                                            wbData.setRows(rows);
                                            wbrq.setWBData(wbData);
                                            String wbrsStr = SGDSClient.writeback(wbrq);
                                            WritebackStatusRs wbrs = new WritebackStatusRs();
                                            wbrs = m.readValue(wbrsStr, wbrs.getClass());
                                            if (wbrs.getStatus() != 0){
                                                Thread.sleep(3000);
                                                CheckWriteBackRq chq = new CheckWriteBackRq();
                                                chq.setSessionID(sessionId);
                                                chq.setApplicationID(appId);
                                                chq.setReportID(repId);
                                                chq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                                                chq.setRequestID(sessionId);
                                                chq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                                                chq.setWBID(wbrs.getResult());
                                                String chsStr = SGDSClient.checkWBStatus(chq);
                                                WritebackStatusRs chs = new WritebackStatusRs();
                                                chs = m.readValue(chsStr, chs.getClass());
                                                logger.debug("Check write back msg = "+chs.getMsg());
                                                if (chs.getStatus() != 0) {
                                                    RedisManager.delete(teamId + SGSlackConstants.DELIMITER + slackUserId +
                                                            SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId);
                                                    if (!parameterized) {
                                                        getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                                                    }else{
                                                        ParametersMain pm1 = getParametersMain(appId, repId, sessionId,m);
                                                        List<Parameter> ps1 = new ArrayList<Parameter>(pm1.getParameters().size());
                                                        for (com.sg.model.sgdsRs.paramRs.Parameter pfs: pm1.getParameters()){
                                                            Parameter p = new Parameter();

                                                            p.setValueLabel("");
                                                            p.setValueID("");
                                                            p.setParameterLabel(pfs.getParameterName());
                                                            p.setParameterID(pfs.getID());
                                                            ps1.add(p);
                                                        }
                                                        getParamReport(sessionId, appId, repId,ps1,m, teamId,slackUserId );
                                                    }
                                                    responseSent = true;
                                                    sendAsyncResponse(responseUrl, "{\"text\": \"*Actions successful !!*\" }");
                                                }else{
                                                    responseSent = true;
                                                    sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                                                }
                                            }else{
                                                responseSent = true;
                                                sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                                            }
                                        }
                                    } else {//DataItem simple list
                                        String actionDI = String.valueOf(ap.getDataItemID());
                                        for (Datum datum : rd.getData().getData()) {
                                            //find data item in same report and then show values for next buttons
                                            if (datum.getDataItemID().equals(actionDI)) {
                                                //no need to call getActionData
                                                for (Row row : datum.getRows()) {
                                                    actParamActions.add(populateAction(row.getC2(), row.getC2(),
                                                            appId + SGSlackConstants.DELIMITER + repId +
                                                                    SGSlackConstants.DELIMITER + tabOrd +
                                                                    SGSlackConstants.DELIMITER +
                                                                    rowIndex + SGSlackConstants.DELIMITER +
                                                                    actionId + SGSlackConstants.DELIMITER +
                                                                    ap.getID() + SGSlackConstants.DELIMITER +
                                                                    row.getC1(), "default", "button"));
                                                }
                                                break;
                                            }
                                            //not found DI in same report
                                        }
                                        if (actParamActions == null || actParamActions.size() == 0) {
                                            //getaction data and show it in anext buttons
                                            ActionDataRq adr = new ActionDataRq();
                                            adr.setSessionID(sessionId);
                                            adr.setActionID(actionId);
                                            adr.setApplicationID(appId);
                                            adr.setReportID(repId);
                                            adr.setRequestID(sessionId);
                                            adr.setTabID(rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getID());
                                            String adrsStr = SGDSClient.getActionData(adr);
                                            ActionDataRs adrs = new ActionDataRs();
                                            adrs = m.readValue(adrsStr, adrs.getClass());
                                            for (com.sg.model.sgdsRs.action.Row row : adrs.getData().get(0).getRows()) {
                                                actParamActions.add(populateAction(row.getC2(), row.getC2(),
                                                        appId + SGSlackConstants.DELIMITER + repId +
                                                                SGSlackConstants.DELIMITER + tabOrd +
                                                                SGSlackConstants.DELIMITER +
                                                                rowIndex + SGSlackConstants.DELIMITER +
                                                                actionId + SGSlackConstants.DELIMITER +
                                                                ap.getID() + SGSlackConstants.DELIMITER +
                                                                row.getC1(), "default", "button"));
                                            }

                                        }
                                    }
                                    break;
                                }
                            }
                            if (!responseSent) {
                                sendAsyncResponse(responseUrl, getButtonRes("Please  " +
                                                "choose a value", SGSlackConstants.WRITE_BACK, "#3AA3E3",
                                        actParamActions, false));
                            }
                        }else{
                            logger.debug("Directly writing back as no params");
                            WritebackRq wbrq = new WritebackRq();
                            wbrq.setApplicationID(appId);
                            wbrq.setReportID(repId);
                            wbrq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                            wbrq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                            wbrq.setRequestID(sessionId);
                            wbrq.setSessionID(sessionId);
                            com.sg.model.sgdsRq.writeback.Action ac = new com.sg.model.sgdsRq.writeback.Action();
                            ac.setActionID(actionId);
                            //com.sg.model.sgdsRq.writeback.Parameter p = new com.sg.model.sgdsRq.writeback.Parameter();
                            //p.setParameterID(actionParamId);
                            //p.setSelectedValue(selectedVal);
                            List<com.sg.model.sgdsRq.writeback.Parameter> ps = new ArrayList<com.sg.model.sgdsRq.writeback.Parameter>(1);
                            //ps.add(p);
                            ac.setParameters(ps);
                            WBData wbData = new WBData();
                            wbData.setAction(ac);
                            List<com.sg.model.sgdsRq.writeback.Datum> datums =
                                    new ArrayList<com.sg.model.sgdsRq.writeback.Datum>(1);
                            for (Column column: rd.getData().getData().get(tabOrd-1).getColumns()){
                                com.sg.model.sgdsRq.writeback.Datum datum = new com.sg.model.sgdsRq.writeback.Datum();
                                datum.setName(column.getDataItemColumnName());
                                datum.setValue(rd.getData().getData().get(tabOrd-1).getRows().
                                        get(Integer.valueOf(rowIndex)).getColVal(column.getDataItemColumnID()));
                                datums.add(datum);

                            }
                            com.sg.model.sgdsRq.writeback.Row row = new com.sg.model.sgdsRq.writeback.Row();
                            row.setData(datums);
                            List<com.sg.model.sgdsRq.writeback.Row> rows = new ArrayList<com.sg.model.sgdsRq.writeback.Row>(1);
                            rows.add(row);
                            wbData.setRows(rows);
                            wbrq.setWBData(wbData);
                            String wbrsStr = SGDSClient.writeback(wbrq);
                            WritebackStatusRs wbrs = new WritebackStatusRs();
                            wbrs = m.readValue(wbrsStr, wbrs.getClass());
                            if (wbrs.getStatus() != 0){
                                Thread.sleep(3000);
                                CheckWriteBackRq chq = new CheckWriteBackRq();
                                chq.setSessionID(sessionId);
                                chq.setApplicationID(appId);
                                chq.setReportID(repId);
                                chq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                                chq.setRequestID(sessionId);
                                chq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                                chq.setWBID(wbrs.getResult());
                                String chsStr = SGDSClient.checkWBStatus(chq);
                                WritebackStatusRs chs = new WritebackStatusRs();
                                chs = m.readValue(chsStr, chs.getClass());
                                logger.debug("Check write back msg = "+chs.getMsg());
                                if (chs.getStatus() != 0) {
                                    RedisManager.delete(teamId + SGSlackConstants.DELIMITER + slackUserId +
                                            SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId);
                                    getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                                    sendAsyncResponse(responseUrl, "{\"text\": \"*Actions successful !!*\" }");
                                }else{
                                    sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                                }
                            }else{
                                sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                            }

                        }
                    }else if (SGSlackConstants.WRITE_BACK.equals(callbackId)){
                        String[] values = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER);
                        String appId = values[0], repId = values[1], tabNum = values[2], rowIndex = values[3],
                                actionId = values[4], actionParamId = values[5], selectedVal = values[6];
                        logger.debug("AppID = "+appId+" repid="+repId+" tabNum="+tabNum+" rowIndex="+rowIndex+
                                " actionId="+actionId+" actionParamId="+actionParamId+" selectedVal="+selectedVal);
                        ReportDetail rd = getRegReport(teamId, slackUserId, sessionId, repId, appId,
                                m, true );
                        int tabOrd = Integer.valueOf(tabNum);
                        WritebackRq wbrq = new WritebackRq();
                        wbrq.setApplicationID(appId);
                        wbrq.setReportID(repId);
                        wbrq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                        wbrq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                        wbrq.setRequestID(sessionId);
                        wbrq.setSessionID(sessionId);
                        com.sg.model.sgdsRq.writeback.Action ac = new com.sg.model.sgdsRq.writeback.Action();
                        ac.setActionID(actionId);
                        com.sg.model.sgdsRq.writeback.Parameter p = new com.sg.model.sgdsRq.writeback.Parameter();
                        p.setParameterID(actionParamId);
                        p.setSelectedValue(selectedVal);
                        List<com.sg.model.sgdsRq.writeback.Parameter> ps = new ArrayList<com.sg.model.sgdsRq.writeback.Parameter>(1);
                        ps.add(p);
                        ac.setParameters(ps);
                        WBData wbData = new WBData();
                        wbData.setAction(ac);
                        List<com.sg.model.sgdsRq.writeback.Datum> datums =
                                new ArrayList<com.sg.model.sgdsRq.writeback.Datum>(1);
                        for (Column column: rd.getData().getData().get(tabOrd-1).getColumns()){
                            com.sg.model.sgdsRq.writeback.Datum datum = new com.sg.model.sgdsRq.writeback.Datum();
                            datum.setName(column.getDataItemColumnName());
                            datum.setValue(rd.getData().getData().get(tabOrd-1).getRows().
                                    get(Integer.valueOf(rowIndex)).getColVal(column.getDataItemColumnID()));
                            datums.add(datum);

                        }
                        com.sg.model.sgdsRq.writeback.Row row = new com.sg.model.sgdsRq.writeback.Row();
                        row.setData(datums);
                        List<com.sg.model.sgdsRq.writeback.Row> rows = new ArrayList<com.sg.model.sgdsRq.writeback.Row>(1);
                        rows.add(row);
                        wbData.setRows(rows);
                        wbrq.setWBData(wbData);
                        String wbrsStr = SGDSClient.writeback(wbrq);
                        WritebackStatusRs wbrs = new WritebackStatusRs();
                        wbrs = m.readValue(wbrsStr, wbrs.getClass());
                        if (wbrs.getStatus() != 0){
                            Thread.sleep(3000);
                            CheckWriteBackRq chq = new CheckWriteBackRq();
                            chq.setSessionID(sessionId);
                            chq.setApplicationID(appId);
                            chq.setReportID(repId);
                            chq.setReportUpdateID(rd.getReportMetaData().getReportUpdateID());
                            chq.setRequestID(sessionId);
                            chq.setTabID(rd.getReportMetaData().getTabs().get(tabOrd-1).getTemplate().getID());
                            chq.setWBID(wbrs.getResult());
                            String chsStr = SGDSClient.checkWBStatus(chq);
                            WritebackStatusRs chs = new WritebackStatusRs();
                            chs = m.readValue(chsStr, chs.getClass());
                            logger.debug("Check write back msg = "+chs.getMsg());
                            if (chs.getStatus() != 0) {
                                RedisManager.delete(teamId + SGSlackConstants.DELIMITER + slackUserId +
                                        SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId);
                                getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);
                                sendAsyncResponse(responseUrl, "{\"text\": \"*Actions successful !!*\" }");
                            }else{
                                sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                            }
                        }else{
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }

                    }else if (SGSlackConstants.SAVE_FAV.equals(callbackId)){
                        String actionVal = ir.getActions().get(0).getValue();
                        String values[] = actionVal.split(SGSlackConstants.DELIMITER);
                        String appId, repId = null;
                        int tabOrd = 1;
                        List<Integer> rowIndexes = new ArrayList<Integer>();
                        for (int i = 0; i < values.length; i++) {
                            if (i == 0) {
                                appId = values[i];
                            } else if (i == 1) {
                                repId = values[i];
                            } else if (i == 2) {
                                tabOrd = Integer.valueOf(values[i]);
                            } else {
                                if (values[i] != null && !values[i].isEmpty())
                                    rowIndexes.add(Integer.valueOf(values[i]));
                            }
                        }
                        logger.debug("Save fav actionval="+actionVal);
                        String favName = new StringBuffer(getReportNameFromRepId(teamId,slackUserId, repId, sessionId).substring(0,3)).
                                append(rowIndexes.get(0)).append(rowIndexes.get(rowIndexes.size()-1)).toString();
                        RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId +
                                SGSlackConstants.DELIMITER + SGSlackConstants.FAV_DATA+SGSlackConstants.DELIMITER +favName,actionVal,-1);
                        sendAsyncResponse(responseUrl, "{\"text\": \"Saved as *"+favName+"* Please try */sg favs* to look up all your favorites\" }");
                    }else if(SGSlackConstants.GET_FAV_DATA.equals(callbackId)){

                        logger.info("get fav action value=" + ir.getActions().get(0).getValue());
                        String appId = null, repId = null;
                        int tabOrd = 1;
                        List<Integer> rowIndexes = new ArrayList<Integer>();
                        String[] values = ir.getActions().get(0).getValue().split(SGSlackConstants.DELIMITER);
                        for (int i = 0; i < values.length; i++) {
                            if (i == 0) {
                                appId = values[i];
                            } else if (i == 1) {
                                repId = values[i];
                            } else if (i == 2) {
                                tabOrd = Integer.valueOf(values[i]);
                            } else {
                                if (values[i] != null && !values[i].isEmpty())
                                    rowIndexes.add(Integer.valueOf(values[i]));
                            }
                        }
                        logger.debug("row index size=" + rowIndexes.size());

                        ReportDetail rd = getRegReport(teamId, slackUserId, sessionId, repId, appId, m, true);

                        if (rd.getStatus() != 0) {
                            sendDetailRecord(rd, rowIndexes, responseUrl, tabOrd, appId, repId, teamId, slackUserId, sessionId,
                                    "*" + rd.getReportMetaData().getTabs().get(tabOrd - 1).getTabName() + "* data", false, false);
                        } else {
                            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
                        }
                    }
                } else {
                    sendAsyncResponse(responseUrl, getLoginLinkResponse(teamId, slackUserId));

                }
            }

        } else {
            //not from slack
        }

    }

    private int getTabIndex(ReportDetail rd, String tabId){
        int index = 0;
        for (com.sg.model.sgdsRs.repdet.Tab t: rd.getReportMetaData().getTabs()){
            if (t.getTemplate().getID().equals(tabId)){
                index = rd.getReportMetaData().getTabs().indexOf(t);
            }
        }
        logger.debug("Tab index="+index);
        return index;
    }

    private com.sg.model.sgdsRs.repdet.Action getActionById(List<com.sg.model.sgdsRs.repdet.Action> actions,
                                                            String actionId){
        com.sg.model.sgdsRs.repdet.Action retAct = null;
        for (com.sg.model.sgdsRs.repdet.Action act : actions ){
            if (actionId.equals(act.getID())){
                retAct = act;
                break;
            }
        }
        return retAct;
    }

    private Action populateAction(String name, String text, String value, String style, String type) {

        Action ac = new Action();
        ac.setText(text);
        ac.setName(name);
        ac.setValue(value);
        ac.setStyle(style);
        ac.setType(type);
        return ac;

    }

    /**
     * Get application list from SGDS
     * @param teamId
     * @param slackUserId
     * @param sessionId
     * @return Application
     * @throws IOException
     */
    private Application getAppList(String teamId, String slackUserId, String sessionId) throws IOException {
        String appListJson = SGDSClient.getAppList(sessionId);
        ObjectMapper mapper = new ObjectMapper();
        Application app = new Application();
        app = mapper.readValue(appListJson, app.getClass());
        return app;
    }

    private List<String> getAppIdsFromRepIds(String teamId, String slackUserId, Set<String> repIds, String sessionId) throws IOException {

        Application app = getAppList(teamId, slackUserId, sessionId);
        List<String> appIds = new ArrayList<String>();

        for (Application_ a : app.getApplications()) {
            for (Folder f : a.getFolders()) {
                for (Report r : f.getReports()) {
                    if (repIds.contains(r.getReportID())) {
                        appIds.add(a.getApplicationID());
                    }
                }
            }
        }
        return appIds;
    }

    private void handleMultipleRepCaseFromSearch(String teamId, String slackUserId, Set<String> repIds, String sessionId,
                                                 String responseUrl)
            throws IOException {
        List<String> appIds = getAppIdsFromRepIds(teamId, slackUserId, repIds, sessionId);
        logger.debug("appIds from search text=" + appIds.size());
        Set<String> uniqueAppIds = new HashSet<String>();
        for (String appId : appIds) {
            uniqueAppIds.add(appId);
        }
        logger.debug("unique app ids =" + uniqueAppIds.size());
        if (uniqueAppIds.size() == 1) {//more than 1 reports in a single application
            String appId = appIds.get(0); //all indexes have same values
            logger.info("App id = " + appId);
            logger.info("sesisonId=" + sessionId);

            Application app = getAppList(teamId, slackUserId, sessionId);
            logger.info("Apps size = " + app.getApplications().size());
            Application_ choosenApp = getApp(app.getApplications(), appId);
            logger.info("Choosend app name=" + choosenApp.getApplicationName());
            List<Report> reports = getReportsForApp(choosenApp);
            List<Action> actions = new ArrayList<Action>(reports.size());
            for (Report rep : reports) {
                actions.add(populateAction(rep.getReportName(), rep.getReportName(), appId + SGSlackConstants.DELIMITER + rep.getReportID(), "default", "button"));
            }
            sendAsyncResponse(responseUrl, getButtonRes("Please select a Report.", SGSlackConstants.GET_TAB_NAME, "#3AA3E3", actions, true));
        } else {//different applications found the search word

            Application app = getAppList(teamId, slackUserId, sessionId);
            List<Application_> filteredApp = new ArrayList<Application_>();
            for (Application_ a : app.getApplications()) {
                if (uniqueAppIds.contains(a.getApplicationID())) {
                    filteredApp.add(a);
                }
            }

            Application apps = getAppList(teamId, slackUserId, sessionId);
            //response sends application names as buttons. The next request is supposed to
            //get the report names for the clicked application.
            List<Action> actions = new ArrayList<Action>(filteredApp.size());
            for (Application_ a : filteredApp) {
                actions.add(populateAction(a.getApplicationName(), a.getApplicationName(), a.getApplicationID(), "default", "button"));
            }
            sendAsyncResponse(responseUrl, getButtonRes("Please select an application.",
                    SGSlackConstants.GET_REPORT_NAMES, "#3AA3E3", actions, true));
        }

    }

    private void handleSingleRepCaseFromSearch(Set<String> repIds, String searchText, String teamId,
                                               String slackUserId, String sessionId, String responseUrl,
                                               String repId) throws IOException {

        String appId = null;
        appId = getAppIdsFromRepIds(teamId, slackUserId, repIds, sessionId).get(0);
        logger.debug("Appid from repid = " + appId);
        ReportDetail repdet = getRegReport(teamId, slackUserId, sessionId, repIds.iterator().next(), appId, new ObjectMapper(),true );
        if (repdet.getStatus() != 0) {
            Map<Integer, List<Integer>> rowIndexesperTab = new HashMap<Integer, List<Integer>>();
            Set<Integer> tabOrds = new HashSet<Integer>();
            List<Datum> ds = repdet.getData().getData();
            for (Datum d : ds) {
                for (Row row : d.getRows()) {
                    logger.debug("Search text=" + searchText);
                    for (String val : row.getValues()) {
                        logger.debug("Row val = " + val);
                        if (StringUtils.containsIgnoreCase(val, searchText)) {
                            //check tab type that this row is part of-  make sure its a grid or list
                            //if ("SimpleGrid".equals(tabType) || "ListCollection".equals(tabType)) {
                            tabOrds.add(ds.indexOf(d) + 1);
                            if (rowIndexesperTab.get(ds.indexOf(d) + 1) == null) {
                                rowIndexesperTab.put(ds.indexOf(d) + 1, new ArrayList<Integer>());
                            }
                            rowIndexesperTab.get(ds.indexOf(d) + 1).add(d.getRows().indexOf(row));
                            //}
                        }
                    }
                }
            }

            logger.debug("Number of tabs with search text=" + tabOrds.size());
            if (tabOrds.size() > 1) {//start from tab drill down

                getTabNamesFromSearch(appId, repId, repdet, tabOrds, responseUrl, rowIndexesperTab, searchText);
            } else {//detail records
                logger.debug("TAB ORDINAL WITH search data" + tabOrds.iterator().next());
                logger.debug("Number of detail records" + rowIndexesperTab.get(tabOrds.iterator().next()).size());
                sendDetailRecord(repdet, rowIndexesperTab.get(tabOrds.iterator().next()), responseUrl,
                        tabOrds.iterator().next(), appId, repId, teamId, slackUserId, sessionId, "Search results for *" + searchText + "*", true, false);
            }
        } else {
            sendAsyncResponse(responseUrl, "{\"text\": \"`Unexpected Error - please retry`\" }");
        }

    }

    private void getTabNamesFromSearch(String appId, String repId, ReportDetail rd, Set<Integer> tabOrds, String responseUrl, Map<Integer, List<Integer>> rowIndexesPerTab,
                                       String searchText)
            throws IOException {

        logger.info("AppId = " + appId + " RepId = " + repId);
        List<com.sg.model.sgdsRs.repdet.Tab> tabs = rd.getReportMetaData().getTabs();   //getRelevantTabs(rd);
        List<Action> actions = new ArrayList<Action>(tabs.size());
        for (com.sg.model.sgdsRs.repdet.Tab tab : tabs) {
            if (tabOrds.contains(tab.getTabOrdinal())) {
                List<Integer> rowIndexes = rowIndexesPerTab.get(tab.getTabOrdinal());
                StringBuffer s = new StringBuffer("");
                for (int r : rowIndexes) {
                    s.append(r).append(SGSlackConstants.DELIMITER);
                }
                String rows = s.toString().substring(0, s.length() - SGSlackConstants.DELIMITER.length());
                logger.debug("Row indexes =" + rows);
                actions.add(populateAction(tab.getTabName(), tab.getTabName(), appId + SGSlackConstants.DELIMITER +
                        repId + SGSlackConstants.DELIMITER + tab.getTabOrdinal() + SGSlackConstants.DELIMITER + rows, "default", "button"));
            }
        }
        sendAsyncResponse(responseUrl, getButtonRes("*" + searchText + "* occurs in multiple tabs. Please *select a tab* to continue.",
                SGSlackConstants.GET_DETAIL_REC, "#3AA3E3", actions, true));
    }

    /**
     * Send report record response to slack
     * @param rd
     * @param rowIndexes
     * @param responseUrl
     * @param tabOrd
     * @param appId
     * @param repId
     * @param teamId
     * @param slackUserId
     * @param sessionId
     * @param resTitle
     * @param favAllowed
     * @param parameterized
     * @throws IOException
     */
    private void sendDetailRecord(ReportDetail rd, List<Integer> rowIndexes, String responseUrl,
                                  int tabOrd, String appId, String repId, String teamId, String slackUserId, String sessionId,
                                  String resTitle, boolean favAllowed, boolean parameterized)
            throws IOException {

        List<Row> selectedRows = new ArrayList<Row>();
        for (Integer i : rowIndexes) {
            selectedRows.add(rd.getData().getData().get(tabOrd - 1).getRows().get(i));
        }
        logger.debug("selected rows size=" + selectedRows.size());
        //get column titles
        List<GridColumn> gds = rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getGridColumns();
        List<String> colTitles = new ArrayList<String>(gds.size());
        List<String> displayCols = new ArrayList<String>(gds.size());
        for (GridColumn gd : gds) {
            colTitles.add(gd.getColumnFriendlyName());
            displayCols.add(gd.getDataItemColumnID());
        }
        List<Map<String, String>> buttonMapRowList = getReportNavigation(rd, selectedRows, appId, tabOrd, teamId,
                slackUserId, sessionId);
        com.sg.model.slackRs.detail.Attachment fav = null;
        //option to save detailed record as favorite
        if (favAllowed) {
            fav = getFavAction(appId, repId, tabOrd, rowIndexes);
        }

        if (selectedRows == null || selectedRows.size() == 0){
            sendAsyncResponse(responseUrl, "{\"text\": \"`No data found !!`\" }");
        }else {
            sendAsyncResponse(responseUrl, getRecord(resTitle, selectedRows, colTitles, buttonMapRowList, getActionButtons(rd, selectedRows, appId, repId, tabOrd, parameterized),
                    displayCols, fav));
        }

    }

    private com.sg.model.slackRs.detail.Attachment getFavAction(String appId, String repId, int tabOrd, List<Integer> rowIndexes){
        com.sg.model.slackRs.detail.Attachment att = new com.sg.model.slackRs.detail.Attachment();
        att.setText("");
        att.setFallback("");
        att.setCallbackId(SGSlackConstants.SAVE_FAV);
        att.setColor("#FFF380");
        att.setAttachmentType("default");

        StringBuffer s = new StringBuffer("");
        for (Integer i : rowIndexes){
            s.append(String.valueOf(i)).append(SGSlackConstants.DELIMITER);
        }
        String p = s.toString();
        p = p.substring(0,p.length());
        List<com.sg.model.slackRs.detail.Action> actions =
                new ArrayList<com.sg.model.slackRs.detail.Action>(1);
        com.sg.model.slackRs.detail.Action action = new com.sg.model.slackRs.detail.Action();
        action.setValue(appId+SGSlackConstants.DELIMITER+repId+SGSlackConstants.DELIMITER+String.valueOf(tabOrd)+SGSlackConstants.DELIMITER+
        p);
        action.setType("button");
        action.setText("Mark as favorite");
        action.setName("Mark as favorite");
        actions.add(action);
        att.setActions(actions);

        return att;
    }

    private List<com.sg.model.sgdsRs.repdet.Tab> getRelevantTabs(ReportDetail rd) {

        List<com.sg.model.sgdsRs.repdet.Tab> relevantTabs = new ArrayList<com.sg.model.sgdsRs.repdet.Tab>();
        for (com.sg.model.sgdsRs.repdet.Tab tab : rd.getReportMetaData().getTabs()) {
            if ("SimpleGrid".equals(tab.getTemplate().getType()) || "ListCollection".equals(tab.getTemplate().getType())) {
                relevantTabs.add(tab);
            }

        }
        return relevantTabs;

    }

    /**
     * Each button represents a potential action.
     * .
     * @param rd
     * @param selectedRows
     * @param appId
     * @param tabOrd
     * @param parameterized
     * @return
     */
    private List<Map<String, String>> getActionButtons(ReportDetail rd, List<Row> selectedRows, String appId, String repId, int tabOrd, boolean parameterized) {
        List<com.sg.model.sgdsRs.repdet.Action> actions = rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getActions();
        List<Map<String, String>> buttonMapFrRow = new ArrayList<Map<String, String>>(selectedRows.size());
        if (actions != null && actions.size() > 0) {
            for (Row row : selectedRows) {
                Map<String, String> b = new HashMap<String, String>();
                for (com.sg.model.sgdsRs.repdet.Action action : actions) {
                    //options
                    //check if action has a input of freeform text as required. If so do not expose it.
                    List<ActionParameter> actionParams = action.getActionParameters();
                    boolean expose = false;
                    //Only those actions will be exposed who have 1 mandatory parameter and that mandatory param is a
                    //DataItemSimpleList or login
                    String actionParamId = null;
                    if (actionParams == null || actionParams.size() == 0){
                        logger.debug("Adding action for no param"+appId + SGSlackConstants.DELIMITER + repId + SGSlackConstants.DELIMITER +
                                String.valueOf(tabOrd) + SGSlackConstants.DELIMITER +
                                rd.getData().getData().get(tabOrd-1).getRows().indexOf(row) + SGSlackConstants.DELIMITER + action.getID()+
                                SGSlackConstants.DELIMITER + "");
                        expose = true;
                        b.put(action.getActionName(), appId + SGSlackConstants.DELIMITER + repId + SGSlackConstants.DELIMITER +
                                String.valueOf(tabOrd) + SGSlackConstants.DELIMITER +
                                rd.getData().getData().get(tabOrd-1).getRows().indexOf(row) + SGSlackConstants.DELIMITER + action.getID()+
                                SGSlackConstants.DELIMITER + (parameterized?"P":""));

                    }else {
                        actionParamId = exposeAction(actionParams);
                        if (actionParamId != null && !actionParamId.isEmpty() && !"NA".equals(actionParamId)) {
                            expose = true;
                            b.put(action.getActionName(), appId + SGSlackConstants.DELIMITER + repId + SGSlackConstants.DELIMITER +
                                    String.valueOf(tabOrd) + SGSlackConstants.DELIMITER +
                                    rd.getData().getData().get(tabOrd-1).getRows().indexOf(row) + SGSlackConstants.DELIMITER + action.getID()+
                                    SGSlackConstants.DELIMITER + actionParamId + SGSlackConstants.DELIMITER + (parameterized?"P":""));
                        }
                    }
                    /*
                    if (expose) {
                        b.put(action.getActionName(), appId + SGSlackConstants.DELIMITER + repId + SGSlackConstants.DELIMITER +
                                String.valueOf(tabOrd) + SGSlackConstants.DELIMITER +
                                rd.getData().getData().get(tabOrd-1).getRows().indexOf(row) + SGSlackConstants.DELIMITER + action.getID()+
                                SGSlackConstants.DELIMITER + actionParamId);
                    }
                    */
                }
                buttonMapFrRow.add(b);
            }
        }
        return buttonMapFrRow;
    }


    private String exposeAction(List<ActionParameter> actionParams) {

        String retId = null;
        int mandCount = 0;
        for (ActionParameter ap: actionParams){
            if (ap.getIsMandatory()){
                mandCount++;
            }
        }

        if (mandCount == 0){
            retId = "NA";
        }else if (mandCount == 1){
            for (ActionParameter ap: actionParams){
                if (ap.getIsMandatory()){
                    if ("List".equals(ap.getParameterType()) || "DataItemSimpleList".equals(ap.getParameterType())
                            || "Login".equalsIgnoreCase(ap.getParameterType())){
                        retId=ap.getID();
                    }
                }
            }
        }else{
            return null;
        }

        return retId;

    }

    /**
     * Get regular report from cache.If not in cache, retrieve from SGDS and cache it for 4 hours.
     * @param teamId
     * @param slackUserId
     * @param sessionId
     * @param repId
     * @param appId
     * @param m
     * @param cached
     * @return ReportDetail
     * @throws IOException
     */
    private ReportDetail getRegReport(String teamId, String slackUserId, String sessionId, String repId, String appId,
                                      ObjectMapper m, boolean cached)
            throws IOException {

        String repJson = null;
        logger.debug("cached = "+cached);
        if (cached) {
            repJson = RedisManager.get(teamId + SGSlackConstants.DELIMITER + slackUserId +
                    SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId);
        }
        if (repJson == null || repJson.isEmpty()) {
            logger.debug("Rep json is empty so getting from backend");
            RegReportRq r = new RegReportRq();
            r.setApplicationID(appId);
            r.setReportID(repId);
            r.setSessionID(sessionId);
            repJson = SGDSClient.getRegularReport(r);
        }
        ReportDetail rd = new ReportDetail();
        rd = m.readValue(repJson, rd.getClass());
        if (rd.getStatus() != 0) {
            RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId +
                    SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId, repJson, 14400);
        }
        return rd;

    }

    private ParametersMain getParametersMain(String appId, String repId, String sessionId,
                                             ObjectMapper m) throws IOException {

        ParametersMainRq parametersMainRq = new ParametersMainRq();
        parametersMainRq.setApplicationID(appId);
        parametersMainRq.setReportID(repId);
        parametersMainRq.setSessionID(sessionId);

        String paramMainJson = SGDSClient.getParamsMain(parametersMainRq);
        ParametersMain rs = new ParametersMain();
        rs = m.readValue(paramMainJson, rs.getClass());

        return rs;
    }

    private ReportDetail getParamReport(String sessionId, String appId, String repId, List<Parameter> params,
                                        ObjectMapper m, String teamId, String slackUserId) throws IOException {
        ParametrizedReportRequest prr = new ParametrizedReportRequest();
        prr.setSessionID(sessionId);
        prr.setApplicationID(appId);
        prr.setReportID(repId);
        prr.setRequestID(sessionId);
        prr.setParameters(params);

        String paramRepJson = SGDSClient.getParamReport(prr);
        ReportDetail rd = new ReportDetail();
        rd = m.readValue(paramRepJson, rd.getClass());
        if (rd.getStatus() != 0) {
            RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId +
                    SGSlackConstants.DELIMITER + SGSlackConstants.REP_DETAIL_JSON + SGSlackConstants.DELIMITER + repId, paramRepJson, 14400);
        }
        return rd;
    }

    /**
     * This gets all the navigations from the current report which can be a shared slicer navigation or navigation to a parametrized report.
     * @param rd
     * @param selectedRows
     * @param appId
     * @param tabOrd
     * @param teamId
     * @param slackUserId
     * @param sessionId
     * @return List<Map<String, String>>
     *      List <destination report name, appId:repId:col value of slicerColId:tabId:"SLICER_NAV"
     *      List <destination report name, appId:repId:col value of slicerColId:tabId:"PARAM_NAV"
     * @throws IOException
     */
    private List<Map<String, String>> getReportNavigation(ReportDetail rd, List<Row> selectedRows, String appId, int tabOrd, String teamId, String slackUserId, String sessionId) throws IOException {

        logger.debug("Report =" + rd.getReportMetaData().getReportName() + " selected row=" + selectedRows.size() +
                " appId=" + appId + " tab=" + tabOrd);
        List<GridColumn> gds = rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getGridColumns();
        List<String> colTitles = new ArrayList<String>(gds.size());
        for (GridColumn gd : gds) {
            colTitles.add(gd.getColumnFriendlyName());
        }

        List<GridColumn> gridCols = rd.getReportMetaData().getTabs().get(tabOrd - 1).getTemplate().getGridColumns();
        List<Map<String, String>> buttonMapRowList = new ArrayList<Map<String, String>>(selectedRows.size());
        //list needed as there can be 2 maps - 1 slicer and 2 param navigation
        for (Row r : selectedRows) {
            Map<String, String> b = new HashMap<String, String>();
            for (GridColumn gc : gridCols) {
                if (gc.getNavigation() != null) {//slicer or param rep
                    //params to be sent are: dest repid, value of the slicer column, slicer
                    //id ( only useful if there are multiple slicer navigations)
                    String repName = getReportNameFromRepId(teamId, slackUserId, gc.getNavigation().getOpenReport(),
                            sessionId);

                    if (gc.getNavigation().getNavigationMappings() != null &&
                            gc.getNavigation().getNavigationMappings().size() > 0) {
                        //TODO handle all navigations right now handles just 1st
                        //button text, button value - appid:repId:filter col value
                        logger.debug(" Col Id for nav=" + gc.getNavigation().
                                getNavigationMappings().get(0).getValue());
                        logger.debug("slicer param=" + r.getColVal(gc.getNavigation().
                                getNavigationMappings().get(0).getValue()));

                        //if (gc.getNavigation().getOpenTemplate() == null || gc.getNavigation().getOpenTemplate().isEmpty()){
                            b.put(repName,
                                new StringBuffer(appId).append(SGSlackConstants.DELIMITER)
                                        .append(gc.getNavigation().getOpenReport()).append(SGSlackConstants.DELIMITER).
                                        append(r.getColVal(gc.getNavigation().
                                                getNavigationMappings().get(0).getValue())).append(
                                        SGSlackConstants.DELIMITER).append(gc.getNavigation().getOpenTemplate()).
                                        append(SGSlackConstants.DELIMITER).append(SGSlackConstants.SLICER_NAV).toString());
                        //}

                    }
                    if (gc.getNavigation().getNavigationParametersMappings() != null &&
                            gc.getNavigation().getNavigationParametersMappings().size() > 0) {
                        //parametrized report
                        //params to be sent are appid, repid, param id (for the parameter to fetch next report
                        //TODO handle all navigations right now handles just 1st
                        //if (gc.getNavigation().getOpenTemplate() == null || gc.getNavigation().getOpenTemplate().isEmpty()) {
                            b.put(repName, new StringBuffer(appId).append(SGSlackConstants.DELIMITER)
                                    .append(gc.getNavigation().getOpenReport()).append(SGSlackConstants.DELIMITER).
                                            append(r.getColVal(gc.getNavigation().
                                                    getNavigationParametersMappings().get(0).getDataItemColumnID())).append(SGSlackConstants.DELIMITER).
                                                    append(gc.getNavigation().getOpenTemplate()).
                                                    append(SGSlackConstants.DELIMITER).
                                            append(SGSlackConstants.PARAM_NAV).toString());
                        //}

                    }
                }
            }
            logger.debug("Num of nav buttons per row = " + b.size());
            if (b.size() > 0) {
                buttonMapRowList.add(b);
            }
        }
        return buttonMapRowList;
    }

    private String getReportNameFromRepId(String teamId, String slackUserId, String repId, String sessionId) throws IOException {

        Application apps = getAppList(teamId, slackUserId, sessionId);
        String repName = null;
        for (Application_ app : apps.getApplications()) {
            List<Folder> folders = app.getFolders();
            for (Folder folder : folders) {
                for (Report rep : folder.getReports()) {
                    if (repId.equals(rep.getReportID())) {
                        repName = rep.getReportName();
                        break;
                    }
                }
                if (repName != null) break;
            }
            if (repName != null) break;
        }

        return repName;

    }


    /*
    {
                            "text": "Please select an application. ",
                                "attachments": [
                            {
                                "fallback": "Please select an application",
                                    "callback_id": "comic_1234_xyz",
                                    "color": "#3AA3E3",
                                    "attachment_type": "default",
                                    "actions": [
                                {
                                    "name": "recommend",
                                        "text": "Recommend",
                                        "type": "button",
                                        "value": "recommend",
                                        "style":"default"
                                },
                                {
                                    "name": "no",
                                        "text": "No",
                                        "type": "button",
                                        "value": "bad",
                                        "style":"default"
                                }
                                ]
                            }
                            ],
                            "response_type":"ephemeral",
                                "replace_original":false,
                                "delete_original":false
                        }
     */

    private String getButtonRes(String text, String callbackId, String color, List<Action> actions, boolean replaceOriginal) throws IOException {

        ButtonRes b = new ButtonRes();
        b.setText(text);
        int numOfAtts = 0;
        logger.debug("actions size=" + actions.size());
        if (actions.size() % 5 == 0) {
            numOfAtts = actions.size() / 5;
        } else {
            numOfAtts = ((actions.size() + (5 - actions.size() % 5)) / 5);
        }

        List<Attachment> atts = new ArrayList<Attachment>((actions.size() + (5 - actions.size() % 5)) / 5);
        for (int i = 0; i < numOfAtts; i++) {
            logger.debug("Adding attachemnt" + i);
            Attachment a = new Attachment();
            a.setFallback(text);
            a.setCallbackId(callbackId);
            a.setColor(color);
            a.setAttachmentType("default");
            List<Action> temp = new ArrayList<Action>();
            for (int j = i * 5; j < ((i * 5) + 5 <= actions.size() ? (i * 5) + 5 : actions.size()); j++) {
                logger.debug("Adding action for att" + i);
                temp.add(actions.get(j));
            }
            a.setActions(temp);
            atts.add(a);
        }
        b.setReplaceOriginal(false);
        b.setAttachments(atts);
        b.setReplaceOriginal(replaceOriginal);

        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(b);

    }


    private String getButtonRes(String text, String callbackId, String color, Set<String> buttonText,
                                Map<String, List<String>> buttonValues, Map<String, String> parentId) throws IOException {

        ButtonRes b = new ButtonRes();
        b.setText(text);
        Attachment a = new Attachment();
        a.setFallback(text);
        a.setCallbackId(callbackId);
        a.setColor(color);
        a.setAttachmentType("default");
        List<Action> actions = new ArrayList<Action>(buttonText.size());
        for (String button : buttonText) {
            Action ac = new Action();
            ac.setName(button);
            ac.setText(button);
            List<String> buttonValue = buttonValues.get(button);
            StringBuffer csvVal = new StringBuffer("");
            logger.debug("number of rows with val=" + buttonValue.size() + " for button text " + button);
            for (String rowIndex : buttonValue) {
                logger.debug("rowIndex =" + rowIndex);
                csvVal.append(rowIndex).append(SGSlackConstants.DELIMITER);
                logger.debug("Row Index in process=" + csvVal.toString());
            }
            String csv = csvVal.toString();
            logger.debug("Row Index values=" + csv);
            csv = csv.substring(0, csv.length() - SGSlackConstants.DELIMITER.length());
            logger.debug("Row Index values=" + csv);
            ac.setValue(parentId.get(SGSlackConstants.PARENT_ID_APP) + SGSlackConstants.DELIMITER + parentId.get
                    (SGSlackConstants.PARENT_ID_REP)
                    + SGSlackConstants.DELIMITER + parentId.get
                    (SGSlackConstants.PARENT_ID_TAB_ORDINAL)
                    + SGSlackConstants.DELIMITER + csv);
            ac.setStyle("default");
            ac.setType("button");
            actions.add(ac);
        }
        a.setActions(actions);
        List<Attachment> atts = new ArrayList<Attachment>(1);
        atts.add(a);
        b.setAttachments(atts);
        b.setReplaceOriginal(false);
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(b);

    }

    public static String getRecord(String repName, List<Row> rows, List<String> colTitles,
                                   List<Map<String, String>> buttonMapRowList, List<Map<String,
            String>> actionButtonPerRowList, List<String> displayColId, com.sg.model.slackRs.detail.Attachment favButton)
            throws IOException {

        RecordDetail rd = new RecordDetail();
        rd.setText(repName);
        logger.debug("Rows size = " + rows.size());
        List<com.sg.model.slackRs.detail.Attachment> atts = new ArrayList<com.sg.model.slackRs.detail.Attachment>(rows.size());
        for (Row row : rows) {
            List<String> colValues = row.getValues();
            List<Field> fields = new ArrayList<Field>(colValues.size());

            logger.debug("Num of columns=" + colTitles.size() + " " + colValues.size()+" displayColId size ="+displayColId.size());

            for (String colId : displayColId) {
                Field f = new Field();
                f.setValue(row.getColVal(colId));
                f.setTitle(colTitles.get(displayColId.indexOf(colId)));
                f.setShort(true);
                fields.add(f);
            }


            com.sg.model.slackRs.detail.Attachment att = new com.sg.model.slackRs.detail.Attachment();
            att.setFields(fields);
            att.setColor("#3AA3E3");
            if (buttonMapRowList != null && buttonMapRowList.size() > 0) {
                Map<String, String> buttons = buttonMapRowList.get(rows.indexOf(row));
                if (buttons != null && buttons.size() > 0) {
                    att.setText("");
                    att.setFallback("");
                    att.setCallbackId(SGSlackConstants.GET_NAV_REP_DET);
                    att.setAttachmentType("default");
                    List<com.sg.model.slackRs.detail.Action> actions =
                            new ArrayList<com.sg.model.slackRs.detail.Action>(buttons.size());
                    for (Map.Entry<String, String> ent : buttons.entrySet()) {
                        com.sg.model.slackRs.detail.Action action = new com.sg.model.slackRs.detail.Action();
                        action.setName(ent.getKey());
                        action.setText(ent.getKey());
                        action.setType("button");
                        action.setValue(ent.getValue());
                        actions.add(action);
                    }
                    att.setActions(actions);
                }
            }
            atts.add(att);

            if (actionButtonPerRowList != null && actionButtonPerRowList.size() > 0) {
                Map<String, String> buttons = actionButtonPerRowList.get(rows.indexOf(row));
                com.sg.model.slackRs.detail.Attachment att2 = new com.sg.model.slackRs.detail.Attachment();
                if (buttons != null && buttons.size() > 0) {
                    att2.setText("");
                    att2.setFallback("");
                    att2.setCallbackId(SGSlackConstants.ACTION_REQ);
                    att2.setColor("#3AA3E3");
                    att2.setAttachmentType("default");
                    List<com.sg.model.slackRs.detail.Action> actions =
                            new ArrayList<com.sg.model.slackRs.detail.Action>(buttons.size());
                    for (Map.Entry<String, String> ent : buttons.entrySet()) {
                        com.sg.model.slackRs.detail.Action action = new com.sg.model.slackRs.detail.Action();
                        action.setName(ent.getKey());
                        action.setText(ent.getKey());
                        action.setType("button");
                        action.setValue(ent.getValue());
                        actions.add(action);
                    }
                    att2.setActions(actions);
                }
                atts.add(att2);
            }
        }
        logger.debug("Atts size = "+atts.size());
        if (favButton != null) {
            atts.add(favButton);
        }
        rd.setAttachments(atts);
        ObjectMapper m = new ObjectMapper();
        logger.debug("Detailed record" + m.writeValueAsString(rd));
        return m.writeValueAsString(rd);
    }

    /**
     * Getan application from application list
     * @param apps
     * @param appId
     * @return Application_
     */
    private Application_ getApp(List<Application_> apps, String appId) {
        Application_ a = new Application_();
        for (Application_ app : apps) {
            if (appId.equals(app.getApplicationID())) {
                a = app;
                break;
            }
        }
        return a;
    }

    /**
     * Get all reports in an application
     * @param app
     * @return list of reports
     */
    private List<Report> getReportsForApp(Application_ app) {
        List<Report> reports = new ArrayList<Report>();
        for (Folder f : app.getFolders()) {
            for (Report r : f.getReports()) {
                if (!r.getIsHidden()) {
                    //if (gridorlistExists(r)) {
                    logger.info("Adding report named " + r.getReportName());
                    reports.add(r);
                    //}
                }
            }
        }
        return reports;
    }

    private boolean gridorlistExists(Report r) {
        boolean exists = false;
        for (Tab t : r.getTabs()) {
            if ("SimpleGrid".equals(t.getTabTemplate().getTemplateType()) ||
                    "ListCollection".equals(t.getTabTemplate().getTemplateType())) {
                exists = true;
                break;
            }
        }
        return exists;

    }


    private void sendAsyncResponse(String responseUrl, String responseJson) throws IOException {

        HttpPost postRequest = new HttpPost(responseUrl);
        postRequest.setHeader("Content-Type", "application/json");
        StringEntity slackRes = new StringEntity(responseJson);
        postRequest.setEntity(slackRes);
        CloseableHttpResponse res = SGDSClient.getHttpClient().execute(postRequest);
        try {
            HttpEntity resEnt = res.getEntity();
            EntityUtils.consume(resEnt);
        } finally {
            res.close();
        }
    }


    /**
     * For SGDS sessions that are not active, this reposne is to be sent.
     *
     * @param teamId
     * @param slackUserId
     * @return JSON response string.
     * @throws IOException
     */
    private String getLoginLinkResponse(String teamId, String slackUserId) throws IOException {

        //get email that is a common id between sgds and slack
        HttpPost postRequest = new HttpPost("https://slack.com/api/users.profile.get");
        String token = RedisManager.get(teamId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_TOKEN);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("token", token));
        nvps.add(new BasicNameValuePair("user", slackUserId));
        postRequest.setEntity(new UrlEncodedFormEntity(nvps));

        CloseableHttpResponse responseApps = SGDSClient.getHttpClient().execute(postRequest);
        String wbRes = "";
        try {
            HttpEntity entityApps = responseApps.getEntity();
            wbRes = EntityUtils.toString(entityApps, "UTF-8");
            logger.debug("User profile response = " + wbRes);
            EntityUtils.consume(entityApps);
        } finally {
            responseApps.close();
        }

        SlackUserProfile s = new SlackUserProfile();
        ObjectMapper m = new ObjectMapper();
        s = m.readValue(wbRes, s.getClass());
        String response = null;
        if (s.getOk()) {
            response = JsonUtil.createLoginLinkResponse(slackUserId, s.getProfile().getEmail(), teamId);
        } else {
            response = JsonUtil.createAuthLinkResponse();
        }

        return response;
    }

    /**
     * Get slack user id, access token, team name and team id from slack access token response.
     * Cache these details in Redis. Set suid and email as request attributes for login page if needed.
     *
     * @param tokenResponse Sample token response - {"ok":true,"access_token":"value","scope":"identify,commands",
     *                      "user_id":"id","team_name":"name","team_id":"id"}
     * @param req
     * @throws IOException
     */
    public void processSlackDetailsForCurrentUser(String tokenResponse, HttpServletRequest req) throws IOException {

        ObjectMapper m = new ObjectMapper();
        TokenResponse t = new TokenResponse();
        t = m.readValue(tokenResponse, t.getClass());
        String slackUserId = t.getUserId(), token = t.getAccessToken(), teamName = t.getTeamName(), teamId = t.getTeamId();
        logger.info("slackUserId=" + slackUserId + " token=" + token + " teamName=" + teamName + " teamId" + teamId);

        //get email from slack user profile that is a common id between sgds and slack
        HttpPost postRequest = new HttpPost("https://slack.com/api/users.profile.get");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("token", token));
        nvps.add(new BasicNameValuePair("user", slackUserId));
        postRequest.setEntity(new UrlEncodedFormEntity(nvps));

        CloseableHttpResponse responseApps = SGDSClient.getHttpClient().execute(postRequest);
        String wbRes = "";
        try {
            HttpEntity entityApps = responseApps.getEntity();
            wbRes = EntityUtils.toString(entityApps, "UTF-8");
            logger.debug("User profile response = " + wbRes);
            EntityUtils.consume(entityApps);
        } finally {
            responseApps.close();
        }
        SlackUserProfile s = new SlackUserProfile();
        s = m.readValue(wbRes, s.getClass());

        //store in redis
        //team based data
        RedisManager.store(teamId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_TOKEN, token, -1);
        //user based data
        RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_SGDS_EMAIL, s.getProfile().getEmail(), -1);
        RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_TEAM_ID, teamId, -1);
        RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_TEAM_NAME, teamName, -1);
        //For login page
        req.setAttribute("SUID", slackUserId);
        req.setAttribute("EMAIL", s.getProfile().getEmail());

    }


    /**
     * Get HttpClient for making REST ws calls
     *
     * @return
     */
    public CloseableHttpClient getHttpClient() {
        return HttpClients.createDefault();
    }


    /**
     * This method validates the SGDS session for a particular user.
     * Invalid session results in the following response:
     * {
     * "Applications": null,
     * "ExternalCredentials": null,
     * "Msg": "Failed to get Applications list: Session Is Not Valid",
     * "Status": -1
     * }
     *
     * @param slackUserId
     * @return
     */

    private String validateSession(String teamId, String slackUserId) throws IOException {

        String sessionId = RedisManager.get(teamId + SGSlackConstants.DELIMITER +
                slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SGDS_SESSIONID);
        if (sessionId != null && !sessionId.isEmpty()) {
            String appStr = SGDSClient.getAppList(sessionId);
            Application app = new Application();
            ObjectMapper mapper = new ObjectMapper();
            app = mapper.readValue(appStr, app.getClass());
            if (app.getStatus() != 0)
                return sessionId;
            else
                return null;
        } else {
            return null;
        }

    }


}
