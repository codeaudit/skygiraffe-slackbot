
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
    "Data",
    "SlicerMembers"
})
public class Data {

    @JsonProperty("Data")
    private List<Datum> data = new ArrayList<Datum>();
    @JsonProperty("SlicerMembers")
    private List<SlicerMember> slicerMembers = new ArrayList<SlicerMember>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("Data")
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The Data
     */
    @JsonProperty("Data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The slicerMembers
     */
    @JsonProperty("SlicerMembers")
    public List<SlicerMember> getSlicerMembers() {
        return slicerMembers;
    }

    /**
     *
     * @param slicerMembers
     * The SlicerMembers
     */
    @JsonProperty("SlicerMembers")
    public void setSlicerMembers(List<SlicerMember> slicerMembers) {
        this.slicerMembers = slicerMembers;
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
