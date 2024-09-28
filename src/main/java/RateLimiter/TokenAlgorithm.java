package RateLimiter;

import java.time.Duration;

public class TokenAlgorithm {
    static class TokenBucket {
        private int tokens;
        private int capacity;
        private long timer = 1000;

        public TokenBucket(int capacity, int refillSize) {
            this.tokens = capacity;
            this.capacity = capacity;
            refillTokens(refillSize);
        }

        private void refillTokens(int refillSize) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(timer);
                        addTokens(refillSize);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        private void addTokens(int refillSize) {
            tokens = Math.min(tokens + refillSize, capacity);
        }

        public boolean remove() {
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
    }
}
