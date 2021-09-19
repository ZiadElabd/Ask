package Ask.backend.controller;

import Ask.backend.requestHandler.userRequestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class userController {

    private userRequestHandler handler=new userRequestHandler();

    /**
     *
     * @param temp
     * @return
     */

    @PostMapping("/signup")
    public boolean signupController( @RequestBody String temp){
        System.out.println("ffff");
        System.out.println(temp);
        if (handler.signup(temp)) return true;
        return false;
    }

    /**
     *
     * @return
     */
    @PostMapping ("/checkUsername")
        public ResponseEntity<Boolean> checkUsernameController( @RequestBody String temp){

          return null;
    }

    /**
     *
     * @param temp
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity<String> signinController( @RequestBody String dataSent){
        String status=handler.signIn(dataSent);
        if (status!=null)  return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
