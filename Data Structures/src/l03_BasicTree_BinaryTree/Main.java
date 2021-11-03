package l03_BasicTree_BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<Integer, BasicTree<Integer>> treeMap = new HashMap<>();
        BasicTree<Integer> tree = new BasicTree<>(0);

        for (int i = 0; i < n - 1; i++) {
            int[] intArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            treeMap.putIfAbsent(intArr[0], new BasicTree<>(intArr[0]));
            treeMap.putIfAbsent(intArr[1], new BasicTree<>(intArr[1]));
            treeMap.get(intArr[0]).addChild(treeMap.get(intArr[1]));
        }

        for (BasicTree<Integer> tr : treeMap.values()) {
            if (tr.getParent() == null) {
                tree = tr;
                break;
            }
        }


        //Problem 1
        System.out.println("Root node: " + tree.getValue());

        //Problem 2
        printTree(tree, 0);

        //Problem 3
        printLeafNodes(tree);
    }

    private static void printLeafNodes(BasicTree<Integer> tree) {
        TreeSet<Integer> values = new TreeSet<>();
        for (BasicTree<Integer> child : tree.getChildren()) {
            getLeafNodes(child, values);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Leaf nodes: ");
        for (Integer value : values) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }

    private static void getLeafNodes(BasicTree<Integer> child, TreeSet<Integer> values) {
        if (child.getChildren().isEmpty()) {
            values.add(child.getValue());
        } else {
            for (BasicTree<Integer> ch : child.getChildren()) {
                getLeafNodes(ch, values);
            }
        }
    }


    private static void printTree(BasicTree<Integer> tree, int padding) {
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println(tree.getValue());
        for (BasicTree<Integer> child : tree.getChildren()) {
            printTree(child, padding + 2);
        }
    }
}
