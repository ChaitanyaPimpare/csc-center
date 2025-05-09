package com.chaitanya.csc_center.controller;

import com.chaitanya.csc_center.model.User;
import com.chaitanya.csc_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    // Admin Dashboard
      @GetMapping("/dashboard")
    public String showAdminDashboard() {
        return "admin_dashboard"; // Corresponds to admin_dashboard.html in templates
    }

    // View all users (for the admin)
    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin_users";  // returns a view to display users
    }

    // Add a new user
    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin_add_user";  // returns a view to add a new user
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        user.setRole("ROLE_USER");  // Default role for new users (can be changed later)
        userService.saveUser(user);
        return "redirect:/admin/users";  // Redirect to users list after adding
    }

    // Delete a user
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";  // Redirect to users list after deletion
    }

    // Edit user details
    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin_edit_user";  // returns a view to edit user details
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.saveUser(user);  // Update the user in the database
        return "redirect:/admin/users";  // Redirect to users list after editing
    }
}
