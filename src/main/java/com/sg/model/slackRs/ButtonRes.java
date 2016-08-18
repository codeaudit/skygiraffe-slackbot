
package com.sg.model.slackRs;

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
    "text",
    "attachments",
    "response_type",
    "replace_original",
    "delete_original"
})
public class ButtonRes {

    @JsonProperty("text")
    private String text;
    @JsonProperty("attachments")
    private List<Attachment> attachments = new ArrayList<Attachment>();
    @JsonProperty("response_type")
    private String responseType;
    @JsonProperty("replace_original")
    private Boolean replaceOriginal;
    @JsonProperty("delete_original")
    private Boolean deleteOriginal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    /**
     * 
     * @return
     *     The responseType
     */
    @JsonProperty("response_type")
    public String getResponseType() {
        return responseType;
    }

    /**
     * 
     * @param responseType
     *     The response_type
     */
    @JsonProperty("response_type")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    /**
     * 
     * @return
     *     The replaceOriginal
     */
    @JsonProperty("replace_original")
    public Boolean getReplaceOriginal() {
        return replaceOriginal;
    }

    /**
     * 
     * @param replaceOriginal
     *     The replace_original
     */
    @JsonProperty("replace_original")
    public void setReplaceOriginal(Boolean replaceOriginal) {
        this.replaceOriginal = replaceOriginal;
    }

    /**
     * 
     * @return
     *     The deleteOriginal
     */
    @JsonProperty("delete_original")
    public Boolean getDeleteOriginal() {
        return deleteOriginal;
    }

    /**
     * 
     * @param deleteOriginal
     *     The delete_original
     */
    @JsonProperty("delete_original")
    public void setDeleteOriginal(Boolean deleteOriginal) {
        this.deleteOriginal = deleteOriginal;
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
