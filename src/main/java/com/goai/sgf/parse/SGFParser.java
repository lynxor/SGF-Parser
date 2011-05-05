package com.goai.sgf.parse;

import com.goai.sgf.ebnf.GameTreeCollection;
import com.goai.sgf.element.SGFElement;
import com.google.common.base.Joiner;
import com.google.common.io.CharStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class SGFParser {
    /**
     * Convenience method for files
     * @param file sgf file to be parsed
     * @return see parse(InputStream)
     * @throws IOException
     */
    public static GameTreeCollection parse(File file) throws IOException{
        return SGFParser.parse(new FileInputStream(file));
    }
    /**
     * Parse an sgf from an input stream
     * @param is
     * @return A GameTreeCollection containing 1 or more gametrees 
     * @throws IOException
     */
    public static GameTreeCollection parse(InputStream is) throws IOException{

        String str = Joiner.on("").join(CharStreams.readLines(new InputStreamReader(is)));
        List<SGFElement> elements = SyntaxParser.parse(str);
        BNFParser parser = new BNFParser(elements);
        return parser.parse();
    }
}
