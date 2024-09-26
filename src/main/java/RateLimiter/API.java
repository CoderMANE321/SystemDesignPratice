package RateLimiter;

public class API {
    private String request;
    private String response;
    private boolean GoodRequest;  // Changed to boolean
    private boolean BadRequest;   // Changed to boolean

    // Private constructor
    private API(APIBuilder builder) {
        this.request = builder.request;
        this.response = builder.response;
        this.GoodRequest = builder.GoodRequest;
        this.BadRequest = builder.BadRequest;
    }

    // Getters
    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public boolean isGoodRequest() { // Changed to `isGoodRequest`
        return GoodRequest;
    }

    public boolean isBadRequest() {  // Changed to `isBadRequest`
        return BadRequest;
    }

    @Override
    public String toString() {
        return "API [Request: " + request + ", Response: " + response + "]";
    }

    // Builder class
    public static class APIBuilder {
        private String request;
        private String response;
        private boolean GoodRequest;  // Changed to boolean
        private boolean BadRequest;   // Changed to boolean

        // Constructor for required fields
        public APIBuilder(String request, String response) {
            this.request = request;
            this.response = response;
        }

        // Setter for GoodRequest
        public APIBuilder setGoodRequest(boolean GoodRequest) {
            this.GoodRequest = GoodRequest;
            return this;
        }

        // Setter for BadRequest
        public APIBuilder setBadRequest(boolean BadRequest) {
            this.BadRequest = BadRequest;
            return this;
        }

        // Build method
        public API build() {
            return new API(this);
        }
    }
}

/*
* public class Main {
    public static void main(String[] args) {
        // Build an API with only required parameters (no optional features)
        API basicAPI = new API.APIBuilder("GET", "200 OK").build();

        // Build an API with both required and optional parameters
        API fullAPI = new API.APIBuilder("POST", "400 Bad Request")
                            .setGoodRequest(false)
                            .setBadRequest(true)
                            .build();

        // Display the APIs
        System.out.println(basicAPI);
        System.out.println(fullAPI);
    }
}
*/
