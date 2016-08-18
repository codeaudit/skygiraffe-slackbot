
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
    "ActionLocation",
    "ActionName",
    "ButtonText",
    "ActionParameters",
    "ActionLabels"
})
public class Action {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("ActionLocation")
    private String actionLocation;
    @JsonProperty("ActionName")
    private String actionName;
    @JsonProperty("ButtonText")
    private String buttonText;
    @JsonProperty("ActionParameters")
    private List<ActionParameter> actionParameters = new ArrayList<ActionParameter>();
    @JsonProperty("ActionLabels")
    private Object actionLabels;
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
     *     The actionLocation
     */
    @JsonProperty("ActionLocation")
    public String getActionLocation() {
        return actionLocation;
    }

    /**
     * 
     * @param actionLocation
     *     The ActionLocation
     */
    @JsonProperty("ActionLocation")
    public void setActionLocation(String actionLocation) {
        this.actionLocation = actionLocation;
    }

    /**
     * 
     * @return
     *     The actionName
     */
    @JsonProperty("ActionName")
    public String getActionName() {
        return actionName;
    }

    /**
     * 
     * @param actionName
     *     The ActionName
     */
    @JsonProperty("ActionName")
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * 
     * @return
     *     The buttonText
     */
    @JsonProperty("ButtonText")
    public String getButtonText() {
        return buttonText;
    }

    /**
     * 
     * @param buttonText
     *     The ButtonText
     */
    @JsonProperty("ButtonText")
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    /**
     * 
     * @return
     *     The actionParameters
     */
    @JsonProperty("ActionParameters")
    public List<ActionParameter> getActionParameters() {
        return actionParameters;
    }

    /**
     * 
     * @param actionParameters
     *     The ActionParameters
     */
    @JsonProperty("ActionParameters")
    public void setActionParameters(List<ActionParameter> actionParameters) {
        this.actionParameters = actionParameters;
    }

    /**
     * 
     * @return
     *     The actionLabels
     */
    @JsonProperty("ActionLabels")
    public Object getActionLabels() {
        return actionLabels;
    }

    /**
     * 
     * @param actionLabels
     *     The ActionLabels
     */
    @JsonProperty("ActionLabels")
    public void setActionLabels(Object actionLabels) {
        this.actionLabels = actionLabels;
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
