package RateLimiter;

public class Gateway {
    TokenAlgorithm.TokenBucket tokenBucket = new TokenAlgorithm.TokenBucket(10, 1);
    //handles clients using algorithm
    public void handleRequest(String request) {
        if (tokenBucket.remove()) {
            API api = new API.APIBuilder(request, "200 OK").setGoodRequest(true).build();
            System.out.println(api.getResponse());
        } else {
            API api = new API.APIBuilder(request, "429 Too Many Requests").setBadRequest(true).build();
            System.out.println(api.getResponse());
        }
    }
}
