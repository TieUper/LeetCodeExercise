package com.leecode.exercise.queue;

import javax.print.attribute.standard.MediaSize;
import java.util.*;

public class QueueExercise {

    //PriorityQueue 优先队列，排序
    public static void main(String[] args) {
        insertQueue();
    }

    private static void insertQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(new Integer(random.nextInt(100)));
        }
        List<Integer> list = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            list.add(queue.poll());
        }
        System.out.println(list);

        Integer a = 3;
        Integer b = 4;

        List<Name> names = new ArrayList<>();
        names.add(new Name("张三", 20));
        names.add(new Name("李四", 21));
        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);

    }

   static class Name implements Comparable<Name>{

        private int age;

        private String name;

        public Name(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public Name(int age) {
            this.age = age;
        }


       @Override
       public int compareTo(Name o) {
           System.out.println("name o2：" + o.name + "  name o1:" + this.name);
           return o.age - this.age;
       }

       @Override
       public String toString() {
           return "Name{" +
                   "age=" + age +
                   ", name='" + name + '\'' +
                   '}';
       }
   }
}
