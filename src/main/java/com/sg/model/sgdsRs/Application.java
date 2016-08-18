
package com.sg.model.sgdsRs;

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
    "Applications",
    "ExternalCredentials",
    "Msg",
    "Status"
})
public class Application {

    @JsonProperty("Applications")
    private List<Application_> applications = new ArrayList<Application_>();
    @JsonProperty("ExternalCredentials")
    private List<ExternalCredential> externalCredentials = new ArrayList<ExternalCredential>();
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("Status")
    private Integer status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The applications
     */
    @JsonProperty("Applications")
    public List<Application_> getApplications() {
        return applications;
    }

    /**
     * 
     * @param applications
     *     The Applications
     */
    @JsonProperty("Applications")
    public void setApplications(List<Application_> applications) {
        this.applications = applications;
    }

    /**
     * 
     * @return
     *     The externalCredentials
     */
    @JsonProperty("ExternalCredentials")
    public List<ExternalCredential> getExternalCredentials() {
        return externalCredentials;
    }

    /**
     * 
     * @param externalCredentials
     *     The ExternalCredentials
     */
    @JsonProperty("ExternalCredentials")
    public void setExternalCredentials(List<ExternalCredential> externalCredentials) {
        this.externalCredentials = externalCredentials;
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
