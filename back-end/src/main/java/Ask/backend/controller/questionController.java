package Ask.backend.controller;

import Ask.backend.models.question;
import Ask.backend.requestHandler.questionRequestHandler;
import Ask.backend.security.proxy;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class questionController {
    questionRequestHandler handler=new questionRequestHandler();
    private proxy checker=new proxy();
    @GetMapping("/getHomeQuestion/{ID}/{userName}")
    public ResponseEntity<List<question>> getHomeQuestionController
            (@PathVariable("ID") String id,
             @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(handler.getFollwersQuestions(userName), HttpStatus.OK);
    }
    @PostMapping("/AddQuestion/{ID}/{userName}")
    public ResponseEntity<Void> AddQuestionController(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName,
            @RequestBody String question){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.AddQuestion(realID,userName,question);
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getQuestion/{ID}/{userName}")
    public ResponseEntity<List<question>> getUnAnsweredQuestionController
            (@PathVariable("ID") String id,
             @PathVariable("userName") String userName ){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(handler.getUserUnAnsweredQuestion(userName), HttpStatus.OK);
    }
    @PostMapping("/answerQuestion/{ID}")
    public ResponseEntity<Void> answerQuestion(@PathVariable("ID") String id,@RequestBody String reply){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.AnswerQuestion(reply);
        return   new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getProfileQuestion/{ID}/{userName}")
    public ResponseEntity<List<question>> getProfileAnsweredQuestionController
                   (@PathVariable("ID") String id,
                    @PathVariable("userName") String userName)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(handler.getUserAnsweredQuestion(userName), HttpStatus.OK);
    }
    @PostMapping("/AddLike/{ID}/{userName}/{QuestionId}")
    public  ResponseEntity<Void> AddLike
            (       @PathVariable("ID") String id,
                    @PathVariable("userName") String userName,
                    @PathVariable("QuestionId") String QuestionId){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.AddLike(userName,QuestionId);
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/removeLike/{ID}/{userName}/{QuestionId}")
    public  ResponseEntity<Void> removeLike
            (       @PathVariable("ID") String id,
                    @PathVariable("userName") String userName,
                    @PathVariable("QuestionId") String QuestionId){
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        handler.removeLike(userName,QuestionId);
        return   new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping ("/getNotifactions/{ID}")
    public ResponseEntity<List<question>> getNotications(@PathVariable ("ID") String id)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(handler.getNofications(realID),HttpStatus.OK);
    }
    @GetMapping("/getAskAnsQuestion/{ID}/{questionID}")
    public ResponseEntity<question> getAskAnsQuestion(
            @PathVariable("ID") String id,
            @PathVariable("questionID") String QuestionId)
    {
        ObjectId realID=checker.checkAcess(id);
        if(realID.equals(null)) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(handler.getAskAnsQuestion(QuestionId),HttpStatus.OK);
    }

}