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
        "ID",
        "Value",
        "IsDefault"
})
public class AllowedMember {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("IsDefault")
    private Boolean isDefault;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The iD
     */
    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    /**
     *
     * @param iD
     * The ID
     */
    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     *
     * @return
     * The value
     */
    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The Value
     */
    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The isDefault
     */
    @JsonProperty("IsDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *
     * @param isDefault
     * The IsDefault
     */
    @JsonProperty("IsDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
