package l03_BasicTree_BinaryTree;

import java.util.*;
import java.util.function.Consumer;

public class BasicTree<T> {

    private T value;
    private BasicTree<T> parent;
    private List<BasicTree<T>> children;

    public BasicTree(T value, BasicTree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>();
        this.children.addAll(Arrays.asList(children));
    }

    public void addChild(BasicTree<T> child) {
        this.children.add(child);
        child.setParent(this);
    }

    public String print(int indent, StringBuilder builder) {
        builder.append(new String(new char[indent * 2]).replace("\0", " "))
                .append(this.value)
                .append("\n");
        for (BasicTree<T> child : this.children) {
            child.print(indent + 1, builder);
        }
        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.value);
        for (BasicTree<T> child : this.children) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> output = new ArrayList<>();
        this.DFS(output);
        return output;
    }

    private void DFS(List<T> output){
        for (BasicTree<T> child : this.children) {
            child.DFS(output);
        }
        output.add(this.value);
    }

    public Iterable<T> orderBFS() {
        Deque<BasicTree<T>> queue = new ArrayDeque<>();
        List<T> output = new ArrayList<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            BasicTree<T> current = queue.poll();
            for (BasicTree<T> child : current.children) {
                queue.offer(child);
            }
            output.add(current.value);
        }
        return output;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<BasicTree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<BasicTree<T>> children) {
        this.children = children;
    }

    public BasicTree<T> getParent() {
        return parent;
    }

    public void setParent(BasicTree<T> parent) {
        this.parent = parent;
    }
}
