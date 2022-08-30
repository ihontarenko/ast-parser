package net.borisovich.json.ast;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractNode implements Node {

    protected final List<Node> children = new ArrayList<>();
    protected Node parent;

    public AbstractNode() {
        this(null);
    }

    public AbstractNode(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public boolean hasParent() {
        return this.parent != null;
    }

    @Override
    public Node parent() {
        return this.parent;
    }

    @Override
    public void parent(Node node) {
        this.parent = node;
    }

    @Override
    public Node[] children() {
        Node[] nodes = new Node[this.children.size()];

        return this.children.toArray(nodes);
    }

    @Override
    public boolean delete(Node node) {
        return this.children.remove(node);
    }

    @Override
    public void add(Node node) {
        if (this != node) {
            node.parent(this);
            this.children.add(node);
        }
    }

}