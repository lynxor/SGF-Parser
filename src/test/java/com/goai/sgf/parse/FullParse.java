
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
         System.out.println(collection);
      // Assert.assertEquals(20, collection.getGametrees().size());

    }
}
