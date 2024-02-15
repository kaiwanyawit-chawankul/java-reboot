package com.example.demo.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.example.demo.infra.ApplicationDao;
import com.example.demo.service.Mocking;

@ExtendWith(MockitoExtension.class)
// @MockitoSettings(strictness = Strictness.LENIENT)
public class MockingTests {

    Mocking mocking;

    @Mock
    ApplicationDao applicationDao;


    @BeforeEach
    public void setup() {
        mocking = new Mocking();
    }


    @Test
    @DisplayName("Permission assigned successfully")
    public void assignPermissions() {

        //Arrange
        User user = mock(User.class);
        mocking.setUser(user);

        when(user.getRole()).thenReturn("admin");

        //Act, Assert
        Assertions.assertEquals(1, mocking.assignPermission());
    }

    ///Don't follow this, it only shows how to stuff; it's buggy
    @Test
    public void getAllPostsContainingWord(){

        User user = mock(User.class);

        List<String> filteredPosts = new ArrayList<>();
        filteredPosts.add("Awesome Day");
        filteredPosts.add("This place is awesome");
        when(user.getAllPostsContainingWord("awesome")).thenReturn(filteredPosts);

        mocking.setUser(user);

        //Act, Assert
        Assertions.assertArrayEquals(filteredPosts.toArray(), user.getAllPostsContainingWord("awesome").toArray());
    }

    @Test
    @DisplayName("User updated successfully")
    public void updateUsername() throws Exception {
        User user = new User();
        user.setUsername("user1");
        lenient().when(applicationDao.getUserById(Mockito.anyString())).thenReturn(user);

        mocking.setUser(user);

        Assertions.assertEquals(1, mocking.updateUsername("3211", "allan"));
    }

    @Test
    @DisplayName("User can't be updated")
    public void updateUsername2() throws Exception {
        User user = new User();
        user.setUsername("user1");
        lenient().when(applicationDao.getUserById(Mockito.anyString())).thenReturn(null);

        mocking.setUser(user);

        Assertions.assertThrows(Exception.class, () -> {
            mocking.updateUsername("3412","allan");
        });
    }
}