
package com.sg.model.sgdsRs;

import java.util.HashMap;
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
    "CorrectServer",
    "CorrectServerURL",
    "LatestVersion",
    "Msg",
    "SessionID",
    "Status"
})
public class SGDSAuthRes {

    @JsonProperty("CorrectServer")
    private Object correctServer;
    @JsonProperty("CorrectServerURL")
    private Object correctServerURL;
    @JsonProperty("LatestVersion")
    private Integer latestVersion;
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("SessionID")
    private String sessionID;
    @JsonProperty("Status")
    private Integer status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The correctServer
     */
    @JsonProperty("CorrectServer")
    public Object getCorrectServer() {
        return correctServer;
    }

    /**
     * 
     * @param correctServer
     *     The CorrectServer
     */
    @JsonProperty("CorrectServer")
    public void setCorrectServer(Object correctServer) {
        this.correctServer = correctServer;
    }

    /**
     * 
     * @return
     *     The correctServerURL
     */
    @JsonProperty("CorrectServerURL")
    public Object getCorrectServerURL() {
        return correctServerURL;
    }

    /**
     * 
     * @param correctServerURL
     *     The CorrectServerURL
     */
    @JsonProperty("CorrectServerURL")
    public void setCorrectServerURL(Object correctServerURL) {
        this.correctServerURL = correctServerURL;
    }

    /**
     * 
     * @return
     *     The latestVersion
     */
    @JsonProperty("LatestVersion")
    public Integer getLatestVersion() {
        return latestVersion;
    }

    /**
     * 
     * @param latestVersion
     *     The LatestVersion
     */
    @JsonProperty("LatestVersion")
    public void setLatestVersion(Integer latestVersion) {
        this.latestVersion = latestVersion;
    }

    /**
     * 
     * @return
     *     The msg
     */
    @JsonProperty("Msg")
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @param msg
     *     The Msg
     */
    @JsonProperty("Msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 
     * @return
     *     The sessionID
     */
    @JsonProperty("SessionID")
    public String getSessionID() {
        return sessionID;
    }

    /**
     * 
     * @param sessionID
     *     The SessionID
     */
    @JsonProperty("SessionID")
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
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
