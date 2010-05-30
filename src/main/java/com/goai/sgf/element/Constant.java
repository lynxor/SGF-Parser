package com.goai.sgf.element;

/**
 *
 * @author dawid.malan
 */
public enum Constant implements SGFElement {

    SPACE(' '),
    TAB('\t'),
    ESCAPE('\\'),
    PROP_START('['),
    PROP_END(']'),
    BRANCH_START('('),
    BRANCH_END(')'),
    NODE_START(';'),
    NONE('*');
    
    private final Character match;

    private Constant(Character ch) {
        match = ch;
    }

    @Override
    public boolean contains(String item) {
        return String.valueOf(match).equals(item); 
    }

    /**
     *
     * @return First item in matches
     */
    @Override
    public String getTextValue() {
        return String.valueOf(match);
    }
}
