package JavaCollectionFrameWork;

import java.util.LinkedList;
import java.util.*;

public class QueueLearn {
    public static void main(String[] args) {
        //Queue Implementation
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(12);
//        q.offer(34);
//        q.offer(43);
//        q.offer(67);
//
//        System.out.println(q.peek());
////        System.out.println(q);
//        while(!q.isEmpty()){
//            System.out.println(q.poll());
//        }
//        System.out.println(q.poll());
//        System.out.println(q.remove());


        //Dequeue Implementation
//        ArrayDeque<Integer> dq = new ArrayDeque<>();
//        dq.offer(12);
//        dq.offerFirst(21);
//        dq.offerLast(33);
//        System.out.println(dq);
//        System.out.println(dq.poll());
//        System.out.println(dq.pollFirst());
//        System.out.println(dq.pollLast());
//
//        ArrayList<Integer> AL1 = new ArrayList<>();
//        Stack<Integer> St1 = new Stack<>();
//        LinkedList<Integer> LL1 = new LinkedList<>();
//        Queue<Integer> q1 = new LinkedList<>();
//        ArrayDeque<Integer> Ad1 = new ArrayDeque<>();
//        Queue<Integer> PQ = new PriorityQueue<>();

        //Stack and Queue from ArrayDequeue
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        System.out.println(stack);
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        queue.offer(10);
//        queue.offer(20);
//        queue.offer(30);
//        queue.offer(40);
//        System.out.println(queue);
//
//        while (!queue.isEmpty()){
//            System.out.println(queue.poll());
//        }

        //Priority Queue
        Queue<Integer> PQ = new PriorityQueue<>();
        PQ.add(10);
        PQ.add(30);
        PQ.add(20);
        PQ.add(90);
        PQ.add(50);
        System.out.println(PQ);
        System.out.println(PQ.poll());
        System.out.println(PQ);
        System.out.println(PQ.poll());
        System.out.println(PQ);
    }
}
