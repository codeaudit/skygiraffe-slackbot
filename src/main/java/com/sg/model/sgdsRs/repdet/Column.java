
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
    "DataItemColumnID",
    "DataItemColumnName",
    "ColumnWidestValue",
    "DataType",
    "IsPrimaryKey"
})
public class Column {

    @JsonProperty("DataItemColumnID")
    private String dataItemColumnID;
    @JsonProperty("DataItemColumnName")
    private String dataItemColumnName;
    @JsonProperty("ColumnWidestValue")
    private String columnWidestValue;
    @JsonProperty("DataType")
    private String dataType;
    @JsonProperty("IsPrimaryKey")
    private Boolean isPrimaryKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The dataItemColumnName
     */
    @JsonProperty("DataItemColumnName")
    public String getDataItemColumnName() {
        return dataItemColumnName;
    }

    /**
     * 
     * @param dataItemColumnName
     *     The DataItemColumnName
     */
    @JsonProperty("DataItemColumnName")
    public void setDataItemColumnName(String dataItemColumnName) {
        this.dataItemColumnName = dataItemColumnName;
    }

    /**
     * 
     * @return
     *     The columnWidestValue
     */
    @JsonProperty("ColumnWidestValue")
    public String getColumnWidestValue() {
        return columnWidestValue;
    }

    /**
     * 
     * @param columnWidestValue
     *     The ColumnWidestValue
     */
    @JsonProperty("ColumnWidestValue")
    public void setColumnWidestValue(String columnWidestValue) {
        this.columnWidestValue = columnWidestValue;
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
     *     The isPrimaryKey
     */
    @JsonProperty("IsPrimaryKey")
    public Boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }

    /**
     * 
     * @param isPrimaryKey
     *     The IsPrimaryKey
     */
    @JsonProperty("IsPrimaryKey")
    public void setIsPrimaryKey(Boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
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
