package com.example.ecommercewebsite.Controller;


import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/getUser")
    public ApiResponse getUser() {
        userService.getUsers();
        return (new ApiResponse("All users in the stock :" + "  "
                + userService.getUsers()));
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return user;

    }

    @PutMapping("/{id}/updateUser")
    public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/deleteUser")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        User deleteUser = userService.deleteUser(id);
        if (deleteUser != null) {
            return ResponseEntity.ok(deleteUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}