public class CyclicQueueTest {
    public static void main(String[] args) {
        MyQueueImpl<String> queue1 = new MyQueueImpl<>(4);
        queue1.enqueue("ala");
        queue1.enqueue("ma");

        System.out.println(queue1.first() + "\n");
        queue1.enqueue("kota");
        queue1.enqueue("szarego");
        System.out.println("isFull: " + queue1.isFull()  + "\n");

        try {
            queue1.enqueue("Ooops");
        } catch (Exception e){
            e.printStackTrace();
        }

        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        System.out.println("isEmpty: " +queue1.isEmpty() + "\n");
        try {
            queue1.first();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
