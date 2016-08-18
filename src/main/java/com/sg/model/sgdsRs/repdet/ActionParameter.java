
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
    "ID",
    "DataType",
    "ParameterType",
    "Ordinal",
    "IsMultiSelect",
    "IsMandatory",
    "ParameterName",
    "ParameterDefaultValue",
    "InputType",
    "LabelStyle",
    "DataItemID",
    "DynamicCollectionSource",
    "AllowedMembers",
    "ParameterMappings",
    "SearchboxMapToParameterName",
    "ImageSize",
    "Placeholder",
    "TableParameters"
})
public class ActionParameter {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("DataType")
    private String dataType;
    @JsonProperty("ParameterType")
    private String parameterType;
    @JsonProperty("Ordinal")
    private Integer ordinal;
    @JsonProperty("IsMultiSelect")
    private Boolean isMultiSelect;
    @JsonProperty("IsMandatory")
    private Boolean isMandatory;
    @JsonProperty("ParameterName")
    private String parameterName;
    @JsonProperty("ParameterDefaultValue")
    private String parameterDefaultValue;
    @JsonProperty("InputType")
    private String inputType;
    @JsonProperty("LabelStyle")
    private String labelStyle;
    @JsonProperty("DataItemID")
    private Object dataItemID;
    @JsonProperty("DynamicCollectionSource")
    private Object dynamicCollectionSource;
    @JsonProperty("AllowedMembers")
    private List<AllowedMember> allowedMembers = new ArrayList<AllowedMember>();
    @JsonProperty("ParameterMappings")
    private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
    @JsonProperty("SearchboxMapToParameterName")
    private Object searchboxMapToParameterName;
    @JsonProperty("ImageSize")
    private Object imageSize;
    @JsonProperty("Placeholder")
    private String placeholder;
    @JsonProperty("TableParameters")
    private Object tableParameters;
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
     *     The parameterType
     */
    @JsonProperty("ParameterType")
    public String getParameterType() {
        return parameterType;
    }

    /**
     * 
     * @param parameterType
     *     The ParameterType
     */
    @JsonProperty("ParameterType")
    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    /**
     * 
     * @return
     *     The ordinal
     */
    @JsonProperty("Ordinal")
    public Integer getOrdinal() {
        return ordinal;
    }

    /**
     * 
     * @param ordinal
     *     The Ordinal
     */
    @JsonProperty("Ordinal")
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    /**
     * 
     * @return
     *     The isMultiSelect
     */
    @JsonProperty("IsMultiSelect")
    public Boolean getIsMultiSelect() {
        return isMultiSelect;
    }

    /**
     * 
     * @param isMultiSelect
     *     The IsMultiSelect
     */
    @JsonProperty("IsMultiSelect")
    public void setIsMultiSelect(Boolean isMultiSelect) {
        this.isMultiSelect = isMultiSelect;
    }

    /**
     * 
     * @return
     *     The isMandatory
     */
    @JsonProperty("IsMandatory")
    public Boolean getIsMandatory() {
        return isMandatory;
    }

    /**
     * 
     * @param isMandatory
     *     The IsMandatory
     */
    @JsonProperty("IsMandatory")
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
     * 
     * @return
     *     The parameterName
     */
    @JsonProperty("ParameterName")
    public String getParameterName() {
        return parameterName;
    }

    /**
     * 
     * @param parameterName
     *     The ParameterName
     */
    @JsonProperty("ParameterName")
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     * 
     * @return
     *     The parameterDefaultValue
     */
    @JsonProperty("ParameterDefaultValue")
    public String getParameterDefaultValue() {
        return parameterDefaultValue;
    }

    /**
     * 
     * @param parameterDefaultValue
     *     The ParameterDefaultValue
     */
    @JsonProperty("ParameterDefaultValue")
    public void setParameterDefaultValue(String parameterDefaultValue) {
        this.parameterDefaultValue = parameterDefaultValue;
    }

    /**
     * 
     * @return
     *     The inputType
     */
    @JsonProperty("InputType")
    public String getInputType() {
        return inputType;
    }

    /**
     * 
     * @param inputType
     *     The InputType
     */
    @JsonProperty("InputType")
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    /**
     * 
     * @return
     *     The labelStyle
     */
    @JsonProperty("LabelStyle")
    public String getLabelStyle() {
        return labelStyle;
    }

    /**
     * 
     * @param labelStyle
     *     The LabelStyle
     */
    @JsonProperty("LabelStyle")
    public void setLabelStyle(String labelStyle) {
        this.labelStyle = labelStyle;
    }

    /**
     * 
     * @return
     *     The dataItemID
     */
    @JsonProperty("DataItemID")
    public Object getDataItemID() {
        return dataItemID;
    }

    /**
     * 
     * @param dataItemID
     *     The DataItemID
     */
    @JsonProperty("DataItemID")
    public void setDataItemID(Object dataItemID) {
        this.dataItemID = dataItemID;
    }

    /**
     * 
     * @return
     *     The dynamicCollectionSource
     */
    @JsonProperty("DynamicCollectionSource")
    public Object getDynamicCollectionSource() {
        return dynamicCollectionSource;
    }

    /**
     * 
     * @param dynamicCollectionSource
     *     The DynamicCollectionSource
     */
    @JsonProperty("DynamicCollectionSource")
    public void setDynamicCollectionSource(Object dynamicCollectionSource) {
        this.dynamicCollectionSource = dynamicCollectionSource;
    }

    /**
     *
     * @return
     * The allowedMembers
     */
    @JsonProperty("AllowedMembers")
    public List<AllowedMember> getAllowedMembers() {
        return allowedMembers;
    }

    /**
     *
     * @param allowedMembers
     * The AllowedMembers
     */
    @JsonProperty("AllowedMembers")
    public void setAllowedMembers(List<AllowedMember> allowedMembers) {
        this.allowedMembers = allowedMembers;
    }
    /**
     * 
     * @return
     *     The parameterMappings
     */
    @JsonProperty("ParameterMappings")
    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    /**
     * 
     * @param parameterMappings
     *     The ParameterMappings
     */
    @JsonProperty("ParameterMappings")
    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }

    /**
     * 
     * @return
     *     The searchboxMapToParameterName
     */
    @JsonProperty("SearchboxMapToParameterName")
    public Object getSearchboxMapToParameterName() {
        return searchboxMapToParameterName;
    }

    /**
     * 
     * @param searchboxMapToParameterName
     *     The SearchboxMapToParameterName
     */
    @JsonProperty("SearchboxMapToParameterName")
    public void setSearchboxMapToParameterName(Object searchboxMapToParameterName) {
        this.searchboxMapToParameterName = searchboxMapToParameterName;
    }

    /**
     * 
     * @return
     *     The imageSize
     */
    @JsonProperty("ImageSize")
    public Object getImageSize() {
        return imageSize;
    }

    /**
     * 
     * @param imageSize
     *     The ImageSize
     */
    @JsonProperty("ImageSize")
    public void setImageSize(Object imageSize) {
        this.imageSize = imageSize;
    }

    /**
     * 
     * @return
     *     The placeholder
     */
    @JsonProperty("Placeholder")
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * 
     * @param placeholder
     *     The Placeholder
     */
    @JsonProperty("Placeholder")
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * 
     * @return
     *     The tableParameters
     */
    @JsonProperty("TableParameters")
    public Object getTableParameters() {
        return tableParameters;
    }

    /**
     * 
     * @param tableParameters
     *     The TableParameters
     */
    @JsonProperty("TableParameters")
    public void setTableParameters(Object tableParameters) {
        this.tableParameters = tableParameters;
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
