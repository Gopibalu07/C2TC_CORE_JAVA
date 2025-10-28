package com.tnsif.Day16;

import java.util.Vector;

class VectorThreadSafetyExample$NumberConsumer implements Runnable {
   private final Vector<Integer> numbers;

   public VectorThreadSafetyExample$NumberConsumer(Vector<Integer> numbers) {
      this.numbers = numbers;
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