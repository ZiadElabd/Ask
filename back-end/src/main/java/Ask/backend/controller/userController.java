package Ask.backend.controller;

import Ask.backend.models.user;
import Ask.backend.requestHandler.userRequestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping  ("/checkUsername/{userName}")
        public ResponseEntity<Boolean> checkUsernameController( @PathVariable("userName") String temp){
             if(handler.checkUserName(temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
             return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

    /**
     *
     * @param dataSent
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity<String> signinController( @RequestBody String dataSent){
        String status=handler.signIn(dataSent);
        if (status!=null)  return new ResponseEntity<>(status, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/getUsers/{ID}/{start}/{num}")
        public ResponseEntity<List<user>>  getUsersController(@PathVariable("ID") String id,@PathVariable("start") int start,@PathVariable("num") int num){
         return (ResponseEntity<List<user>>) handler.getUser(id,start,num);
        }

}
