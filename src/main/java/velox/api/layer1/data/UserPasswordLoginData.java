package velox.api.layer1.data;

import java.io.Serializable;

public class UserPasswordLoginData implements Serializable {
    public final String user;
    public final String password;
    public final String newPassword;

    public UserPasswordLoginData(String user, String password) {
        this.user = user;
        this.password = password;
        this.newPassword = null; // No change requested
    }

    public UserPasswordLoginData(String user, String password, String newPassword) {
        this.user = user;
        this.password = password;
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UserPasswordLoginData{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}