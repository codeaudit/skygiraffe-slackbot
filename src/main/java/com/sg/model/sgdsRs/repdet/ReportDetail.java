
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
    "Status",
    "Msg",
    "ReportMetaData",
    "Data"
})
public class ReportDetail {

    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("ReportMetaData")
    private ReportMetaData reportMetaData;
    @JsonProperty("Data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The msg
     */
    @JsonProperty("Msg")
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @param msg
     *     The Msg
     */
    @JsonProperty("Msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 
     * @return
     *     The reportMetaData
     */
    @JsonProperty("ReportMetaData")
    public ReportMetaData getReportMetaData() {
        return reportMetaData;
    }

    /**
     * 
     * @param reportMetaData
     *     The ReportMetaData
     */
    @JsonProperty("ReportMetaData")
    public void setReportMetaData(ReportMetaData reportMetaData) {
        this.reportMetaData = reportMetaData;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("Data")
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The Data
     */
    @JsonProperty("Data")
    public void setData(Data data) {
        this.data = data;
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
