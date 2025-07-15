package velox.api.layer1.data;

import java.io.Serializable;

public class UserPasswordAccountLoginData extends UserPasswordLoginData implements Serializable {
    public final int account;
    public final boolean kick;

    public UserPasswordAccountLoginData(String user, String password, int account, boolean kick) {
        super(user, password);
        this.account = account;
        this.kick = kick;
    }

    public UserPasswordAccountLoginData(String user, String password, String newPassword, int account, boolean kick) {
        super(user, password, newPassword);
        this.account = account;
        this.kick = kick;
    }

    @Override
    public String toString() {
        return "UserPasswordAccountLoginData{" +
                "account=" + account +
                ", kick=" + kick +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}