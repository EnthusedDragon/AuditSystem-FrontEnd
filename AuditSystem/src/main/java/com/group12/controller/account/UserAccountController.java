package com.group12.controller.account;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 21-09-2020
 *   Description: Controller for UserAccount
 */

import com.group12.entity.UserAccount;
import com.group12.factory.UserAccountFactory;
import com.group12.service.account.UserAccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController // states that this class is a rest Controller containing end points
@RequestMapping("/AuditSystem/userAccount") // this is the base route for the userAccount controller
@CrossOrigin(origins = "*")
public class UserAccountController {

    // GetMapping -> return existing data to whoever calls the end point
    // eg -> read, that returns a userAccount

    // PutMapping -> updating existing data
    // eg -> changePassword, can update password if password has been forgotten

    // DeleteMapping -> To delete existing data
    // eg -> deleting an UserAccount

    // PostMapping -> creating new data
    // eg -> creating userAccount


    //have to call userAccount service
    //wired means i am injecting the constructor of service into UserAccount class
    @Autowired // UserAccountService instance created here inside UserAccount controller class
    private UserAccountService userAccountService; // made UserAccountService annotated with Service

    //Business logic 1
    @PostMapping("/create") // this is a post end point, that contains a route that builds onto the controller route
    //and returns a response entity containing the userAccount result
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount userAccount) { // ResponseEntity is a class, an object that get returned from end points
        try {
            UserAccount newUserAccount = UserAccountFactory.createUserAccount(userAccount.getEmail(), userAccount.getPassword(),
                    userAccount.isLoginStatus(), userAccount.getRegisterDate(), userAccount.getFirstName(), userAccount.getSurname(), userAccount.getCellPhone());

            return ResponseEntity.ok(userAccountService.create(newUserAccount));
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 2
    // Here is the URL:localhost:8080/userAccount/read?userId=ceed6528-e061-460c-8ceb-2305d8c0c024
    // from URL from Postman:
    // URL:localhost:8080 ->  server address
    // /userAccount-> controller route
    // /read -> is the the end point route
    // ?userId=ceed6528-e061-460c-8ceb-2305d8c0c024 ->  ? represents the end of route & start of param.

    @GetMapping("/read")
    public ResponseEntity<UserAccount> read(@RequestParam String userId){
        UserAccount read = userAccountService.read(userId);

        if(read == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(read);
    }

    //Business logic 3
    @PutMapping("/update")
    public ResponseEntity<UserAccount> update(@RequestBody UserAccount userAccount) {
        UserAccount updated = userAccountService.update(userAccount);

        if(updated == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updated);
    }

    //Business logic 4
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String userId) {
        boolean deleted = userAccountService.delete(userId);

        if(!deleted)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(true);
    }

    //Business logic 5
    @PostMapping("/registerUserAccount")
    public ResponseEntity<UserAccount> registerUserAccount(@RequestParam String email,String verifyemail,String password,String verifypassword, String firstname, String surname, String cellPhone) {
        try {
            UserAccount newUserAccount = userAccountService.registerUserAccount(email, verifyemail, password, verifypassword, firstname, surname, cellPhone);

            return ResponseEntity.ok(newUserAccount);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 6
    @PutMapping("/changePassword")
    public ResponseEntity changePassword(String email, String existingPassword, String newPassword, String verifyNewPassword){
        try {
            return ResponseEntity.ok(userAccountService.changePassword(existingPassword, newPassword, verifyNewPassword, email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 7
    @PutMapping("/updateEmailAddress")
    public ResponseEntity updateEmailAddress(String email, String existingPassword, String newEmail, String verifyNewEmail){
        try {
            return ResponseEntity.ok(userAccountService.updateEmailAddress(email, newEmail, verifyNewEmail, existingPassword));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 8
    @GetMapping("/forgotPassword")
    public ResponseEntity forgotPassword(String email){
        try {
            return ResponseEntity.ok(userAccountService.forgotPassword(email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Business logic 9
    @GetMapping("/getUserAccountViaEmailAddress")
    public ResponseEntity<UserAccount> getUserAccountViaEmailAddress(String email) {
        try {
            return ResponseEntity.ok(userAccountService.getUserAccountViaEmailAddress(email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // ResponseEntity doesnt need a return type here, as it auto picks up the type
        }
    }

    //Business logic 10
    @GetMapping("/all")
    public ResponseEntity<Set<UserAccount>> getAll(){
      return ResponseEntity.ok(userAccountService.getAll());
    }
}
