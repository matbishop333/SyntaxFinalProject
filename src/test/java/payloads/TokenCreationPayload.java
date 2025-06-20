package payloads;

public class TokenCreationPayload {
    private String email;
    private String password;

    public TokenCreationPayload(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
