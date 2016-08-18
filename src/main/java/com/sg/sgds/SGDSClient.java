package com.sg.sgds;

import com.sg.model.sgdsRq.ParametrizedReportRequest;
import com.sg.model.sgdsRq.RegReportRq;
import com.sg.model.sgdsRq.action.ActionDataRq;
import com.sg.model.sgdsRq.action.CheckWriteBackRq;
import com.sg.model.sgdsRq.paramRq.ParametersMainRq;
import com.sg.model.sgdsRq.writeback.WritebackRq;
import com.sg.model.sgdsRs.SGDSAuthRes;
import com.sg.utils.Config;
import com.sg.utils.SGSlackConstants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ayush on 6/29/16.
 */
public class SGDSClient {

    private static final Logger logger = LoggerFactory.getLogger(SGDSClient.class);

    public static String checkWBStatus(CheckWriteBackRq chq) throws IOException {

        ObjectMapper m = new ObjectMapper();

        StringEntity inputApps = new StringEntity(m.writeValueAsString(chq));
        return postSGDS("CheckWriteBackStatus", inputApps);


    }

    public static String authenticate(String userName, String password) throws IOException {
        if (userName == null || userName.isEmpty())
            userName = SGSlackConstants.DEFAULT_USER;
        if (password == null || password.isEmpty())
            password = SGSlackConstants.PASSWORD;

        ObjectMapper m = new ObjectMapper();
        ObjectNode o = m.createObjectNode();
        o.put("UserName",userName);
        o.put("Password",password);
        o.put("OS","webapp");
        o.put("Version","4006000");

        StringEntity input = new StringEntity(o.toString());

        SGDSAuthRes ss = new SGDSAuthRes();
        ss = m.readValue(postSGDS("Authenticate",input), ss.getClass());

        logger.debug("Session id on authentication="+ss.getSessionID());
        return ss.getSessionID();
    }

    public static String getAppList(String sessionId) throws IOException {

        if (sessionId == null || sessionId.isEmpty())
            throw new IllegalArgumentException("Session Id is empty. Please login.");

        ObjectMapper m = new ObjectMapper();
        ObjectNode o = m.createObjectNode();
        o.put("SessionID",sessionId);
        StringEntity inputApps = new StringEntity(o.toString());
        return postSGDS("GetAppsList", inputApps);
    }

    private static String postSGDS(String requestPath, StringEntity input) throws IOException {

        HttpPost postRq = new HttpPost(Config.getPropertyValue("SGDS_URL")+requestPath);
        postRq.setHeader("Content-Type", "application/json");
        postRq.setEntity(input);

        CloseableHttpResponse res = null;
        String resStr = null;
        HttpEntity resEnt = null;
        res = getHttpClient().execute(postRq);
        try {
            resEnt = res.getEntity();
            resStr = EntityUtils.toString(resEnt, "UTF-8");
            EntityUtils.consume(resEnt);
        }finally {
            res.close();
        }
        logger.debug("Call="+requestPath+" response="+resStr);
        return resStr;
    }


    public static CloseableHttpClient getHttpClient(){

        return HttpClients.createDefault();
    }

    public static String getRegularReport(RegReportRq r) throws IOException {

        ObjectMapper m = new ObjectMapper();

        StringEntity inputApps = new StringEntity(m.writeValueAsString(r));
        String reportStr  = postSGDS("GetReport_Regular4", inputApps);

        logger.debug("Report="+reportStr);
        return reportStr;
    }

    public static String getParamsMain(ParametersMainRq prq) throws IOException {
        ObjectMapper m = new ObjectMapper();
        StringEntity input = new StringEntity(m.writeValueAsString(prq));
        String paramMainRs = postSGDS("GetReport_ParametersMainScreen4", input);

        logger.debug("Param main rs="+paramMainRs);
        return paramMainRs;
    }

