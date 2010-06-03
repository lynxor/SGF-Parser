package com.goai.sgf.ebnf;

import com.google.common.base.Joiner;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class Node implements EBNFNode,Iterable<SGFProperty>{
    private final List<SGFProperty> properties;

    public Node(List<SGFProperty> properties) {
        this.properties = properties;
    }

    public List<SGFProperty> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return toSgf();
    }

    @Override
    public Iterator<SGFProperty> iterator() {
        return properties.iterator();
    }

    @Override
    public String toSgf() {
       return new StringBuilder(";").append(Joiner.on("").join(properties)).toString();
    }
}
