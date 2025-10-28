package com.tnsif.Day16;

import java.util.ArrayList;

class ArrayListThreadExample$NumberConsumer implements Runnable {
   private final ArrayList<Integer> numbers;

   public ArrayListThreadExample$NumberConsumer(ArrayList<Integer> numbers2) {
      this.numbers = numbers2;
   }

   public void run() {
      while(true) {
         if (!this.numbers.isEmpty()) {
            int number = (Integer)this.numbers.remove(0);
            System.out.println("Consumed: " + number);
         }
      }
   }
}
