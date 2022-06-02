public class Queue {
    private int front, rear, capacity;
    private int queue[];

    Queue(int c) {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    void queueEnqueue(int data) {
        if (capacity == rear) {
            System.out.println("Queue is full");
        }
        else {
            queue[rear++] = data;
        }
    }

    void queueDequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        }

        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            if (rear < capacity)
                queue[rear] = 0;

            rear--;
        }
    }

    // print queue elements
    void queueDisplay() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
    }

    // print front of queue
    void queueFront() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
    }

    // Driver code
    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}