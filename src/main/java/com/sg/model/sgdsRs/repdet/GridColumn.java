
package com.sg.model.sgdsRs.repdet;

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
    "ID",
    "DataType",
    "Ordnial",
    "IsVisible",
    "ColumnFriendlyName",
    "DataItemColumnID",
    "IsPrimary",
    "IsFrozen",
    "SlicerID",
    "TrendsDataItemColumnID",
    "ColumnType",
    "AdditionalData1",
    "AdditionalData2",
    "Navigation",
    "ColumnFormat",
    "ActionID",
    "SparkChart",
    "GaugeObj",
    "PhoneType"
})
public class GridColumn {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("DataType")
    private String dataType;
    @JsonProperty("Ordnial")
    private Integer ordnial;
    @JsonProperty("IsVisible")
    private Boolean isVisible;
    @JsonProperty("ColumnFriendlyName")
    private String columnFriendlyName;
    @JsonProperty("DataItemColumnID")
    private String dataItemColumnID;
    @JsonProperty("IsPrimary")
    private Boolean isPrimary;
    @JsonProperty("IsFrozen")
    private Boolean isFrozen;
    @JsonProperty("SlicerID")
    private Object slicerID;
    @JsonProperty("TrendsDataItemColumnID")
    private Object trendsDataItemColumnID;
    @JsonProperty("ColumnType")
    private String columnType;
    @JsonProperty("AdditionalData1")
    private Object additionalData1;
    @JsonProperty("AdditionalData2")
    private Object additionalData2;
    @JsonProperty("Navigation")
    private Navigation navigation;
    @JsonProperty("ColumnFormat")
    private Object columnFormat;
    @JsonProperty("ActionID")
    private Object actionID;
    @JsonProperty("SparkChart")
    private Object sparkChart;
    @JsonProperty("GaugeObj")
    private Object gaugeObj;
    @JsonProperty("PhoneType")
    private Object phoneType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The iD
     */
    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    /**
     * 
     * @param iD
     *     The ID
     */
    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * 
     * @return
     *     The dataType
     */
    @JsonProperty("DataType")
    public String getDataType() {
        return dataType;
    }

