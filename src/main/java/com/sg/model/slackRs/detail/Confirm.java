
package com.sg.model.slackRs.detail;

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
    "title",
    "text",
    "ok_text",
    "dismiss_text"
})
public class Confirm {

    @JsonProperty("title")
    private String title;
    @JsonProperty("text")
    private String text;
    @JsonProperty("ok_text")
    private String okText;
    @JsonProperty("dismiss_text")
    private String dismissText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

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
     *     The okText
     */
    @JsonProperty("ok_text")
    public String getOkText() {
        return okText;
    }

    /**
     * 
     * @param okText
     *     The ok_text
     */
    @JsonProperty("ok_text")
    public void setOkText(String okText) {
        this.okText = okText;
    }

    /**
     * 
     * @return
     *     The dismissText
     */
    @JsonProperty("dismiss_text")
    public String getDismissText() {
        return dismissText;
    }

    /**
     * 
     * @param dismissText
     *     The dismiss_text
     */
    @JsonProperty("dismiss_text")
    public void setDismissText(String dismissText) {
        this.dismissText = dismissText;
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
