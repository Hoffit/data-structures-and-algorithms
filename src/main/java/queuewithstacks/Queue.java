package queuewithstacks;

public interface Queue {

    void enqueue(String aValue);

    String peek();

    String dequeue();
}
