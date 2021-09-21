package Ask.backend.controller;

import Ask.backend.requestHandler.questionRequestHandler;
import org.springframework.web.bind.annotation.*;

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

}