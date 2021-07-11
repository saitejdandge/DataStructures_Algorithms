package servicenow.queue;


//(f)[1(), 2(),3(f,r), _ , _ , _ ](R)

//[f 1_ 2r, 3f, 4, 5(r)]

//1f, 2,3, 4 ,5(r)


// 6r,2,3f,4,5
public class Queue {

    private final int[] data;
    private int front;
    private int rear;

    public Queue() {
        front = rear = 0;
        data = new int[5];
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("pop" + queue.pop());
        queue.add(6);
        System.out.println("pop" + queue.pop());
        queue.add(7);

        queue.print();
    }

    public void print() {
        for (int k = front; k <= rear; k++) {
            System.out.println(data[k % data.length]);
        }
    }

    public void add(int value) {
        if ((rear + 1) % data.length != front % data.length) {

            data[rear % data.length] = value;
            rear += 1;
        }

    }

    public int pop() {
        if (front <= rear)
            return data[front++];
        else
            return -1;
    }


}
