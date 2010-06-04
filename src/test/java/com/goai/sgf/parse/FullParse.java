
package com.goai.sgf.parse;

import com.goai.sgf.ebnf.GameTreeCollection;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dawid.malan
 */
public class FullParse {
    @Test
    public void testPlainGame() throws IOException{
       InputStream is = FullParse.class.getResourceAsStream("masao_koichi.sgf");
       GameTreeCollection collection = SGFParser.parse(is);
       Assert.assertEquals(1, collection.getGametrees().size());
    }

     @Test
    public void testCollection() throws IOException{
       InputStream is = FullParse.class.getResourceAsStream("judan_collection.sgf");
       GameTreeCollection collection =  SGFParser.parse(is);

       Assert.assertEquals(30, collection.getGametrees().size());

    }
    @Test
    public void testMultigame() throws IOException{
       InputStream is = FullParse.class.getResourceAsStream("multigame.sgf");
       GameTreeCollection collection =  SGFParser.parse(is);

       Assert.assertEquals(2, collection.getGametrees().size());

    }

}
