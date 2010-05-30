package com.goai.sgf.element.property;

import com.goai.sgf.element.SGFElement;
import com.google.common.base.Objects;

/**
 *
 * @author dawid.malan
 */
public class PropertyValue implements SGFElement {

    public enum PropertyType {

        ROOT, MOVE, SETUP, GAME_INFO, NONE
    }
    private final String value;
    private final PropertyValueType valueType;
    private final PropertyType propertyType;

    public PropertyValue(String value, PropertyType propertyType, PropertyValueType valueType) {
        this.value = value;
        this.propertyType = propertyType;
        this.valueType = valueType;
    }

    @Override
    public String getTextValue() {
        return value;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public PropertyValueType getValueType() {
        return valueType;
    }

    @Override
    public boolean contains(String text) {
        return this.value.equals(text);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PropertyValue that = (PropertyValue) obj;
        return Objects.equal(this.value, that.value) && Objects.equal(this.valueType,that.valueType) && Objects.equal(this.propertyType, that.propertyType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value,valueType,propertyType);
    }

    @Override
    public String toString() {
        return propertyType +" -> "+valueType+" = "+value;
    }


}
