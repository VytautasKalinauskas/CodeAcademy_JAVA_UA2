package lt.codeacademy.restapiexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.restapiexample.dto.CommentDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    Long id;
    String text;
    User author;

    public Comment(CommentDto commentDto) {

        this.id = commentDto.getId();
        this.text = commentDto.getText();
        author.setId(commentDto.getAuthorId());
        this.author = author;

    }


}


