
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
    "UpdateID",
    "DataItemName",
    "DataItemID",
    "StructureType",
    "NumOfColumns",
    "Columns",
    "Rows",
    "WasDataTrimmed"
})
public class Datum {

    @JsonProperty("UpdateID")
    private String updateID;
    @JsonProperty("DataItemName")
    private String dataItemName;
    @JsonProperty("DataItemID")
    private String dataItemID;
    @JsonProperty("StructureType")
    private String structureType;
    @JsonProperty("NumOfColumns")
    private Integer numOfColumns;
    @JsonProperty("Columns")
    private List<Column> columns = new ArrayList<Column>();
    @JsonProperty("Rows")
    private List<Row> rows = new ArrayList<Row>();
    @JsonProperty("WasDataTrimmed")
    private Boolean wasDataTrimmed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The updateID
     */
    @JsonProperty("UpdateID")
    public String getUpdateID() {
        return updateID;
    }

    /**
     * 
     * @param updateID
     *     The UpdateID
     */
    @JsonProperty("UpdateID")
    public void setUpdateID(String updateID) {
        this.updateID = updateID;
    }

    /**
     * 
     * @return
     *     The dataItemName
     */
    @JsonProperty("DataItemName")
    public String getDataItemName() {
        return dataItemName;
    }

    /**
     * 
     * @param dataItemName
     *     The DataItemName
     */
    @JsonProperty("DataItemName")
    public void setDataItemName(String dataItemName) {
        this.dataItemName = dataItemName;
    }

    /**
     * 
     * @return
     *     The dataItemID
     */
    @JsonProperty("DataItemID")
    public String getDataItemID() {
        return dataItemID;
    }

    /**
     * 
     * @param dataItemID
     *     The DataItemID
     */
    @JsonProperty("DataItemID")
    public void setDataItemID(String dataItemID) {
        this.dataItemID = dataItemID;
    }

    /**
     * 
     * @return
     *     The structureType
     */
    @JsonProperty("StructureType")
    public String getStructureType() {
        return structureType;
    }

    /**
     * 
     * @param structureType
     *     The StructureType
     */
    @JsonProperty("StructureType")
    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    /**
     * 
     * @return
     *     The numOfColumns
     */
    @JsonProperty("NumOfColumns")
    public Integer getNumOfColumns() {
        return numOfColumns;
    }

    /**
     * 
     * @param numOfColumns
     *     The NumOfColumns
     */
    @JsonProperty("NumOfColumns")
    public void setNumOfColumns(Integer numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

    /**
     * 
     * @return
     *     The columns
     */
    @JsonProperty("Columns")
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * 
     * @param columns
     *     The Columns
     */
    @JsonProperty("Columns")
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * 
     * @return
     *     The rows
     */
    @JsonProperty("Rows")
    public List<Row> getRows() {
        return rows;
    }

    /**
     * 
     * @param rows
     *     The Rows
     */
    @JsonProperty("Rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    /**
     * 
     * @return
     *     The wasDataTrimmed
     */
    @JsonProperty("WasDataTrimmed")
    public Boolean getWasDataTrimmed() {
        return wasDataTrimmed;
    }

    /**
     * 
     * @param wasDataTrimmed
     *     The WasDataTrimmed
     */
    @JsonProperty("WasDataTrimmed")
    public void setWasDataTrimmed(Boolean wasDataTrimmed) {
        this.wasDataTrimmed = wasDataTrimmed;
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
