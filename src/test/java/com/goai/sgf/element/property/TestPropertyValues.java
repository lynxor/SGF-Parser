package com.goai.sgf.element.property;

import com.goai.sgf.element.SGFElements;
import static com.goai.sgf.element.property.PropertyValueType.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class TestPropertyValues {

    @Test
    public void test(){
        Assert.assertEquals(POINT,SGFElements.getPropertyValue("bb").getValueType());
        Assert.assertEquals(COLOUR,SGFElements.getPropertyValue("B").getValueType());
        Assert.assertEquals(COLOUR,SGFElements.getPropertyValue("W").getValueType());
        Assert.assertEquals(SIMPLETEXT,SGFElements.getPropertyValue("hoy chommas").getValueType());
        Assert.assertEquals(COMPOSE,SGFElements.getPropertyValue("aa:bb").getValueType());
        Assert.assertEquals(DIGIT,SGFElements.getPropertyValue("3").getValueType());
         Assert.assertEquals(NUMBER,SGFElements.getPropertyValue("-3").getValueType());
          Assert.assertEquals(REAL,SGFElements.getPropertyValue("-3.4").getValueType());
    }
}
