package fr.omg.admiralis.mscomputer.computers.dto;

import fr.omg.admiralis.mscomputer.comments.Comment;
import fr.omg.admiralis.mscomputer.computers.ComputerStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class ComputerFullDto {
    private String id;
    private String serialNumber;
    private String processor;
    private String ram;
    private String condition;

    private ComputerStatus computerStatus;
    @DBRef
    private List<Comment> comments;
}
