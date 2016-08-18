
package com.sg.model.sgdsRq;

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
    "ApplicationID",
    "DataItemUpdateIDs",
    "ReportID",
    "ReportUpdateId",
    "RequestID",
    "SessionID"
})
public class RegReportRq {

    @JsonProperty("ApplicationID")
    private String applicationID;
    @JsonProperty("DataItemUpdateIDs")
    private Object dataItemUpdateIDs;
    @JsonProperty("ReportID")
    private String reportID;
    @JsonProperty("ReportUpdateId")
    private Object reportUpdateId;
    @JsonProperty("RequestID")
    private Object requestID;
    @JsonProperty("SessionID")
    private String sessionID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The applicationID
     */
    @JsonProperty("ApplicationID")
    public String getApplicationID() {
        return applicationID;
    }

    /**
     * 
     * @param applicationID
     *     The ApplicationID
     */
    @JsonProperty("ApplicationID")
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * 
     * @return
     *     The dataItemUpdateIDs
     */
    @JsonProperty("DataItemUpdateIDs")
    public Object getDataItemUpdateIDs() {
        return dataItemUpdateIDs;
    }

    /**
     * 
     * @param dataItemUpdateIDs
     *     The DataItemUpdateIDs
     */
    @JsonProperty("DataItemUpdateIDs")
    public void setDataItemUpdateIDs(Object dataItemUpdateIDs) {
        this.dataItemUpdateIDs = dataItemUpdateIDs;
    }

    /**
     * 
     * @return
     *     The reportID
     */
    @JsonProperty("ReportID")
    public String getReportID() {
        return reportID;
    }

    /**
     * 
     * @param reportID
     *     The ReportID
     */
    @JsonProperty("ReportID")
    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    /**
     * 
     * @return
     *     The reportUpdateId
     */
    @JsonProperty("ReportUpdateId")
    public Object getReportUpdateId() {
        return reportUpdateId;
    }

    /**
     * 
     * @param reportUpdateId
     *     The ReportUpdateId
     */
    @JsonProperty("ReportUpdateId")
    public void setReportUpdateId(Object reportUpdateId) {
        this.reportUpdateId = reportUpdateId;
    }

    /**
     * 
     * @return
     *     The requestID
     */
    @JsonProperty("RequestID")
    public Object getRequestID() {
        return requestID;
    }

    /**
     * 
     * @param requestID
     *     The RequestID
     */
    @JsonProperty("RequestID")
    public void setRequestID(Object requestID) {
        this.requestID = requestID;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
