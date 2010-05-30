package com.goai.sgf.element;

/**
 *
 * @author dawid.malan
 */
public interface SGFElement {
    public String getTextValue();
    public boolean contains(String text);
}
