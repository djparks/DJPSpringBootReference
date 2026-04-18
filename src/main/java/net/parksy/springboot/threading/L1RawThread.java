package net.parksy.springboot.threading;

import java.util.concurrent.TimeUnit;
/*
Level 1: Raw Threads (Java 1.0)
 */
public class L1RawThread {
    public static void main(String[] args) {
        // The ancient way
//        Problem: No way to return a value. No composition. Manual thread management.
        Thread thread = new Thread(() -> {
            //User user = database.fetchUser(userId);
//            System.out.println(user);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done");
        });
        thread.start();
// How do I get the result back?
    }
}
