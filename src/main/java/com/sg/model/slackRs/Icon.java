
package com.sg.model.slackRs;

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
    "image_34",
    "image_44",
    "image_68",
    "image_88",
    "image_102",
    "image_132",
    "image_230",
    "image_default"
})
public class Icon {

    @JsonProperty("image_34")
    private String image34;
    @JsonProperty("image_44")
    private String image44;
    @JsonProperty("image_68")
    private String image68;
    @JsonProperty("image_88")
    private String image88;
    @JsonProperty("image_102")
    private String image102;
    @JsonProperty("image_132")
    private String image132;
    @JsonProperty("image_230")
    private String image230;
    @JsonProperty("image_default")
    private Boolean imageDefault;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The image34
     */
    @JsonProperty("image_34")
    public String getImage34() {
        return image34;
    }

    /**
     * 
     * @param image34
     *     The image_34
     */
    @JsonProperty("image_34")
    public void setImage34(String image34) {
        this.image34 = image34;
    }

    /**
     * 
     * @return
     *     The image44
     */
    @JsonProperty("image_44")
    public String getImage44() {
        return image44;
    }

    /**
     * 
     * @param image44
     *     The image_44
     */
    @JsonProperty("image_44")
    public void setImage44(String image44) {
        this.image44 = image44;
    }

    /**
     * 
     * @return
     *     The image68
     */
    @JsonProperty("image_68")
    public String getImage68() {
        return image68;
    }

    /**
     * 
     * @param image68
     *     The image_68
     */
    @JsonProperty("image_68")
    public void setImage68(String image68) {
        this.image68 = image68;
    }

    /**
     * 
     * @return
     *     The image88
     */
    @JsonProperty("image_88")
    public String getImage88() {
        return image88;
    }

    /**
     * 
     * @param image88
     *     The image_88
     */
    @JsonProperty("image_88")
    public void setImage88(String image88) {
        this.image88 = image88;
    }

    /**
     * 
     * @return
     *     The image102
     */
    @JsonProperty("image_102")
    public String getImage102() {
        return image102;
    }

    /**
     * 
     * @param image102
     *     The image_102
     */
    @JsonProperty("image_102")
    public void setImage102(String image102) {
        this.image102 = image102;
    }

    /**
     * 
     * @return
     *     The image132
     */
    @JsonProperty("image_132")
    public String getImage132() {
        return image132;
    }

    /**
     * 
     * @param image132
     *     The image_132
     */
    @JsonProperty("image_132")
    public void setImage132(String image132) {
        this.image132 = image132;
    }

    /**
     * 
     * @return
     *     The image230
     */
    @JsonProperty("image_230")
    public String getImage230() {
        return image230;
    }

    /**
     * 
     * @param image230
     *     The image_230
     */
    @JsonProperty("image_230")
    public void setImage230(String image230) {
        this.image230 = image230;
    }

    /**
     * 
     * @return
     *     The imageDefault
     */
    @JsonProperty("image_default")
    public Boolean getImageDefault() {
        return imageDefault;
    }

    /**
     * 
     * @param imageDefault
     *     The image_default
     */
    @JsonProperty("image_default")
    public void setImageDefault(Boolean imageDefault) {
        this.imageDefault = imageDefault;
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
