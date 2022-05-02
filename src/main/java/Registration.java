import Entity.Chat;
import Entity.User;
import Exceptions.NullFieldException;
import Exceptions.RegistrationExceptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

/**
 * @author KAWAIISHY
 * @project paps-unit-tetst-with-db
 * @created 12.04.2022
 */
public class Registration {
    private final String HIBERNATE_CFG_SOURS = "src/main/resources/hibernate.cfg.xml";

    // приватный конструктор не позволяет создвавать новых объектов вне данного пакета этого класса
    // из-за чего ключевая особенность патерна singletone будет достигнута
    private Registration(){
    }

    // тут происходит объявление объекта данного класса, он статический, из-за чего мы можем оперировать им
    // обращаясь к самому классу исполюзуя один инкапсулирующий метод-getter
    private static Registration registration = new Registration();

    // метод который как-раз и позволяет получать статическое поле-объект этого класса
    public static Registration getInstance() {
        return registration;
    }

    public void registerNewUser(String name, String mail, String password) throws NullFieldException, RegistrationExceptions {
        // проверка на то, что ни одно из полей не будет пустым (имя, почта, пароль)
        if (name.equals("") || name.equals(null) ||
            mail.equals("") || mail.equals(null) ||
            password.equals("") || password.equals(null))
            throw new NullFieldException("User has unfilled fields");

        // проверка того, что в БД нет пользователя с такой-же почтой
        if(getUser(mail) != null)
            throw new RegistrationExceptions("User with same email is already registered");

        // доьавление пользователя в БД (исход успешной регистрации)
        try (SessionFactory factory = new Configuration()
                .configure(new File(HIBERNATE_CFG_SOURS))
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession())
        {
            session.beginTransaction();
            User user = new User(name, mail, password);
            session.save(user);
        }
    }

    public User getUser(String email){
        List userList;
        try (SessionFactory factory = new Configuration()
                .configure(new File(HIBERNATE_CFG_SOURS))
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession())
        {
            session.beginTransaction();
            userList = session
                    .createQuery("from User where email = :email")
                    .setParameter("email", email)
                    .list();
            System.out.println(userList.get(0));
        } catch (IndexOutOfBoundsException e){
            e.getMessage();
            return null;
        }
        return (User) userList.get(0);
    }

}
