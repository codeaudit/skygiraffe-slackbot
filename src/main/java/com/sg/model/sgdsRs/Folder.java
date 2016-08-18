
package com.sg.model.sgdsRs;

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
    "FolderID",
    "FolderName",
    "FolderOrdinal",
    "Reports"
})
public class Folder {

    @JsonProperty("FolderID")
    private String folderID;
    @JsonProperty("FolderName")
    private String folderName;
    @JsonProperty("FolderOrdinal")
    private Integer folderOrdinal;
    @JsonProperty("Reports")
    private List<Report> reports = new ArrayList<Report>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The folderID
     */
    @JsonProperty("FolderID")
    public String getFolderID() {
        return folderID;
    }

    /**
     * 
     * @param folderID
     *     The FolderID
     */
    @JsonProperty("FolderID")
    public void setFolderID(String folderID) {
        this.folderID = folderID;
    }

    /**
     * 
     * @return
     *     The folderName
     */
    @JsonProperty("FolderName")
    public String getFolderName() {
        return folderName;
    }

    /**
     * 
     * @param folderName
     *     The FolderName
     */
    @JsonProperty("FolderName")
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    /**
     * 
     * @return
     *     The folderOrdinal
     */
    @JsonProperty("FolderOrdinal")
    public Integer getFolderOrdinal() {
        return folderOrdinal;
    }

    /**
     * 
     * @param folderOrdinal
     *     The FolderOrdinal
     */
    @JsonProperty("FolderOrdinal")
    public void setFolderOrdinal(Integer folderOrdinal) {
        this.folderOrdinal = folderOrdinal;
    }

    /**
     * 
     * @return
     *     The reports
     */
    @JsonProperty("Reports")
    public List<Report> getReports() {
        return reports;
    }

    /**
     * 
     * @param reports
     *     The Reports
     */
    @JsonProperty("Reports")
    public void setReports(List<Report> reports) {
        this.reports = reports;
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
