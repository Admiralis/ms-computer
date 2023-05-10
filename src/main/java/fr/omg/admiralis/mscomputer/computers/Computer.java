package fr.omg.admiralis.mscomputer.computers;

import fr.omg.admiralis.mscomputer.comments.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "computers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Computer {
    private String id;
    private String serialNumber;
    private String processor;
    private String ram;
    private String condition;
    private ComputerStatus computerStatus;
    @DBRef
    private List<Comment> comments;
}
