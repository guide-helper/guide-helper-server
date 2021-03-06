package server.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.core.model.User;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User()
                .setUserMail("johndoe@example.com")
                .setCity("Moscow")
                .setName("John")
                .setGuide(true)
                .setDescription("I like discrete math...")
                .setPhoneNumber("123456789");

        Assertions.assertEquals(user.getUserMail(), "johndoe@example.com");
        Assertions.assertEquals(user.getCity(), "Moscow");
        Assertions.assertEquals(user.getName(), "John");
        Assertions.assertTrue(user.isGuide());
        Assertions.assertEquals(user.getDescription(), "I like discrete math...");
        Assertions.assertEquals(user.getPhoneNumber(), "123456789");
    }
}
