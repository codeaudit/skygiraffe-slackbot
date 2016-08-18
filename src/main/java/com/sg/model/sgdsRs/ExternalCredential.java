
package com.sg.model.sgdsRs;

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
    "AuthenticationType",
    "AuthorizationURL",
    "ConsumerKey",
    "ConsumerSecret",
    "CredentialType",
    "ID",
    "RedirectURL"
})
public class ExternalCredential {

    @JsonProperty("AuthenticationType")
    private String authenticationType;
    @JsonProperty("AuthorizationURL")
    private String authorizationURL;
    @JsonProperty("ConsumerKey")
    private String consumerKey;
    @JsonProperty("ConsumerSecret")
    private String consumerSecret;
    @JsonProperty("CredentialType")
    private String credentialType;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("RedirectURL")
    private String redirectURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The authenticationType
     */
    @JsonProperty("AuthenticationType")
    public String getAuthenticationType() {
        return authenticationType;
    }

    /**
     * 
     * @param authenticationType
     *     The AuthenticationType
     */
    @JsonProperty("AuthenticationType")
    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * 
     * @return
     *     The authorizationURL
     */
    @JsonProperty("AuthorizationURL")
    public String getAuthorizationURL() {
        return authorizationURL;
    }

    /**
     * 
     * @param authorizationURL
     *     The AuthorizationURL
     */
    @JsonProperty("AuthorizationURL")
    public void setAuthorizationURL(String authorizationURL) {
        this.authorizationURL = authorizationURL;
    }

    /**
     * 
     * @return
     *     The consumerKey
     */
    @JsonProperty("ConsumerKey")
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * 
     * @param consumerKey
     *     The ConsumerKey
     */
    @JsonProperty("ConsumerKey")
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * 
     * @return
     *     The consumerSecret
     */
    @JsonProperty("ConsumerSecret")
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * 
     * @param consumerSecret
     *     The ConsumerSecret
     */
    @JsonProperty("ConsumerSecret")
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    /**
     * 
     * @return
     *     The credentialType
     */
    @JsonProperty("CredentialType")
    public String getCredentialType() {
        return credentialType;
    }

    /**
     * 
     * @param credentialType
     *     The CredentialType
     */
    @JsonProperty("CredentialType")
    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    /**
     * 
     * @return
     *     The iD
     */
    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    /**
     * 
     * @param iD
     *     The ID
     */
    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * 
     * @return
     *     The redirectURL
     */
    @JsonProperty("RedirectURL")
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     * 
     * @param redirectURL
     *     The RedirectURL
     */
    @JsonProperty("RedirectURL")
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
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