    /**
     * 
     * @param dataType
     *     The DataType
     */
    @JsonProperty("DataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 
     * @return
     *     The ordnial
     */
    @JsonProperty("Ordnial")
    public Integer getOrdnial() {
        return ordnial;
    }

    /**
     * 
     * @param ordnial
     *     The Ordnial
     */
    @JsonProperty("Ordnial")
    public void setOrdnial(Integer ordnial) {
        this.ordnial = ordnial;
    }

    /**
     * 
     * @return
     *     The isVisible
     */
    @JsonProperty("IsVisible")
    public Boolean getIsVisible() {
        return isVisible;
    }

    /**
     * 
     * @param isVisible
     *     The IsVisible
     */
    @JsonProperty("IsVisible")
    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * 
     * @return
     *     The columnFriendlyName
     */
    @JsonProperty("ColumnFriendlyName")
    public String getColumnFriendlyName() {
        return columnFriendlyName;
    }

    /**
     * 
     * @param columnFriendlyName
     *     The ColumnFriendlyName
     */
    @JsonProperty("ColumnFriendlyName")
    public void setColumnFriendlyName(String columnFriendlyName) {
        this.columnFriendlyName = columnFriendlyName;
    }

    /**
     * 
     * @return
     *     The dataItemColumnID
     */
    @JsonProperty("DataItemColumnID")
    public String getDataItemColumnID() {
        return dataItemColumnID;
    }

    /**
     * 
     * @param dataItemColumnID
     *     The DataItemColumnID
     */
    @JsonProperty("DataItemColumnID")
    public void setDataItemColumnID(String dataItemColumnID) {
        this.dataItemColumnID = dataItemColumnID;
    }

    /**
     * 
     * @return
     *     The isPrimary
     */
    @JsonProperty("IsPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    /**
     * 
     * @param isPrimary
     *     The IsPrimary
     */
    @JsonProperty("IsPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    /**
     * 
     * @return
     *     The isFrozen
     */
    @JsonProperty("IsFrozen")
    public Boolean getIsFrozen() {
        return isFrozen;
    }

    /**
     * 
     * @param isFrozen
     *     The IsFrozen
     */
    @JsonProperty("IsFrozen")
    public void setIsFrozen(Boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    /**
     * 
     * @return
     *     The slicerID
     */
    @JsonProperty("SlicerID")
    public Object getSlicerID() {
        return slicerID;
    }

    /**
     * 
     * @param slicerID
     *     The SlicerID
     */
    @JsonProperty("SlicerID")
    public void setSlicerID(Object slicerID) {
        this.slicerID = slicerID;
    }

    /**
     * 
     * @return
     *     The trendsDataItemColumnID
     */
    @JsonProperty("TrendsDataItemColumnID")
    public Object getTrendsDataItemColumnID() {
        return trendsDataItemColumnID;
    }

    /**
     * 
     * @param trendsDataItemColumnID
     *     The TrendsDataItemColumnID
     */
    @JsonProperty("TrendsDataItemColumnID")
    public void setTrendsDataItemColumnID(Object trendsDataItemColumnID) {
        this.trendsDataItemColumnID = trendsDataItemColumnID;
    }

    /**
     * 
     * @return
     *     The columnType
     */
    @JsonProperty("ColumnType")
    public String getColumnType() {
        return columnType;
    }

    /**
     * 
     * @param columnType
     *     The ColumnType
     */
    @JsonProperty("ColumnType")
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    /**
     * 
     * @return
     *     The additionalData1
     */
    @JsonProperty("AdditionalData1")
    public Object getAdditionalData1() {
        return additionalData1;
    }

    /**
     * 
     * @param additionalData1
     *     The AdditionalData1
     */
    @JsonProperty("AdditionalData1")
    public void setAdditionalData1(Object additionalData1) {
        this.additionalData1 = additionalData1;
    }

    /**
     * 
     * @return
     *     The additionalData2
     */
    @JsonProperty("AdditionalData2")
    public Object getAdditionalData2() {
        return additionalData2;
    }

    /**
     * 
     * @param additionalData2
     *     The AdditionalData2
     */
    @JsonProperty("AdditionalData2")
    public void setAdditionalData2(Object additionalData2) {
        this.additionalData2 = additionalData2;
    }

    /**
     * 
     * @return
     *     The navigation
     */
    @JsonProperty("Navigation")
    public Navigation getNavigation() {
        return navigation;
    }

    /**
     * 
     * @param navigation
     *     The Navigation
     */
    @JsonProperty("Navigation")
    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    /**
     * 
     * @return
     *     The columnFormat
     */
    @JsonProperty("ColumnFormat")
    public Object getColumnFormat() {
        return columnFormat;
    }

    /**
     * 
     * @param columnFormat
     *     The ColumnFormat
     */
    @JsonProperty("ColumnFormat")
    public void setColumnFormat(Object columnFormat) {
        this.columnFormat = columnFormat;
    }

    /**
     * 
     * @return
     *     The actionID
     */
    @JsonProperty("ActionID")
    public Object getActionID() {
        return actionID;
    }

    /**
     * 
     * @param actionID
     *     The ActionID
     */
    @JsonProperty("ActionID")
    public void setActionID(Object actionID) {
        this.actionID = actionID;
    }

    /**
     * 
     * @return
     *     The sparkChart
     */
    @JsonProperty("SparkChart")
    public Object getSparkChart() {
        return sparkChart;
    }

    /**
     * 
     * @param sparkChart
     *     The SparkChart
     */
    @JsonProperty("SparkChart")
    public void setSparkChart(Object sparkChart) {
        this.sparkChart = sparkChart;
    }

    /**
     * 
     * @return
     *     The gaugeObj
     */
    @JsonProperty("GaugeObj")
    public Object getGaugeObj() {
        return gaugeObj;
    }

    /**
     * 
     * @param gaugeObj
     *     The GaugeObj
     */
    @JsonProperty("GaugeObj")
    public void setGaugeObj(Object gaugeObj) {
        this.gaugeObj = gaugeObj;
    }

    /**
     * 
     * @return
     *     The phoneType
     */
    @JsonProperty("PhoneType")
    public Object getPhoneType() {
        return phoneType;
    }

    /**
     * 
     * @param phoneType
     *     The PhoneType
     */
    @JsonProperty("PhoneType")
    public void setPhoneType(Object phoneType) {
        this.phoneType = phoneType;
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
