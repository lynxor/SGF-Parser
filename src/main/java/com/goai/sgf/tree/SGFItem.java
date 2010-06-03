package com.goai.sgf.tree;

import com.goai.sgf.element.property.Property;
import com.goai.sgf.element.property.PropertyValue;
import java.util.Map;

/**
 *
 * @author dawid.malan
 */
public interface SGFItem{

    public Map<Property,PropertyValue> getProperties();
    public PropertyValue getPropertyValue(Property property);

    
}
