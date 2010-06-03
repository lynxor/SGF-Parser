package com.goai.sgf.parse;

import com.goai.sgf.element.Constant;
import com.goai.sgf.element.SGFElement;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

import static com.goai.sgf.element.Constant.*;
import static com.goai.sgf.element.property.Property.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class TestParseSyntax {

    @Test
    public void testParse() throws IOException{
        InputStream is = TestParseSyntax.class.getResourceAsStream("/com/goai/sgf/parse/test.sgf");

        String sgfstring = Joiner.on("").join(CharStreams.readLines(new InputStreamReader(is)));


        List<SGFElement> elements = SyntaxParser.parse(sgfstring);
        System.out.println(elements);
        Assert.assertEquals(BRANCH_START, elements.get(0));
        Assert.assertEquals(BRANCH_END, elements.get(elements.size()-1));
    }

    @Test
    public void testEmptyProperty(){
       List<SGFElement> elements = Lists.newArrayList();
        SyntaxParser.handleCache(elements, Lists.<Character>newArrayList(), Constant.PROP_START);
        Assert.assertEquals(1, elements.size());
        System.out.println(elements);

    }

}
