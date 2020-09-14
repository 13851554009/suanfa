package com.example.demo.list;

import lombok.Data;

@Data
public class Node {
//    private Node pre;
    private Node next;
    private Object value;

    public Node(){};
    public Node(Node next, Object value) {
        this.next = next;
        this.value = value;
    }
}
