package com.example.Project.Controller;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Sites;
import com.example.Project.Models.User;
import com.example.Project.Repositories.UserInterface;
import com.example.Project.Request.ChangePasswordRequest;
import com.example.Project.Request.MessageResponse;
import com.example.Project.Services.DevServiceImpl;
import com.example.Project.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userServiceImp;
    private final UserInterface userRepository;
    private final DevServiceImpl devServiceImpl;

    public UserController(UserServiceImpl userServiceImp, UserInterface userRepository, UserInterface userRepository1, DevServiceImpl devServiceImpl) {
        this.userServiceImp = userServiceImp;

        this.userRepository = userRepository1;
        this.devServiceImpl = devServiceImpl;
    }

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        try {
            String message = userServiceImp.changePassword(request, connectedUser);
            return ResponseEntity.ok().body(message);
        } catch (IllegalStateException e) {
            // Handle the exception and return an appropriate error response
            return ResponseEntity.badRequest().body("Passwords do not match"); // Or a more user-friendly message
        }
    }

    @PostMapping("/findemail")
    public ResponseEntity<?> verifyEmail(@RequestParam String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.ok().body(new MessageResponse("email exist "));
        } else {
           return  ResponseEntity.badRequest().body(new MessageResponse("email does not exist "));
        }
    }
    @GetMapping( value="/emails") // Assuming public access for demonstration
    public ResponseEntity<List<String>> getAllEmails() {
        List<String> emailList = userServiceImp.findAllEmails();
        if (emailList.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no emails found
        }
        return ResponseEntity.ok(emailList); // Return 200 OK with email list
    }
    /**updating a user accesible only by admin */
    @PutMapping(value="/updateuser/{id}")
    public ResponseEntity<?> updateuser(@RequestBody User user , @PathVariable int id){
        userServiceImp.updateUser(user,id);
        return ResponseEntity.ok().body(new MessageResponse("user updated"));
    }

    @GetMapping("/find-all")
    public List<User> getAllUsers() {
        return userRepository.findAllByProfile("rc");
    }
    @GetMapping("/devs/findByUser/{userId}")
    public ResponseEntity<List<Dev>> getDevsByUserId(@PathVariable int userId) {
        List<Dev> devs = devServiceImpl.getDevsByUserId(userId);
        return ResponseEntity.ok(devs);
    }
}
