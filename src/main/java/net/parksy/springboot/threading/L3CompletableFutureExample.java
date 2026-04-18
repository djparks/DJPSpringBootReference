package net.parksy.springboot.threading;

import java.util.concurrent.CompletableFuture;

/*
Level 3: CompletableFuture (Java 8)
The breakthrough: Callbacks, composition, and non-blocking operations.

*/
public class L3CompletableFutureExample {

    public static void main(String[] args) {
//        CompletableFuture<User> future = CompletableFuture.supplyAsync(
//                () -> database.fetchUser(userId)
//        );
//
//        // Non-blocking transformation!
//        future.thenApply(user -> user.getEmail())
//                .thenAccept(email -> sendWelcomeEmail(email));

        // Demonstration without database calls:
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "User: John Doe";
        });

        // Non-blocking transformation!
        future.thenApply(user -> user.toUpperCase())
                .thenAccept(upperUser -> System.out.println("Result: " + upperUser));

        // Thread is FREE to do other work
        System.out.println("Main thread is free!");

        // Wait for the async task to complete in this simple example
        future.join();
    }
}
