package lt.codeacademy.restapiexample.services;

import lt.codeacademy.restapiexample.dto.CommentDto;
import lt.codeacademy.restapiexample.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    List<Comment> commentList = new ArrayList<>();

    public CommentDto createComment(CommentDto commentDto) {

        Comment comment = new Comment(commentDto);
        commentList.add(comment);
        return commentDto;

    }


}
