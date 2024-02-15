package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String role;
    private List<String> posts;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAllPostsContainingWord(String word) {
        List<String> filteredPosts = new ArrayList<>();
        for(String post: posts) {
            if(post.contains(word))
                filteredPosts.add(post);
        }
        return filteredPosts;
    }
}
