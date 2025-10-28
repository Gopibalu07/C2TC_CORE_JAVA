package com.tnsif.Day16;

import java.util.Vector;

class VectorThreadSafetyExample$NumberProducer implements Runnable {
   private final Vector<Integer> numbers;

   public VectorThreadSafetyExample$NumberProducer(Vector<Integer> numbers) {
      this.numbers = numbers;
   }

   public void run() {
      for(int i = 1; i <= 5; ++i) {
         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var3) {
            var3.printStackTrace();
         }

         this.numbers.add(i);
         System.out.println("Produced: " + i);
      }

   }
}