    public static String getParamReport(ParametrizedReportRequest prr) throws IOException {
        ObjectMapper m = new ObjectMapper();
        StringEntity input = new StringEntity(m.writeValueAsString(prr));
        String paramRepRs = postSGDS("GetReport_Parameterized4", input);

        logger.debug("Param report rs="+paramRepRs);
        return paramRepRs;
    }

    public static String getActionData(ActionDataRq adr) throws IOException {
        ObjectMapper m = new ObjectMapper();
        StringEntity inp = new StringEntity(m.writeValueAsString(adr));
        String actionDataRs = postSGDS("GetActionData4", inp);

        logger.debug("Action Data rs="+actionDataRs);
        return actionDataRs;
    }

    public static String writeback(WritebackRq wbrq) throws IOException {
        ObjectMapper m = new ObjectMapper();
        StringEntity inp = new StringEntity(m.writeValueAsString(wbrq));
        String wbRes = postSGDS("Send_Write_Back_Request", inp);

        logger.debug("WB res="+wbRes);
        return wbRes;
    }

    public static String getParameterList(String sessionId, String appId, String repId, String repUpId) throws IOException {

        //
        if (sessionId == null || sessionId.isEmpty())
            throw new IllegalArgumentException("Session Id is empty. Please login.");

        HttpPost postRequest = new HttpPost("https://wspublisherv2https.skygiraffe.com/WSPublisherV2.svc/GetReport_ParametersMainScreen4");

        // add header
        postRequest.setHeader("Content-Type", "application/json");

        JsonNodeFactory f = JsonNodeFactory.instance;

        ObjectNode o = f.objectNode();

        o.put("ApplicationID", appId);
        o.put("ReportID", repId);
        o.put("TabID","");

        ArrayNode diuId = f.arrayNode();
        diuId = o.putArray("DataItemUpdateIDs");
        o.put("ReportUpdateID",repUpId);
        o.put("RequestID",sessionId);

        o.put("SessionID",sessionId);

        StringEntity inputApps = new StringEntity(o.toString());

        inputApps.setContentType("application/json");
        postRequest.setEntity(inputApps);

        CloseableHttpResponse responseParams = getHttpClient().execute(postRequest);
        String paramStr = "";
        try {
            HttpEntity entityApps = responseParams.getEntity();
            paramStr = EntityUtils.toString(entityApps, "UTF-8");
            EntityUtils.consume(entityApps);
        }finally{
            responseParams.close();
        }
        logger.debug("Params = "+paramStr);
        return paramStr;
    }

    /**

    public static String getParametrizedReport(String sessionId, String appId, String repId, String repUpId, List<> params) throws IOException {

        if (sessionId == null || sessionId.isEmpty())
            throw new IllegalArgumentException("Session Id is empty. Please login.");

        HttpPost postRequest = new HttpPost("https://wspublisherv2https.skygiraffe.com/wspublisherv2.svc/GetReport_Parameterized4");

        // add header
        postRequest.setHeader("Content-Type", "application/json");

        JsonNodeFactory f = JsonNodeFactory.instance;

        ObjectNode o = f.objectNode();

        o.put("ApplicationID", appId);
        o.put("ReportID", repId);
        o.put("TabID","");
        ArrayNode diuId = f.arrayNode();
        diuId = o.putArray("DataItemUpdateIDs");
        o.put("ReportUpdateID",repUpId);
        o.put("RequestID",sessionId);

        ArrayNode paramsArr = o.putArray("Parameters");
        for (ReportParameter param : params){
            ObjectNode e = f.objectNode();
            e.put("ParameterID", param.getId());
            e.put("ParameterLabel",param.getLabel());
            e.put("ValueID", param.getValue());
            e.put("ValueLabel",param.getValue());
            paramsArr.add(e);
        }

        o.put("SessionID",sessionId);

        StringEntity inputApps = new StringEntity(o.toString());

        inputApps.setContentType("application/json");
        postRequest.setEntity(inputApps);

        HttpResponse responseApps = getHttpClient().execute(postRequest);
        HttpEntity entityApps = responseApps.getEntity();
        String reportStr = EntityUtils.toString(entityApps, "UTF-8");
        logger.debug("Report_bkp = "+reportStr);
        return reportStr;

    }
     **/



