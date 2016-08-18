
package com.sg.model.sgdsRs.writeback;

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
    "Msg",
    "Result",
    "Status"
})
public class WritebackStatusRs {

    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("Result")
    private Integer result;
    @JsonProperty("Status")
    private Integer status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The result
     */
    @JsonProperty("Result")
    public Integer getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The Result
     */
    @JsonProperty("Result")
    public void setResult(Integer result) {
        this.result = result;
    }

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
