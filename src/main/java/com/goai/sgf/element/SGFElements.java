package com.goai.sgf.element;

import com.goai.sgf.element.property.Property;
import com.goai.sgf.element.property.PropertyValue;
import com.goai.sgf.element.property.PropertyValueType;

/**
 *
 * @author dawid.malan
 */
public class SGFElements {

    public static Constant getConstant(Character c) {
        for (Constant constant : Constant.values()) {
            if (constant.contains(String.valueOf(c))) {
                return constant;
            }
        }
        return Constant.NONE;
    }

    public static Property getProperty(String str) {
        for (Property property : Property.values()) {
            if (property.contains(str)) {
                return property;
            }
        }
        return Property.UNKNOWN;
    }

    public static PropertyValue getPropertyValue(String str) {
        return new PropertyValue(str, PropertyValue.PropertyType.NONE, getValueType(str));
    }

    public static PropertyValueType getValueType(String str) {
        for (PropertyValueType valueType : PropertyValueType.values()) {
            if (valueType.contains(str)) {
                return valueType;
            }
        }
        throw new RuntimeException("Could not get PropertyValueType");
    }
}
