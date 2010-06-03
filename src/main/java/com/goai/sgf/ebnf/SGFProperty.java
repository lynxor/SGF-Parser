package com.goai.sgf.ebnf;

import com.goai.sgf.element.property.Property;
import com.goai.sgf.element.property.PropertyValue;
import static com.goai.sgf.element.Constant.*;

/**
 *
 * @author dawid.malan
 */
public class SGFProperty implements EBNFNode{
    private final Property property;
    private final PropertyValue value;

    public SGFProperty(Property property, PropertyValue value) {
        this.property = property;
        this.value = value;
    }

    public Property getProperty() {
        return property;
    }

    public PropertyValue getValue() {
        return value;
    }

    @Override
    public String toString() {
      return toSgf();
    }

    @Override
    public String toSgf() {
         return new StringBuilder().append(property.getTextValue())
                .append(PROP_START)
                .append(value.getTextValue())
                .append(PROP_END).toString();
    }


}
