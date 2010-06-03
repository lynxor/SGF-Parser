package com.goai.sgf.ebnf;

import com.goai.sgf.element.property.PropertyValue;
import com.goai.sgf.element.property.PropertyValueType;
import static com.goai.sgf.element.property.Property.*;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class TestGameTree {

    @Test
    public void testToSGF(){
        Node node1 = new Node(Lists.newArrayList(new SGFProperty(WHITE, new PropertyValue("aa", PropertyValue.PropertyType.MOVE, PropertyValueType.POINT))));
        Node node2 = new Node(Lists.newArrayList(new SGFProperty(BLACK, new PropertyValue("bb", PropertyValue.PropertyType.MOVE, PropertyValueType.POINT))));
        GameTree gt = new GameTree(new Sequence(Lists.<Node>newArrayList(node1,node2)), Lists.<GameTree>newArrayList());

        Assert.assertEquals("(;W[aa];B[bb])",gt.toSgf());
    }
}
