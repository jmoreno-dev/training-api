package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void shouldGetUserFieldsUsingGetters(){
         User trainer= new User();
         User user= new User(1L, "testName", "testSurname", "email@email.com", "12345678", Role.ROLE_CLIENT, trainer);

        assertNotNull(user);

        assertEquals(1L, user.getId());
         assertEquals("testName", user.getName());
         assertEquals("testSurname", user.getSurname());
         assertEquals("email@email.com", user.getEmail());
         assertEquals("12345678", user.getPassword());
         assertEquals(Role.ROLE_CLIENT, user.getRole());
         assertEquals(trainer, user.getTrainer());
    }

    @Test
    void shouldUpdateUserFieldsUsingSetters(){
        User trainer= new User();
        User newTrainer = new User();
        User user= new User(1L, "testName", "testSurname", "email@email.com", "12345678", Role.ROLE_CLIENT, trainer);

        user.setName("newName");
        assertEquals("newName", user.getName());
        user.setSurname("newSurname");
        assertEquals("newSurname", user.getSurname());
        user.setEmail("newEmail@email.com");
        assertEquals("newEmail@email.com", user.getEmail());
        user.setPassword("012345678");
        assertEquals("012345678", user.getPassword());
        user.setRole(Role.ROLE_TRAINER);
        assertEquals(Role.ROLE_TRAINER, user.getRole());
        user.setTrainer(newTrainer);
        assertEquals(newTrainer, user.getTrainer());
    }

    @Test
    void shouldAssignTrainerToClient(){
        User trainer = new User();
        User user= new User(1L, "testName", "testSurname", "email@email.com", "12345678", Role.ROLE_CLIENT, trainer);

        assertEquals(trainer, user.getTrainer());
    }
}
