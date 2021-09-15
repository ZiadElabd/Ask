package Ask.backend.controller;

import Ask.backend.models.user;
import Ask.backend.security.requestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class userController {

    private requestHandler handler=new requestHandler();


    @PostMapping("/signup")
    public boolean signupController( @RequestBody user temp){
        System.out.println("ffff");
        temp.toString();
        if (handler.signup(temp)) return true;
        temp.toString();
        return false;
    }

    @PostMapping("/signin")
    public ResponseEntity<Boolean> signinController( @RequestBody user temp){
        if (handler.signIn(temp.getEmail(),temp.getPassword()))  return new ResponseEntity<>(true
                , HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }
}
