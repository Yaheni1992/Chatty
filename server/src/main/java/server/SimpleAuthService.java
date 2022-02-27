package server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        users.add(new UserData("qwe", "qwe", "Tita"));
        users.add(new UserData("asd", "asd", "Mis"));
        users.add(new UserData("zxc", "zxc", "Mac"));

        for (int i = 0; i < 9; i++) {
            users.add(new UserData("user" + i, "pass" + i, "nick" + i));
        }

    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData u : users) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u.nickname;
            }
        }

        return null;
    }
}
