
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
    "Shape",
    "FontName",
    "Value",
    "FontColor",
    "BackgroundColor"
})
public class ReportIcon {

    @JsonProperty("Shape")
    private String shape;
    @JsonProperty("FontName")
    private String fontName;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("FontColor")
    private String fontColor;
    @JsonProperty("BackgroundColor")
    private String backgroundColor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The shape
     */
    @JsonProperty("Shape")
    public String getShape() {
        return shape;
    }

    /**
     * 
     * @param shape
     *     The Shape
     */
    @JsonProperty("Shape")
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * 
     * @return
     *     The fontName
     */
    @JsonProperty("FontName")
    public String getFontName() {
        return fontName;
    }

    /**
     * 
     * @param fontName
     *     The FontName
     */
    @JsonProperty("FontName")
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The Value
     */
    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The fontColor
     */
    @JsonProperty("FontColor")
    public String getFontColor() {
        return fontColor;
    }

    /**
     * 
     * @param fontColor
     *     The FontColor
     */
    @JsonProperty("FontColor")
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * 
     * @return
     *     The backgroundColor
     */
    @JsonProperty("BackgroundColor")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 
     * @param backgroundColor
     *     The BackgroundColor
     */
    @JsonProperty("BackgroundColor")
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
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
