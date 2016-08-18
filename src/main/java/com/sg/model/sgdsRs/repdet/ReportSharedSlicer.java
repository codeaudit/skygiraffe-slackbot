
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
    "SingleSelect",
    "FriendlyName",
    "SlicerIcon",
    "SlicerMappings"
})
public class ReportSharedSlicer {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("SingleSelect")
    private Boolean singleSelect;
    @JsonProperty("FriendlyName")
    private String friendlyName;
    @JsonProperty("SlicerIcon")
    private String slicerIcon;
    @JsonProperty("SlicerMappings")
    private List<SlicerMapping> slicerMappings = new ArrayList<SlicerMapping>();
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
     *     The singleSelect
     */
    @JsonProperty("SingleSelect")
    public Boolean getSingleSelect() {
        return singleSelect;
    }

    /**
     * 
     * @param singleSelect
     *     The SingleSelect
     */
    @JsonProperty("SingleSelect")
    public void setSingleSelect(Boolean singleSelect) {
        this.singleSelect = singleSelect;
    }

    /**
     * 
     * @return
     *     The friendlyName
     */
    @JsonProperty("FriendlyName")
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * 
     * @param friendlyName
     *     The FriendlyName
     */
    @JsonProperty("FriendlyName")
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * 
     * @return
     *     The slicerIcon
     */
    @JsonProperty("SlicerIcon")
    public String getSlicerIcon() {
        return slicerIcon;
    }

    /**
     * 
     * @param slicerIcon
     *     The SlicerIcon
     */
    @JsonProperty("SlicerIcon")
    public void setSlicerIcon(String slicerIcon) {
        this.slicerIcon = slicerIcon;
    }

    /**
     * 
     * @return
     *     The slicerMappings
     */
    @JsonProperty("SlicerMappings")
    public List<SlicerMapping> getSlicerMappings() {
        return slicerMappings;
    }

    /**
     * 
     * @param slicerMappings
     *     The SlicerMappings
     */
    @JsonProperty("SlicerMappings")
    public void setSlicerMappings(List<SlicerMapping> slicerMappings) {
        this.slicerMappings = slicerMappings;
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
