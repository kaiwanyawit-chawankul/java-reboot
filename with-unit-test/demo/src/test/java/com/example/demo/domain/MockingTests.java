package com.example.demo.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

    ///Don't follow this, it only shows how to stuff; it's buggy
    @Test
    public void getAllPostsContainingWord(){
        List<String> filteredPosts = new ArrayList<>();
        filteredPosts.add("Awesome Day");
        filteredPosts.add("This place is awesome");
        when(user.getAllPostsContainingWord("awesome")).thenReturn(filteredPosts);

        Mocking mocking = new Mocking();
        mocking.setUser(user);

        //Act, Assert
        Assertions.assertArrayEquals(filteredPosts.toArray(), user.getAllPostsContainingWord("awesome").toArray());
    }
}