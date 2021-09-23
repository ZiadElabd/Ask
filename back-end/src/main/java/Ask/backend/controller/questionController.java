package Ask.backend.controller;

import Ask.backend.models.question;
import Ask.backend.requestHandler.questionRequestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class questionController {
    questionRequestHandler handler=new questionRequestHandler();
    @PostMapping("/{ID}/{userName}/AddQuestion")
    public void AddQuestionController(
            @PathVariable("ID") String id,
            @PathVariable("userName") String userName,
            @RequestBody String question){
        handler.AddQuestion(id,userName,question);
    }
    @GetMapping("/getQuestion/{ID}")
    public ResponseEntity<List<question>> getQuestionController(@PathVariable("ID") String id ){
        return new ResponseEntity<>(handler.getUserAnsweredQuestion(id), HttpStatus.OK);
    }
    @PostMapping("/answerQuestion/{ID}")
    public void answerQuestion(@PathVariable("ID") String id){

    }
    /*
    @GetMapping("/getHomeQuestion/{ID}")
    public ResponseEntity<List<question>> getHomeQuestionController(@PathVariable("ID") String id){


    }*/
}