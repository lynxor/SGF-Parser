package com.goai.sgf.element.property;

import com.goai.sgf.element.SGFElement;

/**
 *
 * @author dawid.malan
 */
public enum Property implements SGFElement{
    PLAYER("PL"),
    MOVE_NUMBER("MN"),
    FORCE_MOVE("KO"),
    SIZE("SZ"),
    CREATED_BY("AP"),
    GAME("GM"),
    BLACK_RANK("BR"),
    WHITE_RANK("WR"),
    DATE("DT"),
    RESULT("RE"),
    PLAYER_BLACK("PB"),
    PLAYER_WHITE("PW"),
    ROOTNODE("FF"), //File Format?
    BLACK("B"),
    WHITE("W"),
    ADD_B("AB"),
    ADD_W("AW"),
    COMMENT("C"),
    UNKNOWN("UNKNOWN");

     private final String match;

    private Property(String str) {
        match = str;
    }

    @Override
    public boolean contains(String item) {
        return match.equals(item);
    }

    @Override
    public String getTextValue() {
        return match;
    }
}
