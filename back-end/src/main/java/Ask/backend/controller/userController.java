package Ask.backend.controller;

import Ask.backend.models.user;
import Ask.backend.requestHandler.userRequestHandler;
import Ask.backend.security.proxy;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin

public class userController {

    private userRequestHandler handler=new userRequestHandler();
    private proxy  checker=new proxy();

    /**
     *
     * @param temp
     * @return
     */

    @PostMapping("/signup")
    public boolean signupController( @RequestBody String temp){
        if (handler.signup(temp)) return true;
        return false;
    }


    @GetMapping  ("/checkUsername/{userName}")
        public ResponseEntity<Boolean> checkUsernameController( @PathVariable("userName") String temp){
             if(handler.checkUserName(temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
             return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PostMapping("/signin")
    public ResponseEntity<String> signinController( @RequestBody String dataSent){
        String status=handler.signIn(dataSent);
        if (status!=null)  return new ResponseEntity<>(status, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/getUsers/{ID}")
        public ResponseEntity<List<user>>  getUsersController(@PathVariable("ID") String id)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         return  new ResponseEntity<>(handler.getUsers(realID),HttpStatus.OK);
    }
    @GetMapping("/getProfileData/{ID}/{userName}")
    public ResponseEntity<user> getProfileController(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName)
        {
            ObjectId realID=checker.checkAcess(id);
            if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return  new ResponseEntity<>(handler.getuserProfile(userName),HttpStatus.OK);
        }
    @PostMapping("/followUser/{ID}/{userName}")
    public ResponseEntity<Void> followUser(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.AddFollower(realID,userName);
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/unFollowUser/{ID}/{userName}")
    public ResponseEntity<Void> unFollowUser(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.removeFollower(realID,userName) ;
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("getFollowers/{ID}/{userName}")
    public ResponseEntity<List<user>> getFollowersController(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       return   new ResponseEntity<>(handler.getFollowers(userName),HttpStatus.OK);
    }
    @PostMapping("setProfilePhoto/{ID}/{userName}")
    public  ResponseEntity<Void>setProfilePhoto(@PathVariable("ID") String id,
                                                @PathVariable("userName") String userName,
                                                @RequestParam("image") MultipartFile image){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if (handler.setProfilePhoto(userName,image)) return   new ResponseEntity<>(HttpStatus.OK);
        else return   new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping("getProfilePhoto/{ID}/{userName}")
    public  ResponseEntity<String>setProfilePhoto(@PathVariable("ID") String id, @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return  new ResponseEntity<>(handler.getProfilePhoto(userName),HttpStatus.OK);
    }

    @PostMapping("setCoverPhoto/{ID}/{userName}")
    public  ResponseEntity<Void>setCoverPhoto(@PathVariable("ID") String id,
                                              @PathVariable("userName") String userName,
                                              @RequestParam("image") MultipartFile image){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if (handler.setCoverPhoto(userName,image)) return   new ResponseEntity<>(HttpStatus.OK);
        else return   new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping ("getSettings/{ID}/{userName}")
    public  ResponseEntity<user> getSettings(@PathVariable("ID") String id,@PathVariable("userName") String userName){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return   new ResponseEntity<>(handler.getuserProfile(userName),HttpStatus.OK);
    }
    @PostMapping("/settings/{ID}")
    public  ResponseEntity<Void> settings(@PathVariable("ID") String id,@RequestBody String obj){
        System.out.println(obj);
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.updateSettings(realID,obj);
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/logout/{ID}")
    public  ResponseEntity<Void> logOut(@PathVariable("ID") String id){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        checker.deleteActiveUser(id);
        return   new ResponseEntity<>(HttpStatus.OK);
    }




}
