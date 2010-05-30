package com.goai.sgf.element;

/**
 *
 * @author dawid.malan
 */
public class StringElement implements SGFElement{

    private String value;

    public StringElement(String str){
        this.value = str;
    }
    
    @Override
    public String getTextValue() {
        return value;
    }

    @Override
    public boolean contains(String text) {
        return value.equals(text);
    }

}
