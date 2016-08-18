package com.sg.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by ayush on 6/17/16.
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * {
     "attachments": [
     {
     "fallback": "Please login into SkyGiraffe to continue ...",
     "pretext": "SkyGiraffe Login",
     "title": "Please login into SkyGiraffe to continue ...",
     "title_link": "https://sgbot-mobilityai.rhcloud.com/SGbot-1.0/skyg/login?key=",
     "text": "Once logged in try '/sg help' to see all commands",
     "color": "#7CD197"
     }
     ]
     }
     * @return
     */
    public static String createLoginLinkResponse(String slackUserId, String email, String teamId){

        JsonNodeFactory f = JsonNodeFactory.instance ;
        ObjectNode loginResponse = f.objectNode();
        loginResponse.put("text","Login to SkyGiraffe is required.");
        ArrayNode attachments = loginResponse.putArray("attachments");
        ObjectNode att = f.objectNode();
        att.put("fallback", "Please login into SkyGiraffe to continue ...");
        att.put("pretext", "");
        att.put("title", "Please login..");
        att.put("title_link", Config.getPropertyValue("SGDS_LOGIN_URL_DEV")+slackUserId+"&EMAIL="+email+"&TEAMID="+teamId);
        att.put("text","Once logged in try '/sg help' to see all commands");
        att.put("color", "#7CD197");

        attachments.add(att);

        return loginResponse.toString();

    }

    public static String createAuthLinkResponse(){

        JsonNodeFactory f = JsonNodeFactory.instance ;
        ObjectNode loginResponse = f.objectNode();
        loginResponse.put("text","Authorization for SkyGiraffe to use Slack details is required.");
        ArrayNode attachments = loginResponse.putArray("attachments");
        ObjectNode att = f.objectNode();
        att.put("fallback", "Please authorize SkyGiraffe to access to your Slack details ...");
        att.put("pretext", "");
        att.put("title", "Please authorize..");
        att.put("title_link", Config.getPropertyValue("SLACK_AUTH_URL_DEV"));
        att.put("text","Once authorized and logged into SkyGiraffe try '/sg help' to see all commands");
        att.put("color", "#7CD197");

        attachments.add(att);
        return loginResponse.toString();

    }
}
