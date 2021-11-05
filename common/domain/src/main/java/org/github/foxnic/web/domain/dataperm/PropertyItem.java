package org.github.foxnic.web.domain.dataperm;

import java.lang.reflect.Field;

public class PropertyItem {

    private Class type;
    private String property;
    private String fullProperty;
    private String queryTable;
    private String queryField;
    private String label;
    private String fullLabel;
    private Field field;
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

    public String getQueryTable() {
        return queryTable;
    }

    public void setQueryTable(String queryTable) {
        this.queryTable = queryTable;
    }

    public String getQueryField() {
        return queryField;
    }

    public void setQueryField(String queryField) {
        this.queryField = queryField;
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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}
