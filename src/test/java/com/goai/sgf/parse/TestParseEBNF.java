package com.goai.sgf.parse;

import com.goai.sgf.ebnf.GameTree;
import com.goai.sgf.ebnf.Node;
import com.goai.sgf.element.SGFElement;
import com.goai.sgf.element.property.PropertyValue;
import com.goai.sgf.element.property.PropertyValueType;
import com.google.common.collect.Lists;
import static com.goai.sgf.element.Constant.*;
import static com.goai.sgf.element.property.Property.*;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class TestParseEBNF {

    @Test
    public void testParseNode(){
        List<SGFElement> list = Lists.newArrayList(NODE_START,
                BLACK,
                PROP_START,
                new PropertyValue("bb", PropertyValue.PropertyType.MOVE, PropertyValueType.POINT),
                PROP_END,
                BRANCH_END);

        BNFParser parser = new BNFParser(list);
        Node node = parser.parseNode();

        Assert.assertEquals(BLACK, node.getProperties().get(0).getProperty());
        Assert.assertEquals("bb", node.getProperties().get(0).getValue().getTextValue());
    }

//    @Test
//    public void testParseGameTree(){
//        List<SGFElement> list = Lists.newArrayList(
//                BRANCH_START,
//                NODE_START,
//                BLACK,
//                PROP_START,
//                new PropertyValue("bb", PropertyValue.PropertyType.MOVE, PropertyValueType.POINT),
//                PROP_END,
//                BRANCH_END);
//
//        BNFParser parser = new BNFParser(list);
//        GameTree gt = parser.parseGametree();
//
//        Assert.assertEquals(BLACK,gt.getSequence().getNodes().get(0).getProperties().get(0).getProperty());
//    }
    

    
}
