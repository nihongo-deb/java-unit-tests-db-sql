package Entity;

import javax.persistence.*;

/**
 * @author KAWAIISHY
 * @project paps-unit-tetst-with-db
 * @created 12.04.2022
 */
@Entity
@Table(name = "users")
public class User {
    public User(){

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.chat = chat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String email;

    @Column(name = "password")
    private String password;

    private Chat chat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message){
        chat.sendMessage(this.name, message, this);
    }

    public void getMessage(String senderName, String message){
        System.out.println("#" + this.name + "#\t" + " receiving message from\t#" + senderName + "#: " + message + ".");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
