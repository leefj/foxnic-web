package org.github.foxnic.web.domain.dataperm;

public class PropertyItem {

    private Class type;
    private String property;
    private String fullProperty;
    private String table;
    private String field;
    private String label;
    private String fullLabel;
    private PropertyItem parent;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFullProperty() {
        return fullProperty;
    }

    public void setFullProperty(String fullProperty) {
        this.fullProperty = fullProperty;
    }

    public PropertyItem getParent() {
        return parent;
    }

    public void setParent(PropertyItem parent) {
        this.parent = parent;
    }

    public String getFullLabel() {
        return fullLabel;
    }

    public void setFullLabel(String fullLabel) {
        this.fullLabel = fullLabel;
    }


}
