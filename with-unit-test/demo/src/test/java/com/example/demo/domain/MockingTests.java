package com.example.demo.domain;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingTests {

    @Mock
    User user;
    /*
     * OR
     * User user = mock(User.class);
     */


    @Test
    @DisplayName("Permission assigned successfully")
    public void assignPermissions() {

        //Arrange
        Mocking mocking = new Mocking();
        mocking.setUser(user);

        when(user.getRole()).thenReturn("admin");

        //Act, Assert
        Assertions.assertEquals(1, mocking.assignPermission());
    }
}