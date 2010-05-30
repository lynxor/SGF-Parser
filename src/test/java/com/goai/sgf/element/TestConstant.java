package com.goai.sgf.element;

import org.junit.Assert;
import org.junit.Test;

import static com.goai.sgf.element.Constant.*;
/**
 *
 * @author dawid.malan
 */
public class TestConstant {
    
    @Test
    public void testParse(){
        Assert.assertTrue(SGFElements.getConstant('\t') == TAB);
        Assert.assertTrue(SGFElements.getConstant(' ') == SPACE);
        Assert.assertTrue(SGFElements.getConstant(')') == BRANCH_END);
        Assert.assertTrue(SGFElements.getConstant('(') == BRANCH_START);
        Assert.assertTrue(SGFElements.getConstant('\\') == ESCAPE);
        Assert.assertTrue(SGFElements.getConstant(';') == NODE_START);
        Assert.assertTrue(SGFElements.getConstant('[') == PROP_START);
        Assert.assertTrue(SGFElements.getConstant(']') == PROP_END);
        Assert.assertTrue(SGFElements.getConstant('+') == NONE);

    }
}
