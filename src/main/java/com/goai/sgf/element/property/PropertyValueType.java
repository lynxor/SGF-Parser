package com.goai.sgf.element.property;

import java.util.regex.Pattern;

/**
 *
 * @author dawid.malan
 */
public enum PropertyValueType {

    COLOUR("[BW]"),
    DIGIT("\\d"),
    NONE(""),
    NUMBER("[+-]\\d"),
    REAL("[+-]\\d\\.\\d"),
    DOUBLE("[12]"),
    POINT("[a-zA-Z]{2}"),
    COMPOSE(POINT.regex + "\\:" + POINT.regex),
    SIMPLETEXT(".*"),
    TEXT(".*");
    
    private String regex;

    private PropertyValueType(String regex) {
        this.regex = regex;
    }

    public boolean contains(String text) {
        return Pattern.matches(regex, text);
    }

    public String getRegex() {
        return regex;
    }
}
