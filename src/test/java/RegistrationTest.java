import Entity.User;
import Exceptions.NullFieldException;
import Exceptions.RegistrationExceptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

import java.io.File;

/**
 * @author KAWAIISHY
 * @project paps-unit-tetst-with-db
 * @created 12.04.2022
 */
public class RegistrationTest {
    private final String HIBERNATE_CFG_SOURS = "src/main/resources/hibernate.cfg.xml";

    @After
    public void deleteTestRow(){
        try (SessionFactory factory = new Configuration()
                .configure(new File(HIBERNATE_CFG_SOURS))
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession())
        {
            session.beginTransaction();
            session.createQuery("delete User where name = 'test-user'").executeUpdate();
        }

    }
    @Test
    public void successRegistration() throws RegistrationExceptions, NullFieldException {
        Registration.getInstance().registerNewUser("test-user", "test-user007@mail.ru", "88005553535");
    }

    @Test(expected = RegistrationExceptions.class)
    public void trowRegistrationException() throws RegistrationExceptions, NullFieldException {
        Registration.getInstance().registerNewUser("test-user", "test-user007@mail.ru", "88005553535");
        Registration.getInstance().registerNewUser("test-user-2", "test-user007@mail.ru", "99000000000");
    }

    // пустой параметр имени (уже не пустой)
    @Test(expected = NullFieldException.class)
    public void trowNullFieldExceptionOverName() throws RegistrationExceptions, NullFieldException {
        Registration.getInstance().registerNewUser("test-user", "test-user007@mail.ru", "88005553535");
    }

    // пустой параметр почты
    @Test(expected = NullFieldException.class)
    public void trowNullFieldExceptionOverEmail() throws RegistrationExceptions, NullFieldException {
        Registration.getInstance().registerNewUser("test-user", "", "88005553535");
    }

    // пустой параметр пароля
    @Test(expected = NullFieldException.class)
    public void trowNullFieldExceptionOverPassword() throws RegistrationExceptions, NullFieldException {
        Registration.getInstance().registerNewUser("test-user", "test-user007@mail.ru", "");
    }
}
