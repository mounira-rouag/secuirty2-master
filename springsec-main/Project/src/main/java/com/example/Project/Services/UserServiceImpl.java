package com.example.Project.Services;

import com.example.Project.Models.User;
import com.example.Project.Repositories.UserInterface;
import com.example.Project.Request.ChangePasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserServiceImpl {

    private final UserInterface userInterface;

    private final PasswordEncoder passwordEncoder;


    private final UserDetailsServiceImpl userDetailsService;

    public UserServiceImpl(UserInterface userInterface, PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.userInterface = userInterface;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }



    public User saveUser(User User) {

        return userInterface.save(User);
    }
    public boolean validateEmailForDomain(String email) {
        // Enhanced regular expression for email format validation
        Pattern emailPattern = Pattern.compile("^([\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*)@(actia-engineering.tn)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
    public boolean validatePassword(String password) {
        // Minimum length requirement
        if (password.length() < 8) {
            return false;
        }

        // Character type requirements
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }
        // Check if all required character types are present
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
    public User existsByEmail(String email) {
        return userInterface.findByEmail(email);
    }
    public String changePassword(ChangePasswordRequest request, Principal connectedUser) {
        // Load the user details by username from the database
        UserDetails userDetails = userDetailsService.loadUserByUsername(connectedUser.getName());
        // Check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), userDetails.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // Check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Passwords are not the same");
        }
        // Load the user from the database
        User user = userInterface.findByUsername(connectedUser.getName())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        // Update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        // Save the updated user
        userInterface.save(user);

        return "Password changed successfully";
    }

    public List<String> findAllEmails() {
        List<User> users = userInterface.findAll(); // Retrieve all users from the database
        return users.stream()
                .map(User::getEmail) // Extract email addresses using stream operations
                .collect(Collectors.toList());
    }
}



