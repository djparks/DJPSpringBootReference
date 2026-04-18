package net.parksy.springboot.threading;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
Level 2: ExecutorService + Future (Java 5)
 */
@Slf4j
public class L2ExecServFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // Future<User> future = executor.submit(() -> database.fetchUser(userId));
        Future<String> future = executor.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(200);
            return "Task completed";
        });

        // To get the result, you MUST block:
        // User user = future.get(); // Blocks until done
        try {
            String result = future.get(); // Blocks until done
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        } finally {
            executor.shutdown();
        }
    }
}
