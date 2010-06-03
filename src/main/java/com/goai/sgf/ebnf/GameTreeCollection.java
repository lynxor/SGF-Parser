package com.goai.sgf.ebnf;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

/**
 * Is class even necessary? We'll see
 * @author dawid.malan
 */
public class GameTreeCollection implements EBNFNode,Iterable<GameTree>{
    private final List<GameTree> gametrees;

    public GameTreeCollection(List<GameTree> gametrees) {
        Preconditions.checkArgument(gametrees.size() != 0,"Collections consist of at least one game tree");
        this.gametrees = gametrees;
    }

    public List<GameTree> getGametrees() {
        return gametrees;
    }

    @Override
    public String toSgf() {
        return Joiner.on("").join(gametrees);
    }

    @Override
    public String toString(){
        return toSgf();
    }
    
    @Override
    public Iterator<GameTree> iterator() {
        return gametrees.iterator();
    }
}
