package com.goai.sgf.element;

import junit.framework.Assert;
import org.junit.Test;

import static com.goai.sgf.element.property.Property.*;

/**
 *
 * @author dawid.malan
 */
public class TestProperty {

    @Test
    public void testParse() {
        Assert.assertTrue(SGFElements.getProperty("B") == BLACK);
        Assert.assertTrue(SGFElements.getProperty("W") == WHITE);
        Assert.assertTrue(SGFElements.getProperty("AW") == ADD_W);
        Assert.assertTrue(SGFElements.getProperty("AB") == ADD_B);
        Assert.assertTrue(SGFElements.getProperty("C") == COMMENT);
        
         Assert.assertTrue(SGFElements.getProperty("Gogga") == UNKNOWN);


    }
}
