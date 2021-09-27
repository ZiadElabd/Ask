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
        return new ResponseEntity<>(handler.getFollwersQuestions(id,userName), HttpStatus.OK);
    }
    @PostMapping("/AddQuestion/{ID}/{userName}")
    public void AddQuestionController(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName,
            @RequestBody String question){
        handler.AddQuestion(id,userName,question);
    }
    @GetMapping("/getQuestion/{ID}/{userName}")
    public ResponseEntity<List<question>> getUnAnsweredQuestionController
            (@PathVariable("ID") String id,
             @PathVariable("userName") String userName ){
        return new ResponseEntity<>(handler.getUserUnAnsweredQuestion(id,userName), HttpStatus.OK);
    }
    @PostMapping("/answerQuestion/{ID}")
    public void answerQuestion(@PathVariable("ID") String id,@RequestBody String reply){
        handler.AnswerQuestion(id,reply);
    }


    @GetMapping("/getProfileQuestion/{ID}/{userName}")
    public ResponseEntity<List<question>> getProfileAnsweredQuestionController
                   (@PathVariable("ID") String id,
                    @PathVariable("userName") String userName)
    {
        return new ResponseEntity<>(handler.getUserAnsweredQuestion(id,userName), HttpStatus.OK);
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
}