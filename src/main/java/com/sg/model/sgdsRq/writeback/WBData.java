
package com.sg.model.sgdsRq.writeback;

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
    "Rows",
    "Action"
})
public class WBData {

    @JsonProperty("Rows")
    private List<Row> rows = new ArrayList<Row>();
    @JsonProperty("Action")
    private Action action;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The action
     */
    @JsonProperty("Action")
    public Action getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The Action
     */
    @JsonProperty("Action")
    public void setAction(Action action) {
        this.action = action;
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
