package com.goai.sgf.parse;

import com.goai.sgf.ebnf.GameTreeCollection;
import com.goai.sgf.element.SGFElement;
import com.google.common.base.Joiner;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class SGFParser {

    public static GameTreeCollection parse(InputStream is) throws IOException{

        String str = Joiner.on("").join(CharStreams.readLines(new InputStreamReader(is)));
        List<SGFElement> elements = SyntaxParser.parse(str);

        BNFParser parser = new BNFParser(elements);
        return parser.parse();
    }
}
