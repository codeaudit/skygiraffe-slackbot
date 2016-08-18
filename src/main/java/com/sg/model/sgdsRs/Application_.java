
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
    "ApplicationDescription",
    "ApplicationID",
    "ApplicationIcon",
    "ApplicationName",
    "CreationDate",
    "Folders",
    "IsDefault",
    "LastUpdateDate",
    "Owner"
})
public class Application_ {

    @JsonProperty("ApplicationDescription")
    private String applicationDescription;
    @JsonProperty("ApplicationID")
    private String applicationID;
    @JsonProperty("ApplicationIcon")
    private ApplicationIcon applicationIcon;
    @JsonProperty("ApplicationName")
    private String applicationName;
    @JsonProperty("CreationDate")
    private String creationDate;
    @JsonProperty("Folders")
    private List<Folder> folders = new ArrayList<Folder>();
    @JsonProperty("IsDefault")
    private Boolean isDefault;
    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate;
    @JsonProperty("Owner")
    private String owner;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The applicationDescription
     */
    @JsonProperty("ApplicationDescription")
    public String getApplicationDescription() {
        return applicationDescription;
    }

    /**
     * 
     * @param applicationDescription
     *     The ApplicationDescription
     */
    @JsonProperty("ApplicationDescription")
    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    /**
     * 
     * @return
     *     The applicationID
     */
    @JsonProperty("ApplicationID")
    public String getApplicationID() {
        return applicationID;
    }

    /**
     * 
     * @param applicationID
     *     The ApplicationID
     */
    @JsonProperty("ApplicationID")
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * 
     * @return
     *     The applicationIcon
     */
    @JsonProperty("ApplicationIcon")
    public ApplicationIcon getApplicationIcon() {
        return applicationIcon;
    }

    /**
     * 
     * @param applicationIcon
     *     The ApplicationIcon
     */
    @JsonProperty("ApplicationIcon")
    public void setApplicationIcon(ApplicationIcon applicationIcon) {
        this.applicationIcon = applicationIcon;
    }

    /**
     * 
     * @return
     *     The applicationName
     */
    @JsonProperty("ApplicationName")
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 
     * @param applicationName
     *     The ApplicationName
     */
    @JsonProperty("ApplicationName")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("CreationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The CreationDate
     */
    @JsonProperty("CreationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The folders
     */
    @JsonProperty("Folders")
    public List<Folder> getFolders() {
        return folders;
    }

    /**
     * 
     * @param folders
     *     The Folders
     */
    @JsonProperty("Folders")
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    /**
     * 
     * @return
     *     The isDefault
     */
    @JsonProperty("IsDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 
     * @param isDefault
     *     The IsDefault
     */
    @JsonProperty("IsDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 
     * @return
     *     The lastUpdateDate
     */
    @JsonProperty("LastUpdateDate")
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 
     * @param lastUpdateDate
     *     The LastUpdateDate
     */
    @JsonProperty("LastUpdateDate")
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 
     * @return
     *     The owner
     */
    @JsonProperty("Owner")
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The Owner
     */
    @JsonProperty("Owner")
    public void setOwner(String owner) {
        this.owner = owner;
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
