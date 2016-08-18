
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
    "TabName",
    "TabTitle",
    "TabOrdinal",
    "Template"
})
public class Tab {

    @JsonProperty("TabName")
    private String tabName;
    @JsonProperty("TabTitle")
    private String tabTitle;
    @JsonProperty("TabOrdinal")
    private Integer tabOrdinal;
    @JsonProperty("Template")
    private Template template;
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
     *     The tabTitle
     */
    @JsonProperty("TabTitle")
    public String getTabTitle() {
        return tabTitle;
    }

    /**
     * 
     * @param tabTitle
     *     The TabTitle
     */
    @JsonProperty("TabTitle")
    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    /**
     * 
     * @return
     *     The tabOrdinal
     */
    @JsonProperty("TabOrdinal")
    public Integer getTabOrdinal() {
        return tabOrdinal;
    }

    /**
     * 
     * @param tabOrdinal
     *     The TabOrdinal
     */
    @JsonProperty("TabOrdinal")
    public void setTabOrdinal(Integer tabOrdinal) {
        this.tabOrdinal = tabOrdinal;
    }

    /**
     * 
     * @return
     *     The template
     */
    @JsonProperty("Template")
    public Template getTemplate() {
        return template;
    }

    /**
     * 
     * @param template
     *     The Template
     */
    @JsonProperty("Template")
    public void setTemplate(Template template) {
        this.template = template;
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
