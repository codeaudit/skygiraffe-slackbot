
package com.sg.model.sgdsRs.repdet;

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
    "ReportID",
    "ReportName",
    "ReportDescription",
    "ReportIcon",
    "ReportType",
    "Folder",
    "ReportOrdinal",
    "ReportSharedSlicers",
    "NumOfTabs",
    "Tabs",
    "ReportUpdateID",
    "IsHidden",
    "CredentialRequirements",
    "AtLeastOneParameterIsMandatory"
})
public class ReportMetaData {

    @JsonProperty("ReportID")
    private String reportID;
    @JsonProperty("ReportName")
    private String reportName;
    @JsonProperty("ReportDescription")
    private String reportDescription;
    @JsonProperty("ReportIcon")
    private ReportIcon reportIcon;
    @JsonProperty("ReportType")
    private String reportType;
    @JsonProperty("Folder")
    private String folder;
    @JsonProperty("ReportOrdinal")
    private Integer reportOrdinal;
    @JsonProperty("ReportSharedSlicers")
    private List<ReportSharedSlicer> reportSharedSlicers = new ArrayList<ReportSharedSlicer>();@JsonProperty("NumOfTabs")
    private Integer numOfTabs;
    @JsonProperty("Tabs")
    private List<Tab> tabs = new ArrayList<Tab>();
    @JsonProperty("ReportUpdateID")
    private String reportUpdateID;
    @JsonProperty("IsHidden")
    private Boolean isHidden;
    @JsonProperty("CredentialRequirements")
    private Object credentialRequirements;
    @JsonProperty("AtLeastOneParameterIsMandatory")
    private Boolean atLeastOneParameterIsMandatory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The reportName
     */
    @JsonProperty("ReportName")
    public String getReportName() {
        return reportName;
    }

    /**
     * 
     * @param reportName
     *     The ReportName
     */
    @JsonProperty("ReportName")
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * 
     * @return
     *     The reportDescription
     */
    @JsonProperty("ReportDescription")
    public String getReportDescription() {
        return reportDescription;
    }

    /**
     * 
     * @param reportDescription
     *     The ReportDescription
     */
    @JsonProperty("ReportDescription")
    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    /**
     * 
     * @return
     *     The reportIcon
     */
    @JsonProperty("ReportIcon")
    public ReportIcon getReportIcon() {
        return reportIcon;
    }

    /**
     * 
     * @param reportIcon
     *     The ReportIcon
     */
    @JsonProperty("ReportIcon")
    public void setReportIcon(ReportIcon reportIcon) {
        this.reportIcon = reportIcon;
    }

    /**
     * 
     * @return
     *     The reportType
     */
    @JsonProperty("ReportType")
    public String getReportType() {
        return reportType;
    }

    /**
     * 
     * @param reportType
     *     The ReportType
     */
    @JsonProperty("ReportType")
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * 
     * @return
     *     The folder
     */
    @JsonProperty("Folder")
    public String getFolder() {
        return folder;
    }

    /**
     * 
     * @param folder
     *     The Folder
     */
    @JsonProperty("Folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * 
     * @return
     *     The reportOrdinal
     */
    @JsonProperty("ReportOrdinal")
    public Integer getReportOrdinal() {
        return reportOrdinal;
    }

    /**
     * 
     * @param reportOrdinal
     *     The ReportOrdinal
     */
    @JsonProperty("ReportOrdinal")
    public void setReportOrdinal(Integer reportOrdinal) {
        this.reportOrdinal = reportOrdinal;
    }

    /**
     *
     * @return
     * The reportSharedSlicers
     */
    @JsonProperty("ReportSharedSlicers")
    public List<ReportSharedSlicer> getReportSharedSlicers() {
        return reportSharedSlicers;
    }

    /**
     *
     * @param reportSharedSlicers
     * The ReportSharedSlicers
     */
    @JsonProperty("ReportSharedSlicers")
    public void setReportSharedSlicers(List<ReportSharedSlicer> reportSharedSlicers) {
        this.reportSharedSlicers = reportSharedSlicers;
    }


    /**
     * 
     * @return
     *     The numOfTabs
     */
    @JsonProperty("NumOfTabs")
    public Integer getNumOfTabs() {
        return numOfTabs;
    }

    /**
     * 
     * @param numOfTabs
     *     The NumOfTabs
     */
    @JsonProperty("NumOfTabs")
    public void setNumOfTabs(Integer numOfTabs) {
        this.numOfTabs = numOfTabs;
    }

    /**
     * 
     * @return
     *     The tabs
     */
    @JsonProperty("Tabs")
    public List<Tab> getTabs() {
        return tabs;
    }

    /**
     * 
     * @param tabs
     *     The Tabs
     */
    @JsonProperty("Tabs")
    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
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
     *     The isHidden
     */
    @JsonProperty("IsHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * 
     * @param isHidden
     *     The IsHidden
     */
    @JsonProperty("IsHidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * 
     * @return
     *     The credentialRequirements
     */
    @JsonProperty("CredentialRequirements")
    public Object getCredentialRequirements() {
        return credentialRequirements;
    }

    /**
     * 
     * @param credentialRequirements
     *     The CredentialRequirements
     */
    @JsonProperty("CredentialRequirements")
    public void setCredentialRequirements(Object credentialRequirements) {
        this.credentialRequirements = credentialRequirements;
    }

    /**
     * 
     * @return
     *     The atLeastOneParameterIsMandatory
     */
    @JsonProperty("AtLeastOneParameterIsMandatory")
    public Boolean getAtLeastOneParameterIsMandatory() {
        return atLeastOneParameterIsMandatory;
    }

    /**
     * 
     * @param atLeastOneParameterIsMandatory
     *     The AtLeastOneParameterIsMandatory
     */
    @JsonProperty("AtLeastOneParameterIsMandatory")
    public void setAtLeastOneParameterIsMandatory(Boolean atLeastOneParameterIsMandatory) {
        this.atLeastOneParameterIsMandatory = atLeastOneParameterIsMandatory;
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
