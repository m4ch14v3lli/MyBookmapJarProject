package velox.api.layer1.data;

import java.io.Serializable;

public class UserPasswordDemoLoginData extends UserPasswordLoginData implements Serializable {
    public final boolean isDemo;
    public final boolean kick;

    public UserPasswordDemoLoginData(String user, String password, boolean isDemo, boolean kick) {
        super(user, password);
        this.isDemo = isDemo;
        this.kick = kick;
    }

    public UserPasswordDemoLoginData(String user, String password, boolean isDemo) {
        super(user, password);
        this.isDemo = isDemo;
        this.kick = false; // Default to false if not provided
    }

    @Override
    public String toString() {
        return "UserPasswordDemoLoginData{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", isDemo=" + isDemo +
                ", kick=" + kick +
                '}';
    }
}