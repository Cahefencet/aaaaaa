package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Node {
    private int id;
    private String name;
    private ArrayList<Node> children = new ArrayList<>();

    public Node(String name){
        this.name = name;
        this.id = -1;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getChildrenList() {
        return children;
    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Node findChildrenByName(String name, ArrayList<Node> children){
        for (Node child : children) {
            if (Objects.equals(child.getName(), name))
                return child;
            else findChildrenByName(child.getName(), child.children);
        }
        return null;
    }

    public void removeByName(String name, ArrayList<Node> children) {
        Node toRemove = findChildrenByName(name, children);
        if (toRemove == null) return;
        for (Node child : children) {
            if (child == toRemove) {
                children.remove(child);
                return;
            }
            removeByName(child.getName(), child.getChildrenList());
        }
    }

    private int getsize(Node node) {
        if (node.id == -1)
            return 1;
        int size = 1;
        for (Node child : node.getChildrenList()) {
            size = getsize(child);
        }
        return size;
    }

    private int lastId(Node node) {
        Node largest = null;
        int maxSize = 1;
        for (Node child : node.children){
            int size = getsize(child);
            if (size > maxSize) {
                maxSize = size;
                largest = child;
            }
        }
        if (largest == null) return -1;
        return largest.getId();
    }

    public void clear() {
        this.children.clear();
    }

    public void add(Node node){
        node.setId(lastId(node) + 1);
        this.children.add(node);
    }
}
