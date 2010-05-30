package com.goai.sgf.parse;

import com.goai.sgf.element.SGFElement;
import com.google.common.base.Joiner;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
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
 
        SyntaxParser parser = new SyntaxParser(sgfstring);
        List<SGFElement> elements = parser.parse();

        System.out.println(elements);
    }
}
