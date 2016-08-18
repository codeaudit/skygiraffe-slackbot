
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
    "SourceType",
    "SourceID",
    "MapToParameterName"
})
public class ParameterMapping {

    @JsonProperty("SourceType")
    private String sourceType;
    @JsonProperty("SourceID")
    private String sourceID;
    @JsonProperty("MapToParameterName")
    private String mapToParameterName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The sourceType
     */
    @JsonProperty("SourceType")
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 
     * @param sourceType
     *     The SourceType
     */
    @JsonProperty("SourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 
     * @return
     *     The sourceID
     */
    @JsonProperty("SourceID")
    public String getSourceID() {
        return sourceID;
    }

    /**
     * 
     * @param sourceID
     *     The SourceID
     */
    @JsonProperty("SourceID")
    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    /**
     * 
     * @return
     *     The mapToParameterName
     */
    @JsonProperty("MapToParameterName")
    public String getMapToParameterName() {
        return mapToParameterName;
    }

    /**
     * 
     * @param mapToParameterName
     *     The MapToParameterName
     */
    @JsonProperty("MapToParameterName")
    public void setMapToParameterName(String mapToParameterName) {
        this.mapToParameterName = mapToParameterName;
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
