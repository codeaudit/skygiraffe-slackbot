
package com.sg.model.sgdsRq.action;

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
    "ApplicationID",
    "ReportID",
    "TabID",
    "DataItemUpdateIDs",
    "ReportUpdateID",
    "RequestID",
    "WB_ID",
    "SessionID"
})
public class CheckWriteBackRq {

    @JsonProperty("ApplicationID")
    private String applicationID;
    @JsonProperty("ReportID")
    private String reportID;
    @JsonProperty("TabID")
    private String tabID;
    @JsonProperty("DataItemUpdateIDs")
    private List<Object> dataItemUpdateIDs = new ArrayList<Object>();
    @JsonProperty("ReportUpdateID")
    private String reportUpdateID;
    @JsonProperty("RequestID")
    private String requestID;
    @JsonProperty("WB_ID")
    private Integer wBID;
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
     *     The tabID
     */
    @JsonProperty("TabID")
    public String getTabID() {
        return tabID;
    }

    /**
     * 
     * @param tabID
     *     The TabID
     */
    @JsonProperty("TabID")
    public void setTabID(String tabID) {
        this.tabID = tabID;
    }

    /**
     * 
     * @return
     *     The dataItemUpdateIDs
     */
    @JsonProperty("DataItemUpdateIDs")
    public List<Object> getDataItemUpdateIDs() {
        return dataItemUpdateIDs;
    }

    /**
     * 
     * @param dataItemUpdateIDs
     *     The DataItemUpdateIDs
     */
    @JsonProperty("DataItemUpdateIDs")
    public void setDataItemUpdateIDs(List<Object> dataItemUpdateIDs) {
        this.dataItemUpdateIDs = dataItemUpdateIDs;
    }

    /**
     * 
     * @return
     *     The reportUpdateID
     */
    @JsonProperty("ReportUpdateID")
    public String getReportUpdateID() {
        return reportUpdateID;
    }

    /**
     * 
     * @param reportUpdateID
     *     The ReportUpdateID
     */
    @JsonProperty("ReportUpdateID")
    public void setReportUpdateID(String reportUpdateID) {
        this.reportUpdateID = reportUpdateID;
    }

    /**
     * 
     * @return
     *     The requestID
     */
    @JsonProperty("RequestID")
    public String getRequestID() {
        return requestID;
    }

    /**
     * 
     * @param requestID
     *     The RequestID
     */
    @JsonProperty("RequestID")
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    /**
     * 
     * @return
     *     The wBID
     */
    @JsonProperty("WB_ID")
    public Integer getWBID() {
        return wBID;
    }

    /**
     * 
     * @param wBID
     *     The WB_ID
     */
    @JsonProperty("WB_ID")
    public void setWBID(Integer wBID) {
        this.wBID = wBID;
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
