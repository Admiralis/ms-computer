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

    /**
     * Retourne tous les ordinateurs
     * @return la liste des ordinateurs
     */
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    /**
     * Sauvegarde un ordinateur
     * @param computer
     * @return l'ordinateur sauvegardé
     */
    public Computer save(Computer computer) {
        if (computer.getComments() != null) {
            computer.getComments().forEach(commentService::save);
        }
        return computerRepository.save(computer);
    }

    /**
     * Retourne un ordinateur par son id
     * @param id
     * @return l'ordinateur
     */
    public Computer findById(String id) {
        return computerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Supprime un ordinateur par son id
     * @param id
     */
    public void deleteById(String id) {
        computerRepository.deleteById(id);
    }

    /**
     * Supprime un commentaire d'un ordinateur
     * @param computerId
     * @param commentId
     * @return l'ordinateur
     */
    public Computer deleteComment(String computerId, String commentId) {
        Computer computer = findById(computerId);
        computer.getComments().removeIf(comment -> comment.getId().equals(commentId));
        return computerRepository.save(computer);
    }

    public Computer update(String id, Computer updateComputer) {
        Computer computer = findById(id);
        if (updateComputer.getSerialNumber() != null) {
            computer.setSerialNumber(updateComputer.getSerialNumber());
        }
        if (updateComputer.getProcessor() != null) {
            computer.setProcessor(updateComputer.getProcessor());
        }
        if (updateComputer.getRam() != null) {
            computer.setRam(updateComputer.getRam());
        }
        if (updateComputer.getCondition() != null) {
            computer.setCondition(updateComputer.getCondition());
        }
        if (updateComputer.getComputerStatus() != null) {
            computer.setComputerStatus(updateComputer.getComputerStatus());
        }
        computerRepository.save(computer);
        return findById(computer.getId());
    }
}
