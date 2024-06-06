package queue;

public class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;
    private int[] queueArray;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
        nItems++;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }
    public boolean isFull() {
        return (nItems == maxSize);
    }
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int tempFront = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queueArray[tempFront] + " ");
            tempFront++;
            if (tempFront == maxSize) {
                tempFront = 0;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        // Test enqueue operation
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue();

        queue.enqueue(60);
        System.out.println("Front element is: " + queue.peek());
        System.out.println("Dequeued element is: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Dequeued element is: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Front element is: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element is: " + queue.dequeue());
        }

        System.out.println("Dequeued element is: " + queue.dequeue());
        System.out.println("Front element is: " + queue.peek());
    }
}