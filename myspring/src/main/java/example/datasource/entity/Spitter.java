package example.datasource.entity;

import java.io.Serializable;

public class Spitter implements Serializable {

    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Spitter(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
