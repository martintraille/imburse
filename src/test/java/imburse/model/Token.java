package imburse.model;

public class Token {

    String accessToken;
    String expires;

    public Token(String accessToken, String expires) {
        this.accessToken = accessToken;
        this.expires = expires;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public String getExpires() {
        return expires;
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

}
