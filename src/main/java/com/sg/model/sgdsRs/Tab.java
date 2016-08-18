
package com.sg.model.sgdsRs;

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
    "TabName",
    "TabTemplate"
})
public class Tab {

    @JsonProperty("TabName")
    private String tabName;
    @JsonProperty("TabTemplate")
    private TabTemplate tabTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The tabName
     */
    @JsonProperty("TabName")
    public String getTabName() {
        return tabName;
    }

    /**
     * 
     * @param tabName
     *     The TabName
     */
    @JsonProperty("TabName")
    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    /**
     * 
     * @return
     *     The tabTemplate
     */
    @JsonProperty("TabTemplate")
    public TabTemplate getTabTemplate() {
        return tabTemplate;
    }

    /**
     * 
     * @param tabTemplate
     *     The TabTemplate
     */
    @JsonProperty("TabTemplate")
    public void setTabTemplate(TabTemplate tabTemplate) {
        this.tabTemplate = tabTemplate;
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
