package com.goai.sgf.ebnf;

import com.goai.sgf.element.property.PropertyValue;
import com.goai.sgf.element.property.PropertyValueType;
import static com.goai.sgf.element.property.Property.*;
import com.google.common.collect.Lists;
import junit.framework.Assert;

import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class TestNode {

    @Test
    public void testToSGF(){
        Node node = new Node(Lists.newArrayList(new SGFProperty(WHITE, new PropertyValue("aa", PropertyValue.PropertyType.MOVE, PropertyValueType.POINT))));

        Assert.assertEquals(";W[aa]",node.toSgf());
    }
}
