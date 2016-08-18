
package com.sg.model.sgdsRs.action;

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
    "ID",
    "C1",
    "C2",
    "C3"
})
public class Row {

    @JsonProperty("ID")
    private Integer iD;
    @JsonProperty("C1")
    private String c1;
    @JsonProperty("C2")
    private String c2;
    @JsonProperty("C3")
    private String c3;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The iD
     */
    @JsonProperty("ID")
    public Integer getID() {
        return iD;
    }

    /**
     * 
     * @param iD
     *     The ID
     */
    @JsonProperty("ID")
    public void setID(Integer iD) {
        this.iD = iD;
    }

    /**
     * 
     * @return
     *     The c1
     */
    @JsonProperty("C1")
    public String getC1() {
        return c1;
    }

    /**
     * 
     * @param c1
     *     The C1
     */
    @JsonProperty("C1")
    public void setC1(String c1) {
        this.c1 = c1;
    }

    /**
     * 
     * @return
     *     The c2
     */
    @JsonProperty("C2")
    public String getC2() {
        return c2;
    }

    /**
     * 
     * @param c2
     *     The C2
     */
    @JsonProperty("C2")
    public void setC2(String c2) {
        this.c2 = c2;
    }

    /**
     * 
     * @return
     *     The c3
     */
    @JsonProperty("C3")
    public String getC3() {
        return c3;
    }

    /**
     * 
     * @param c3
     *     The C3
     */
    @JsonProperty("C3")
    public void setC3(String c3) {
        this.c3 = c3;
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
