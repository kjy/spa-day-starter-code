package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("user")
public class UserController{


    // handler method
    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";       // in directory  at template/user/add
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        if (verify.equals(user.getPassword())) {
            // true
            // view template with a message that welcomes the user by username.
            UserData.addUser(user); // add users to user data (data layer) and then add it as an attribute
            model.addAttribute("user", user);
            model.addAttribute("users", UserData.getAll()); // returns a list with getAll
            return "user/index";
        } else {
            // false
            model.addAttribute("error", "Your passwords did not match!");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }
    @GetMapping("details/{userId}")
    public String displayUser(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(user.getJoinedDate());
        model.addAttribute("joined", strDate);
        return "user/details";
    }

}
