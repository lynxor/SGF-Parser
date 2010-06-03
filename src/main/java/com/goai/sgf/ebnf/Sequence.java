package com.goai.sgf.ebnf;

import com.google.common.base.Joiner;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class Sequence implements EBNFNode,Iterable<Node> {
    private final List<Node> nodes;

    public Sequence(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }
    
    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }

    @Override
    public String toSgf() {
        return Joiner.on("").join(nodes);
    }
    @Override
    public String toString(){
        return toSgf();
    }

}
