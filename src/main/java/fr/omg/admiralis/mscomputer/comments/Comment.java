package fr.omg.admiralis.mscomputer.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    private String id;
    private String content;
}
