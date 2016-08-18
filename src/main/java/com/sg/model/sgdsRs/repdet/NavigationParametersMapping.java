
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
    "ReportParameterID",
    "DataItemColumnID"
})
public class NavigationParametersMapping {

    @JsonProperty("ReportParameterID")
    private String reportParameterID;
    @JsonProperty("DataItemColumnID")
    private String dataItemColumnID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The reportParameterID
     */
    @JsonProperty("ReportParameterID")
    public String getReportParameterID() {
        return reportParameterID;
    }

    /**
     * 
     * @param reportParameterID
     *     The ReportParameterID
     */
    @JsonProperty("ReportParameterID")
    public void setReportParameterID(String reportParameterID) {
        this.reportParameterID = reportParameterID;
    }

    /**
     * 
     * @return
     *     The dataItemColumnID
     */
    @JsonProperty("DataItemColumnID")
    public String getDataItemColumnID() {
        return dataItemColumnID;
    }

    /**
     * 
     * @param dataItemColumnID
     *     The DataItemColumnID
     */
    @JsonProperty("DataItemColumnID")
    public void setDataItemColumnID(String dataItemColumnID) {
        this.dataItemColumnID = dataItemColumnID;
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
