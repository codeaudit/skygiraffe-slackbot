
package com.sg.model.slackRq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "actions",
    "callback_id",
    "team",
    "channel",
    "user",
    "action_ts",
    "message_ts",
    "attachment_id",
    "token",
    "response_url"
})
public class IntMessageRequest {

    @JsonProperty("actions")
    private List<Action> actions = new ArrayList<Action>();
    @JsonProperty("callback_id")
    private String callbackId;
    @JsonProperty("team")
    private Team team;
    @JsonProperty("channel")
    private Channel channel;
    @JsonProperty("user")
    private User user;
    @JsonProperty("action_ts")
    private String actionTs;
    @JsonProperty("message_ts")
    private String messageTs;
    @JsonProperty("attachment_id")
    private String attachmentId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("response_url")
    private String responseUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The actions
     */
    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    /**
     * 
     * @param actions
     *     The actions
     */
    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * 
     * @return
     *     The callbackId
     */
    @JsonProperty("callback_id")
    public String getCallbackId() {
        return callbackId;
    }

    /**
     * 
     * @param callbackId
     *     The callback_id
     */
    @JsonProperty("callback_id")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    /**
     * 
     * @return
     *     The team
     */
    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    /**
     * 
     * @param team
     *     The team
     */
    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * 
     * @return
     *     The channel
     */
    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    /**
     * 
     * @param channel
     *     The channel
     */
    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    /**
     * 
     * @return
     *     The user
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The actionTs
     */
    @JsonProperty("action_ts")
    public String getActionTs() {
        return actionTs;
    }

    /**
     * 
     * @param actionTs
     *     The action_ts
     */
    @JsonProperty("action_ts")
    public void setActionTs(String actionTs) {
        this.actionTs = actionTs;
    }

    /**
     * 
     * @return
     *     The messageTs
     */
    @JsonProperty("message_ts")
    public String getMessageTs() {
        return messageTs;
    }

    /**
     * 
     * @param messageTs
     *     The message_ts
     */
    @JsonProperty("message_ts")
    public void setMessageTs(String messageTs) {
        this.messageTs = messageTs;
    }

    /**
     * 
     * @return
     *     The attachmentId
     */
    @JsonProperty("attachment_id")
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * 
     * @param attachmentId
     *     The attachment_id
     */
    @JsonProperty("attachment_id")
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * 
     * @return
     *     The token
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token
     *     The token
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * @return
     *     The responseUrl
     */
    @JsonProperty("response_url")
    public String getResponseUrl() {
        return responseUrl;
    }

    /**
     * 
     * @param responseUrl
     *     The response_url
     */
    @JsonProperty("response_url")
    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
