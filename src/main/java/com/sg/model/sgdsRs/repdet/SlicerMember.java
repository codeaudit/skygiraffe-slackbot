
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
    "Members"
})
public class SlicerMember {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Members")
    private List<String> members = new ArrayList<String>();
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
     *     The members
     */
    @JsonProperty("Members")
    public List<String> getMembers() {
        return members;
    }

    /**
     * 
     * @param members
     *     The Members
     */
    @JsonProperty("Members")
    public void setMembers(List<String> members) {
        this.members = members;
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
