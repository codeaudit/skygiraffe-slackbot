
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
    "ParameterID",
    "ParameterLabel",
    "ValueID",
    "ValueLabel"
})
public class Parameter {

    @JsonProperty("ParameterID")
    private String parameterID;
    @JsonProperty("ParameterLabel")
    private String parameterLabel;
    @JsonProperty("ValueID")
    private String valueID;
    @JsonProperty("ValueLabel")
    private String valueLabel;
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
     *     The parameterLabel
     */
    @JsonProperty("ParameterLabel")
    public String getParameterLabel() {
        return parameterLabel;
    }

    /**
     * 
     * @param parameterLabel
     *     The ParameterLabel
     */
    @JsonProperty("ParameterLabel")
    public void setParameterLabel(String parameterLabel) {
        this.parameterLabel = parameterLabel;
    }

    /**
     * 
     * @return
     *     The valueID
     */
    @JsonProperty("ValueID")
    public String getValueID() {
        return valueID;
    }

    /**
     * 
     * @param valueID
     *     The ValueID
     */
    @JsonProperty("ValueID")
    public void setValueID(String valueID) {
        this.valueID = valueID;
    }

    /**
     * 
     * @return
     *     The valueLabel
     */
    @JsonProperty("ValueLabel")
    public String getValueLabel() {
        return valueLabel;
    }

    /**
     * 
     * @param valueLabel
     *     The ValueLabel
     */
    @JsonProperty("ValueLabel")
    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
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
