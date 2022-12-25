package com.loops.loopsapi.User;

import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void existByEmailSuccess(){
        boolean user = userRepository.existsByEmail("Candraaji@gmail.com");
        Assertions.assertTrue(user);
    }

    @Test
    void existByEmailFail(){
        boolean user = userRepository.existsByEmail("cand@gmail.com");
        Assertions.assertFalse(user);
    }

    @Test
    void findByEmailSuccess(){
        Optional<User> user = userRepository.findByEmail("Candraaji@gmail.com");
        Assertions.assertTrue(user.isPresent());
    }

    @Test
    void findByEmailFail(){
        Optional<User> user = userRepository.findByEmail("cand@gmail.com");
        Assertions.assertFalse(user.isPresent());
    }

}
