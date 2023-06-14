package lt.codeacademy.restapiexample.controllers;

import lt.codeacademy.restapiexample.dto.CommentDto;
import lt.codeacademy.restapiexample.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {

        commentService.createComment(commentDto);
        return commentDto;
    }

}
