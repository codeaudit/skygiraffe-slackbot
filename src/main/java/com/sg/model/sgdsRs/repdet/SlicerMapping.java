
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
    "TabID",
    "SourceDataItemColumn"
})
public class SlicerMapping {

    @JsonProperty("TabID")
    private String tabID;
    @JsonProperty("SourceDataItemColumn")
    private String sourceDataItemColumn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The sourceDataItemColumn
     */
    @JsonProperty("SourceDataItemColumn")
    public String getSourceDataItemColumn() {
        return sourceDataItemColumn;
    }

    /**
     * 
     * @param sourceDataItemColumn
     *     The SourceDataItemColumn
     */
    @JsonProperty("SourceDataItemColumn")
    public void setSourceDataItemColumn(String sourceDataItemColumn) {
        this.sourceDataItemColumn = sourceDataItemColumn;
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
