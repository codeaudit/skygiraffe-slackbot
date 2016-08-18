
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
    "first_name",
    "last_name",
    "avatar_hash",
    "real_name",
    "real_name_normalized",
    "email",
    "image_24",
    "image_32",
    "image_48",
    "image_72",
    "image_192",
    "image_512",
    "fields"
})
public class Profile {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("avatar_hash")
    private String avatarHash;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("real_name_normalized")
    private String realNameNormalized;
    @JsonProperty("email")
    private String email;
    @JsonProperty("image_24")
    private String image24;
    @JsonProperty("image_32")
    private String image32;
    @JsonProperty("image_48")
    private String image48;
    @JsonProperty("image_72")
    private String image72;
    @JsonProperty("image_192")
    private String image192;
    @JsonProperty("image_512")
    private String image512;
    @JsonProperty("fields")
    private Object fields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The firstName
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The avatarHash
     */
    @JsonProperty("avatar_hash")
    public String getAvatarHash() {
        return avatarHash;
    }

    /**
     * 
     * @param avatarHash
     *     The avatar_hash
     */
    @JsonProperty("avatar_hash")
    public void setAvatarHash(String avatarHash) {
        this.avatarHash = avatarHash;
    }

    /**
     * 
     * @return
     *     The realName
     */
    @JsonProperty("real_name")
    public String getRealName() {
        return realName;
    }

    /**
     * 
     * @param realName
     *     The real_name
     */
    @JsonProperty("real_name")
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 
     * @return
     *     The realNameNormalized
     */
    @JsonProperty("real_name_normalized")
    public String getRealNameNormalized() {
        return realNameNormalized;
    }

    /**
     * 
     * @param realNameNormalized
     *     The real_name_normalized
     */
    @JsonProperty("real_name_normalized")
    public void setRealNameNormalized(String realNameNormalized) {
        this.realNameNormalized = realNameNormalized;
    }

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The image24
     */
    @JsonProperty("image_24")
    public String getImage24() {
        return image24;
    }

    /**
     * 
     * @param image24
     *     The image_24
     */
    @JsonProperty("image_24")
    public void setImage24(String image24) {
        this.image24 = image24;
    }

    /**
     * 
     * @return
     *     The image32
     */
    @JsonProperty("image_32")
    public String getImage32() {
        return image32;
    }

    /**
     * 
     * @param image32
     *     The image_32
     */
    @JsonProperty("image_32")
    public void setImage32(String image32) {
        this.image32 = image32;
    }

    /**
     * 
     * @return
     *     The image48
     */
    @JsonProperty("image_48")
    public String getImage48() {
        return image48;
    }

    /**
     * 
     * @param image48
     *     The image_48
     */
    @JsonProperty("image_48")
    public void setImage48(String image48) {
        this.image48 = image48;
    }

    /**
     * 
     * @return
     *     The image72
     */
    @JsonProperty("image_72")
    public String getImage72() {
        return image72;
    }

    /**
     * 
     * @param image72
     *     The image_72
     */
    @JsonProperty("image_72")
    public void setImage72(String image72) {
        this.image72 = image72;
    }

    /**
     * 
     * @return
     *     The image192
     */
    @JsonProperty("image_192")
    public String getImage192() {
        return image192;
    }

    /**
     * 
     * @param image192
     *     The image_192
     */
    @JsonProperty("image_192")
    public void setImage192(String image192) {
        this.image192 = image192;
    }

    /**
     * 
     * @return
     *     The image512
     */
    @JsonProperty("image_512")
    public String getImage512() {
        return image512;
    }

    /**
     * 
     * @param image512
     *     The image_512
     */
    @JsonProperty("image_512")
    public void setImage512(String image512) {
        this.image512 = image512;
    }

    /**
     * 
     * @return
     *     The fields
     */
    @JsonProperty("fields")
    public Object getFields() {
        return fields;
    }

    /**
     * 
     * @param fields
     *     The fields
     */
    @JsonProperty("fields")
    public void setFields(Object fields) {
        this.fields = fields;
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
