package net.parksy.springboot.threading;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

/**
 * Level 4: Async Programming with CompletableFuture
 * 
 * Sounds convenient, but… it has subtle pitfalls we’ll cover in Part 3. Spoiler: I recommend manual CompletableFuture over @Async in most cases.
 *
 * The Mental Model: Think “Promise”, Not “Thread”
 * If you’ve worked with JavaScript, CompletableFuture is Java's Promise. It represents a value that will be available in the future.
 *
 * CompletableFuture<User> = "I promise to give you a User... eventually."
 *
 * The key insight: you don’t wait for the promise to resolve. Instead, you tell it what to do when the value arrives:
 *
 * fetchUserAsync(userId)
 *     .thenApply(user -> user.getEmail())      // "When you have the user, extract email"
 *     .thenAccept(email -> log.info(email));   // "When you have the email, log it"
 *
 *  The thread that calls this code returns immediately. It doesn’t block. It doesn’t wait. It’s free to handle other requests.
 *
 */
public class L4Async {
    @Async
    public CompletableFuture<String> fetchUser(Long userId) {
        try {
            Thread.sleep(1000); // Simulate a slow response
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("User: " + userId);
    }
}
