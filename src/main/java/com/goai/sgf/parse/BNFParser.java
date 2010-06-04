package com.goai.sgf.parse;

import com.goai.sgf.ebnf.GameTree;
import com.goai.sgf.ebnf.GameTreeCollection;
import com.goai.sgf.ebnf.Node;
import com.goai.sgf.ebnf.SGFProperty;
import com.goai.sgf.ebnf.Sequence;
import com.goai.sgf.element.SGFElement;
import com.goai.sgf.element.property.Property;
import com.goai.sgf.element.property.PropertyValue;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import static com.goai.sgf.element.Constant.*;
import static com.goai.sgf.element.property.Property.*;
import java.util.List;

/**
 *
 * @author dawid.malan
 */
public class BNFParser {

    private int index = 0;
    private List<SGFElement> elements;

    private LinkedList<SGFElement> stack;

    public BNFParser(List<SGFElement> elements) {
        this.elements = elements;
        this.index = 0;
        this.stack = Lists.newLinkedList();
    }

    public GameTreeCollection parse() {
        List<GameTree> gametrees = Lists.newArrayList();

        for (; index < elements.size(); index++) {

            SGFElement element = elements.get(index);
            System.out.println("IN PARSE "+element);
            if (element == BRANCH_START) {
                gametrees.add(parseGametree());
            }
         
        }
        return new GameTreeCollection(gametrees);
    }

    GameTree parseGametree() {
        Preconditions.checkArgument(elements.get(index) == BRANCH_START, "Fix your sgf, dumbass");
        stack.push(elements.get(index));
        index++;

        List<Node> nodes = Lists.newArrayList();
        List<GameTree> gametrees = Lists.newArrayList();


        while(stack.size() != 0) {
           
            SGFElement element = elements.get(index);

            if (element == NODE_START) {
                nodes.add(parseNode());
            } else if (element == BRANCH_START) {
                gametrees.add(parseGametree());
            }
            else if(element == BRANCH_END){
                stack.pop();
            }
            index++;
        }
        index--;
        return new GameTree(new Sequence(nodes), gametrees);
    }

    Node parseNode() {
        Preconditions.checkArgument(elements.get(index) == NODE_START);
        
        SGFElement element = elements.get(++index);
        List<SGFProperty> values = Lists.newArrayList();

        while (element instanceof Property) {
            Property property = (Property) element;
            Preconditions.checkArgument(PROP_START == elements.get(++index), "Expected [ after property declaration");
            
            Preconditions.checkArgument(elements.get(index+1) instanceof PropertyValue, "Expected a Property Value but got %s",elements.get(index+1));
            PropertyValue value = (PropertyValue) elements.get(++index);
            Preconditions.checkArgument(PROP_END == elements.get(++index), "Expected ] after property value");

            if(property != UNKNOWN)
                values.add(new SGFProperty(property, value));
            element = elements.get(++index);
        }
        index--;
        return new Node(values);
    }
}
