package com.hashtableandbst;

public class HashTableOperation {
    MyMapNode head = null;
    MyMapNode tail = null;

    public void insert(String data, int count)
    {
        MyMapNode newNode = new MyMapNode(data, count);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }
    public void display()
    {
        MyMapNode current = head;
        if (head == null) {
            return;
        }
        else
        {
            while (current != null)
            {
                System.out.println(current.key + "=" + current.data);
                current = current.next;
            }
        }
    }

    public static void hashTableOperation(String sentence, HashTableOperation hashTable) {
        String[] string = sentence.toLowerCase().split(" ");// spliting words and store them in array

        int count = 1;
        for (int i = 0; i < string.length; i++) {

            for (int j = i + 1; j < string.length; j++)//checking element at index equals sentence
            {
                if (string[i].equals(string[j]) && string[i] != "-1")//  it is then increment
                {
                    string[j] = "-1";
                    count++;

                }
            }
            if (count > 0 && string[i] != "-1") { // print count string with repeating count
                System.out.println(string[i] + " : " + count);
                string[i] = "-1";
            }
            count = 1;
        }
        for (int i = 0; i < string.length; i++) {

            if ( string[i] != "-1"){
                hashTable.insert(string[i],count);
            }
        }
    }
    public static void main(String[] args) {
        HashTableOperation hashTable = new HashTableOperation();
        System.out.println("HashTable Operation");
        String string = "To be or not to be";
        hashTableOperation(string,hashTable);
        hashTable.display();
    }
}
