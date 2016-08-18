
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
    "OpenReport",
    "OpenTemplate",
    "NavigationMappings",
    "NavigationParametersMappings"
})
public class Navigation {

    @JsonProperty("OpenReport")
    private String openReport;
    @JsonProperty("OpenTemplate")
    private String openTemplate;
    @JsonProperty("NavigationMappings")
    private List<NavigationMapping> navigationMappings = new ArrayList<NavigationMapping>();
    @JsonProperty("NavigationParametersMappings")
    private List<NavigationParametersMapping> navigationParametersMappings = new ArrayList<NavigationParametersMapping>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The openReport
     */
    @JsonProperty("OpenReport")
    public String getOpenReport() {
        return openReport;
    }

    /**
     * 
     * @param openReport
     *     The OpenReport
     */
    @JsonProperty("OpenReport")
    public void setOpenReport(String openReport) {
        this.openReport = openReport;
    }

    /**
     * 
     * @return
     *     The openTemplate
     */
    @JsonProperty("OpenTemplate")
    public String getOpenTemplate() {
        return openTemplate;
    }

    /**
     * 
     * @param openTemplate
     *     The OpenTemplate
     */
    @JsonProperty("OpenTemplate")
    public void setOpenTemplate(String openTemplate) {
        this.openTemplate = openTemplate;
    }

    /**
     * 
     * @return
     *     The navigationMappings
     */
    @JsonProperty("NavigationMappings")
    public List<NavigationMapping> getNavigationMappings() {
        return navigationMappings;
    }

    /**
     * 
     * @param navigationMappings
     *     The NavigationMappings
     */
    @JsonProperty("NavigationMappings")
    public void setNavigationMappings(List<NavigationMapping> navigationMappings) {
        this.navigationMappings = navigationMappings;
    }

    /**
     * 
     * @return
     *     The navigationParametersMappings
     */
    @JsonProperty("NavigationParametersMappings")
    public List<NavigationParametersMapping> getNavigationParametersMappings() {
        return navigationParametersMappings;
    }

    /**
     * 
     * @param navigationParametersMappings
     *     The NavigationParametersMappings
     */
    @JsonProperty("NavigationParametersMappings")
    public void setNavigationParametersMappings(List<NavigationParametersMapping> navigationParametersMappings) {
        this.navigationParametersMappings = navigationParametersMappings;
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
