package RateLimiter;

public class API {
    private String request;
    private String response;
    private boolean goodRequest;
    private boolean badRequest;

    private API(APIBuilder builder) {
        this.request = builder.request;
        this.response = builder.response;
        this.goodRequest = builder.goodRequest;
        this.badRequest = builder.badRequest;
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public boolean isGoodRequest() {
        return goodRequest;
    }

    public boolean isBadRequest() {
        return badRequest;
    }
    //serves appropriate request
    public static class APIBuilder {
        private String request;
        private String response;
        private boolean goodRequest;
        private boolean badRequest;

        public APIBuilder(String request, String response) {
            this.request = request;
            this.response = response;
        }

        public APIBuilder setGoodRequest(boolean goodRequest) {
            this.goodRequest = goodRequest;
            return this;
        }

        public APIBuilder setBadRequest(boolean badRequest) {
            this.badRequest = badRequest;
            return this;
        }

        public API build() {
            return new API(this);
        }
    }
}
