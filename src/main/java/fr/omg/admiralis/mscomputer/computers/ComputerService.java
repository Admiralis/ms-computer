package fr.omg.admiralis.mscomputer.computers;

import fr.omg.admiralis.mscomputer.comments.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ComputerService {
    private final ComputerRepository computerRepository;
    private final CommentService commentService;

    public ComputerService(ComputerRepository computerRepository, CommentService commentService) {
        this.computerRepository = computerRepository;
        this.commentService = commentService;
    }

    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    public Computer save(Computer computer) {
        if (computer.getComments() != null) {
            computer.getComments().forEach(comment -> commentService.save(comment));
        }
        return computerRepository.save(computer);
    }

    public Computer findById(String id) {
        return computerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        computerRepository.deleteById(id);
    }

    public Computer deleteComment(String computerId, String commentId) {
        Computer computer = findById(computerId);
        computer.getComments().removeIf(comment -> comment.getId().equals(commentId));
        return computerRepository.save(computer);
    }
}
