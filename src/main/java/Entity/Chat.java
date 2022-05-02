package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KAWAIISHY
 * @project paps-unit-tetst-with-db
 * @created 13.04.2022
 */
public class Chat {

    private User admin;

    private List<User> userList = new ArrayList<>();

    private long id;

    public void setAdmin(User admin) {
        this.admin = admin;
        addUserToChat(admin);
        admin.setChat(this);
    }

    public void addUserToChat(User user){
        this.userList.add(user);
        user.setChat(this);
    }

    public void sendMessage(String senderName, String message, User user) {
        for (User u : userList){
            if (u != user){
                u.getMessage(senderName, message);
            }
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
