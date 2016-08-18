
package com.sg.model.sgdsRs.paramRs;

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
    "Status",
    "Msg",
    "Parameters",
    "Data"
})
public class ParametersMain {

    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("Parameters")
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @JsonProperty("Data")
    private Object data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The msg
     */
    @JsonProperty("Msg")
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @param msg
     *     The Msg
     */
    @JsonProperty("Msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 
     * @return
     *     The parameters
     */
    @JsonProperty("Parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The Parameters
     */
    @JsonProperty("Parameters")
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("Data")
    public Object getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The Data
     */
    @JsonProperty("Data")
    public void setData(Object data) {
        this.data = data;
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
