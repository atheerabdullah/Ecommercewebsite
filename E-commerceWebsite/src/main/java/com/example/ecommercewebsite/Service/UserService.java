package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getUsers() {
        return users;
    }



    public void addUser(User user) {
        users.add(user);
    }

    public User updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(id)) {
                users.set(i, user);
                System.out.println("user updated: " + user);
                return user;
            }
        }
        System.out.println("user not found with ID: " + id);
        return null;
    }

    public User deleteUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(id)) {
                User deletedUser = users.remove(i);
                System.out.println("User removed with ID: " + id);
                return deletedUser;
            }
        }
        System.out.println("user not found with ID: " + id);
        return null;
    }





}
