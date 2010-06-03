package com.goai.sgf.tree;

import com.goai.sgf.element.property.Property;
import com.goai.sgf.element.property.PropertyValue;
import java.util.Map;

/**
 * 
 * @author dawid.malan
 */
public class DefaultItem implements SGFItem{

    private final Map<Property, PropertyValue> properties;

    public DefaultItem(Map<Property, PropertyValue> properties) {
        this.properties = properties;
    }
    
    @Override
    public Map<Property, PropertyValue> getProperties() {
       return properties;
    }

    @Override
    public PropertyValue getPropertyValue(Property property) {
        return properties.get(property);
    }

}
