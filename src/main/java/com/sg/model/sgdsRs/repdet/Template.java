
package com.sg.model.sgdsRs.repdet;

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
    "DataItemID",
    "GroupAllContacts",
    "GridColumns",
    "SectionSourceColumnID",
    "HeaderImageColumnID",
    "HeaderImageSource",
    "FirstLayerCardName",
    "SecondLayerCardName",
    "CardMappings",
    "LayoutsUpdateID",
    "ID",
    "Type",
    "Actions",
    "TemplateTitle"
})
public class Template {

    @JsonProperty("DataItemID")
    private String dataItemID;
    @JsonProperty("GroupAllContacts")
    private Boolean groupAllContacts;
    @JsonProperty("GridColumns")
    private List<GridColumn> gridColumns = new ArrayList<GridColumn>();
    @JsonProperty("SectionSourceColumnID")
    private Object sectionSourceColumnID;
    @JsonProperty("HeaderImageColumnID")
    private Object headerImageColumnID;
    @JsonProperty("HeaderImageSource")
    private Object headerImageSource;
    @JsonProperty("FirstLayerCardName")
    private Object firstLayerCardName;
    @JsonProperty("SecondLayerCardName")
    private Object secondLayerCardName;
    @JsonProperty("CardMappings")
    private Object cardMappings;
    @JsonProperty("LayoutsUpdateID")
    private Object layoutsUpdateID;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Actions")
    private List<Action> actions = new ArrayList<Action>();
    @JsonProperty("TemplateTitle")
    private String templateTitle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The dataItemID
     */
    @JsonProperty("DataItemID")
    public String getDataItemID() {
        return dataItemID;
    }

    /**
     * 
     * @param dataItemID
     *     The DataItemID
     */
    @JsonProperty("DataItemID")
    public void setDataItemID(String dataItemID) {
        this.dataItemID = dataItemID;
    }

    /**
     * 
     * @return
     *     The groupAllContacts
     */
    @JsonProperty("GroupAllContacts")
    public Boolean getGroupAllContacts() {
        return groupAllContacts;
    }

    /**
     * 
     * @param groupAllContacts
     *     The GroupAllContacts
     */
    @JsonProperty("GroupAllContacts")
    public void setGroupAllContacts(Boolean groupAllContacts) {
        this.groupAllContacts = groupAllContacts;
    }

    /**
     * 
     * @return
     *     The gridColumns
     */
    @JsonProperty("GridColumns")
    public List<GridColumn> getGridColumns() {
        return gridColumns;
    }

    /**
     * 
     * @param gridColumns
     *     The GridColumns
     */
    @JsonProperty("GridColumns")
    public void setGridColumns(List<GridColumn> gridColumns) {
        this.gridColumns = gridColumns;
    }

    /**
     * 
     * @return
     *     The sectionSourceColumnID
     */
    @JsonProperty("SectionSourceColumnID")
    public Object getSectionSourceColumnID() {
        return sectionSourceColumnID;
    }

    /**
     * 
     * @param sectionSourceColumnID
     *     The SectionSourceColumnID
     */
    @JsonProperty("SectionSourceColumnID")
    public void setSectionSourceColumnID(Object sectionSourceColumnID) {
        this.sectionSourceColumnID = sectionSourceColumnID;
    }

    /**
     * 
     * @return
     *     The headerImageColumnID
     */
    @JsonProperty("HeaderImageColumnID")
    public Object getHeaderImageColumnID() {
        return headerImageColumnID;
    }

    /**
     * 
     * @param headerImageColumnID
     *     The HeaderImageColumnID
     */
    @JsonProperty("HeaderImageColumnID")
    public void setHeaderImageColumnID(Object headerImageColumnID) {
        this.headerImageColumnID = headerImageColumnID;
    }

    /**
     * 
     * @return
     *     The headerImageSource
     */
    @JsonProperty("HeaderImageSource")
    public Object getHeaderImageSource() {
        return headerImageSource;
    }

    /**
     * 
     * @param headerImageSource
     *     The HeaderImageSource
     */
    @JsonProperty("HeaderImageSource")
    public void setHeaderImageSource(Object headerImageSource) {
        this.headerImageSource = headerImageSource;
    }

    /**
     * 
     * @return
     *     The firstLayerCardName
     */
    @JsonProperty("FirstLayerCardName")
    public Object getFirstLayerCardName() {
        return firstLayerCardName;
    }

    /**
     * 
     * @param firstLayerCardName
     *     The FirstLayerCardName
     */
    @JsonProperty("FirstLayerCardName")
    public void setFirstLayerCardName(Object firstLayerCardName) {
        this.firstLayerCardName = firstLayerCardName;
    }

    /**
     * 
     * @return
     *     The secondLayerCardName
     */
    @JsonProperty("SecondLayerCardName")
    public Object getSecondLayerCardName() {
        return secondLayerCardName;
    }

    /**
     * 
     * @param secondLayerCardName
     *     The SecondLayerCardName
     */
    @JsonProperty("SecondLayerCardName")
    public void setSecondLayerCardName(Object secondLayerCardName) {
        this.secondLayerCardName = secondLayerCardName;
    }

    /**
     * 
     * @return
     *     The cardMappings
     */
    @JsonProperty("CardMappings")
    public Object getCardMappings() {
        return cardMappings;
    }

    /**
     * 
     * @param cardMappings
     *     The CardMappings
     */
    @JsonProperty("CardMappings")
    public void setCardMappings(Object cardMappings) {
        this.cardMappings = cardMappings;
    }

    /**
     * 
     * @return
     *     The layoutsUpdateID
     */
    @JsonProperty("LayoutsUpdateID")
    public Object getLayoutsUpdateID() {
        return layoutsUpdateID;
    }

    /**
     * 
     * @param layoutsUpdateID
     *     The LayoutsUpdateID
     */
    @JsonProperty("LayoutsUpdateID")
    public void setLayoutsUpdateID(Object layoutsUpdateID) {
        this.layoutsUpdateID = layoutsUpdateID;
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
     *     The type
     */
    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The Type
     */
    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The actions
     */
    @JsonProperty("Actions")
    public List<Action> getActions() {
        return actions;
    }

    /**
     *
     * @param actions
     *     The Actions
     */
    @JsonProperty("Actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * 
     * @return
     *     The templateTitle
     */
    @JsonProperty("TemplateTitle")
    public String getTemplateTitle() {
        return templateTitle;
    }

    /**
     * 
     * @param templateTitle
     *     The TemplateTitle
     */
    @JsonProperty("TemplateTitle")
    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
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
