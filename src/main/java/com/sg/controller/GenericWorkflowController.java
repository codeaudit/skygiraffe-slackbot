package com.sg.controller;

import com.sg.model.slackRq.Payload;
import com.sg.model.slackRs.SlackTeamInfo;
import com.sg.redis.RedisManager;
import com.sg.sgds.SGDSClient;
import com.sg.utils.Config;
import com.sg.utils.MyAsyncUncaughtExceptionHandler;
import com.sg.utils.SGSlackConstants;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by ayush on 7/12/16.
 */
@Configuration
@ComponentScan(basePackages = "com.sg")
@Controller
@EnableAsync
public class GenericWorkflowController implements AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(GenericWorkflowController.class);

    @Autowired
    GenericWorkFlowAsyncService asyncService;

    /**
     * This is the method that executes when Slack sends a request through a slash command or interactive message.
     *
     * @param param
     * @param request
     * @param httpSession
     * @return Acknowledgement, acual message would be sent by the asynchronous method that executes the request.
     * @throws IOException
     */
    @RequestMapping(value = SGSlackConstants.BASE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String getSGData(@RequestParam(value = "text", defaultValue = "") String param, HttpServletRequest request, HttpSession httpSession) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        //acknowledge right away
        logger.debug("In generic workflow controller");
        String res = "";
        if (param != null && !param.isEmpty()) {


            asyncService.handleRequestsAsync(request.getParameter("token"), null, param, request.getParameter("user_id"),
                    request.getParameter("team_id"), request.getParameter("response_url"));
            res = "";
        } else if (request.getParameter("payload") != null && !request.getParameter("payload").isEmpty()) {
            ObjectMapper m = new ObjectMapper();
            Payload p = new Payload();
            try {
                p = m.readValue(request.getParameter("payload"), p.getClass());
            } catch (Exception e) {
                logger.error("Object mapper read threw error", e);
            }

            asyncService.handleRequestsAsync(p.getToken(), request.getParameter("payload"),
                    param, p.getUser().getId(), p.getTeam().getId(),
                    p.getResponseUrl());

            // JsonNodeFactory f = JsonNodeFactory.instance;
            //ObjectNode o = f.objectNode();
            // o.put("text","Processing ....");
            res = "";
        } else {
            asyncService.handleRequestsAsync(request.getParameter("token"), null, null, request.getParameter("user_id"),
                    request.getParameter("team_id"), request.getParameter("response_url"));
            res = "";
        }
        return res;
    }


    /**
     * This method is called by a slack user when he tries a SG command or interactive button and does not have a valid
     * SG session on the SGDS server
     *
     * @param suid  - Slack user id
     * @param email - Email common between slack and SG - this is the SGDS username
     * @param rq    - HttpServletRequest, to get the values of email and suid in case these are attributes.
     * @return
     * @throws IOException
     */
    @RequestMapping(value = SGSlackConstants.LOGIN_URL, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String loadlogin(@RequestParam(value = "SUID", defaultValue = "") String suid, @RequestParam(value = "EMAIL", defaultValue = "") String email,
                            @RequestParam(value = "TEAMID", defaultValue = "") String teamId, HttpServletRequest rq) throws IOException {
        if (suid == null || suid.isEmpty())
            suid = String.valueOf(rq.getAttribute("SUID"));
        if (email == null || email.isEmpty())
            email = String.valueOf(rq.getAttribute("EMAIL"));
        if (teamId == null || teamId.isEmpty())
            teamId = String.valueOf(rq.getAttribute("TEAMID"));
        logger.info("SUID from rq = " + suid + " email=" + email + " teamId=" + teamId);
        return "login"; //jsp view
    }


    /**
     * This method is called when a user submits on the login page.
     *
     * @param rq
     * @param rs
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = SGSlackConstants.LOGIN_URL, method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public void login(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {

        String sessionId;
        String userName = rq.getParameter("EMAIL");
        String passwd = rq.getParameter("pswrd");
        String slackUserId = rq.getParameter("SUID");
        String email = rq.getParameter("EMAIL");
        String teamId = rq.getParameter("TEAMID");
        logger.info("Username(email = " + userName + " passwd = " + passwd + " slackUserId = " + slackUserId);

        if (userName != null && !userName.isEmpty() && passwd != null && !passwd.isEmpty()) {
            //submission case
            sessionId = SGDSClient.authenticate(userName, passwd);
            if (sessionId != null && !sessionId.isEmpty()) {
                RedisManager.store(teamId + SGSlackConstants.DELIMITER + slackUserId + SGSlackConstants.DELIMITER + SGSlackConstants.SGDS_SESSIONID, sessionId, 180);
                String token = RedisManager.get(teamId + SGSlackConstants.DELIMITER + SGSlackConstants.SLACK_TOKEN);
                logger.debug("Token="+token);
                HttpPost postRequest = new HttpPost("https://slack.com/api/team.info");

                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                nvps.add(new BasicNameValuePair("token", token));
                postRequest.setEntity(new UrlEncodedFormEntity(nvps));

                CloseableHttpResponse responseApps = SGDSClient.getHttpClient().execute(postRequest);
                String wbRes = "";
                try {
                    HttpEntity entityApps = responseApps.getEntity();
                    wbRes = EntityUtils.toString(entityApps, "UTF-8");
                    logger.debug("Team info response = " + wbRes);
                    EntityUtils.consume(entityApps);
                } finally {
                    responseApps.close();
                }
                ObjectMapper m = new ObjectMapper();
                SlackTeamInfo s = new SlackTeamInfo();
                s = m.readValue(wbRes, s.getClass());
                rs.sendRedirect(new StringBuffer("https://").append(s.getTeam().getDomain()).append(".slack.com/messages").toString());
            } else {
                rs.sendRedirect("http://skygiraffe.com/");
            }
        } else {
            //TODO send error message also
            rq.setAttribute("SUID", slackUserId);
            rq.setAttribute("EMAIL", email);
            rq.getRequestDispatcher("/skyg/login").forward(rq, rs);
        }
    }

    /**
     * This method is the callback url when a Slack OAuth is performed. Slack sends the following data:
     * access token, scope
     *
     * @param code     -Authorization code to be exchanged for the token
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = SGSlackConstants.BASE_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void slackOAuth(@RequestParam(value = "code", defaultValue = "") String code, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        logger.debug("code=" + code);

        HttpPost postRequest = new HttpPost("https://slack.com/api/oauth.access");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("client_id", Config.getPropertyValue("SLACK_CLIENT_ID_DEV")));
        nvps.add(new BasicNameValuePair("client_secret", Config.getPropertyValue("SLACK_CLIENT_SECRET_DEV")));
        nvps.add(new BasicNameValuePair("code", code));
        postRequest.setEntity(new UrlEncodedFormEntity(nvps));

        CloseableHttpResponse responseApps = SGDSClient.getHttpClient().execute(postRequest);
        String wbRes = "";
        try {
            HttpEntity entityApps = responseApps.getEntity();
            wbRes = EntityUtils.toString(entityApps, "UTF-8");
            EntityUtils.consume(entityApps);
        } finally {
            responseApps.close();
        }
        asyncService.processSlackDetailsForCurrentUser(wbRes, request);
        request.getRequestDispatcher("/skyg/login").forward(request, response);
    }

    @Override
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler();
    }
}
