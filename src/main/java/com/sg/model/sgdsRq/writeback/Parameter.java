
package com.sg.model.sgdsRq.writeback;

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
    "ParameterID",
    "SelectedValue"
})
public class Parameter {

    @JsonProperty("ParameterID")
    private String parameterID;
    @JsonProperty("SelectedValue")
    private String selectedValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The parameterID
     */
    @JsonProperty("ParameterID")
    public String getParameterID() {
        return parameterID;
    }

    /**
     * 
     * @param parameterID
     *     The ParameterID
     */
    @JsonProperty("ParameterID")
    public void setParameterID(String parameterID) {
        this.parameterID = parameterID;
    }

    /**
     * 
     * @return
     *     The selectedValue
     */
    @JsonProperty("SelectedValue")
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * 
     * @param selectedValue
     *     The SelectedValue
     */
    @JsonProperty("SelectedValue")
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
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
