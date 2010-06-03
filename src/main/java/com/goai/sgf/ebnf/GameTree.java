package com.goai.sgf.ebnf;

import com.google.common.base.Joiner;
import java.util.List;
import static com.goai.sgf.element.Constant.*;

/**
 *
 * @author dawid.malan
 */
public class GameTree implements EBNFNode{
    private final Sequence sequence;
    private final List<GameTree> gametrees;

    public GameTree(Sequence sequence, List<GameTree> gametrees) {
        this.sequence = sequence;
        this.gametrees = gametrees;
    }

    public List<GameTree> getGametrees() {
        return gametrees;
    }

    public Sequence getSequence() {
        return sequence;
    }

    @Override
    public String toSgf() {
        return new StringBuilder(BRANCH_START.toString())
                .append(sequence)
                .append(Joiner.on("")
                .join(gametrees))
                .append(BRANCH_END).toString();

    }

    @Override
    public String toString() {
        return toSgf();
    }
    
}
