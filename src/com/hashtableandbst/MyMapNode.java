package com.hashtableandbst;

public class MyMapNode {

    int data;
    String key;
    MyMapNode next;
    MyMapNode(String key, int data)
    {
        this.key = key;
        this.data = data;
        this.next = null;
    }
}
