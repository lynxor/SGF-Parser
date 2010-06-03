package com.goai.sgf.parse;

import com.goai.sgf.element.Constant;
import com.goai.sgf.element.SGFElement;
import static com.goai.sgf.element.Constant.*;
import com.goai.sgf.element.SGFElements;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class SyntaxParser {


    public static List<SGFElement> parse(String parseString) {
        List<SGFElement> list = Lists.newArrayList();
        List<Character> cache = Lists.newArrayList();
        Constant prevConstant = NONE;
        boolean escapeNext = false;

        for (Character c : parseString.toCharArray()) {

            if (escapeNext) {
                cache.add(c);
                escapeNext = false;
                continue;
            }
            //Constant
            Constant constant = SGFElements.getConstant(c);
            if (constant == ESCAPE) {
                escapeNext = true;
                continue;
            }
            if (constant != NONE && constant != SPACE) {
                handleCache(list, cache, prevConstant);
                list.add(constant);
                prevConstant = constant;
            } else {
                cache.add(c);
            }
        }
        return list;
    }

    static void handleCache(List<SGFElement> elements, List<Character> cache, Constant previous) {
        if(cache.size() != 0){
             String cacheString = Joiner.on("").join(cache);

            if(previous == PROP_START){
                elements.add(SGFElements.getPropertyValue(cacheString));
            }
            else {
                elements.add(SGFElements.getProperty(cacheString));
            }
            cache.clear();

        }
        else if(previous == PROP_START){
            elements.add(SGFElements.getPropertyValue("")); 
        }
           
    }
}
