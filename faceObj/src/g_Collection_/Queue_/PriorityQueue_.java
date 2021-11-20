package g_Collection_.Queue_;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue_ {
    public static void main(String[] args) {
        {
            Queue<String> q = new LinkedList<>();//!!!!!!!!!!!!!!!!!!
            // 添加3个元素到队列:
            q.offer("apple");
            q.offer("pear");
            q.offer("banana");
            // 从队列取出元素:
            System.out.println(q.poll()); // apple
            System.out.println(q.poll()); // pear
            System.out.println(q.poll()); // banana
            System.out.println(q.poll()); // null,因为队列是空
        }
        System.out.println("---------------------------------------");
        {
            /*因此，放入PriorityQueue的元素，必须实现Comparable接口，
            PriorityQueue会根据元素的排序顺序决定出队的优先级。 */
            Queue<String> q = new PriorityQueue<>();
            // 添加3个元素到队列:
            q.offer("apple");
            q.offer("pear");
            q.offer("banana");
            System.out.println(q.poll()); // apple
            System.out.println(q.poll()); // banana
            System.out.println(q.poll()); // pear
            System.out.println(q.poll()); // null,因为队列为空
        }
    }

}