    public static String writeback(String appId, String repId, String tabId, String reportUpdateID, Map<String,String> row,
                                    String actionId, String paramId, String value, String sessionId) throws IOException {

        JsonNodeFactory f = JsonNodeFactory.instance;
        ObjectNode wb = f.objectNode();
        wb.put("ApplicationID",appId);
        wb.put("ReportID",repId);
        wb.put("TabID",tabId);
        ArrayNode diu = wb.putArray("DataItemUpdateIDs");
        wb.put("ReportUpdateID",reportUpdateID);
        wb.put("RequestID",sessionId);
        ObjectNode wbData = f.objectNode();
        ArrayNode rows = wbData.putArray("Rows");
        ObjectNode dataObj = f.objectNode();
        ArrayNode data = dataObj.putArray("Data");
        for (Map.Entry<String,String> entry : row.entrySet()){
            ObjectNode key = f.objectNode();
            key.put("Name",entry.getKey());
            //JsonObject val = new JsonObject();
            key.put("Value", entry.getValue());
            data.add(key);
            //data.add(val);
        }

        rows.add(dataObj);


        ObjectNode action = f.objectNode();
        action.put("ActionID",actionId);
        ArrayNode par = action.putArray("parameters");
        ObjectNode parId = f.objectNode();
        parId.put("ParameterID", paramId);
        //JsonObject selVal = new JsonObject();
        parId.put("SelectedValue",value);
        par.add(parId);
        //par.add(selVal);
        wbData.put("Action",action);
        wb.put("WB_Data",wbData);
        wb.put("SessionID",sessionId);

        HttpPost postRequest = new HttpPost("https://wspublisherv2https.skygiraffe.com/wspublisherv2.svc/Send_Write_Back_Request");

        // add header
        postRequest.setHeader("Content-Type", "application/json");

        StringEntity wbRq = new StringEntity(wb.toString());

        wbRq.setContentType("application/json");
        postRequest.setEntity(wbRq);

        CloseableHttpResponse responseApps = getHttpClient().execute(postRequest);
        String wbRes = "";
        try {
            HttpEntity entityApps = responseApps.getEntity();
            wbRes = EntityUtils.toString(entityApps, "UTF-8");
            EntityUtils.consume(entityApps);
        }finally{
            responseApps.close();
        }
        logger.debug("Report_bkp = "+wbRes);
        return wbRes;

    }

    /**

    public static void sendSlackResponse(String url, String msg) throws IOException {
        /**
         * {
         "text": "Inventory Inquiry",
         "attachments": [
         {"text":"Reorder completed"}
         ]
         }
         */
/**
        JsonObject res = new JsonObject();
        res.addProperty("text","");
        JsonArray attachments = new JsonArray();
        JsonObject att = new JsonObject();
        att.addProperty("text",msg);
        att.addProperty("color","#41d441");
        attachments.add(att);
        res.add("attachments",attachments);
        JsonArray actions = new JsonArray();
        JsonObject action2 = new JsonObject();
        action2.addProperty("name", "New");
        action2.addProperty("text", "View recent orders");
        action2.addProperty("type","button");
        action2.addProperty("value","orders");
        actions.add(action2);
        JsonObject att2 = new JsonObject();
        att2.addProperty("fallback","View inventory record.");
        att2.addProperty("callback_id", "orders");
        att2.addProperty("color", "#3AA3E3");
        att2.addProperty("attachment_type", "default");
        att2.add("actions",actions);
        attachments.add(att2);
        res.add("attachments",attachments);
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader("Content-Type", "application/json");
        StringEntity resEnt = new StringEntity(res.toString());
        postRequest.setEntity(resEnt);
        HttpResponse responseFromSlack = getHttpClient().execute(postRequest);

    }

*/

}
