package tree.data.structures;

import java.util.*;

public class BasicTree<E>{

    private E value;
    private BasicTree<E> parent;
    private List<BasicTree<E>> children;
    private Set<String> set = new HashSet<>();

    public BasicTree(E value, BasicTree<E>... children){
        this.value = value;
        this.children = new ArrayList<>();
        this.children.addAll(Arrays.asList(children));
    }

    public String print(int indent, StringBuilder builder) {
        builder.append(new String(new char[indent * 2]).replace("\0", " "))
                .append(this.value)
                .append("\n");
        //Using recursion
        for (BasicTree<E> child : this.children) {
            child.print(indent + 1, builder);
        }
        return builder.toString();
    }

    private void DFS(List<E> output){
        for (BasicTree<E> child : this.children) {
            child.DFS(output);
        }
        output.add(this.value);
    }

    public Iterable<E> orderDFS() {
        List<E> output = new ArrayList<>();
        this.DFS(output);
        return output;
    }

    public Iterable<E> orderBFS() {
        Queue<BasicTree<E>> queue = new ArrayDeque<>();
        List<E> result = new ArrayList<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            BasicTree<E> current = queue.poll();
            for (BasicTree<E> child : current.children) {
                queue.offer(child);
            }
            result.add(current.value);
        }
        return result;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BasicTree<E> getParent() {
        return parent;
    }

    public void setParent(BasicTree<E> parent) {
        this.parent = parent;
    }

    public List<BasicTree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<BasicTree<E>> children) {
        this.children = children;
    }
}
