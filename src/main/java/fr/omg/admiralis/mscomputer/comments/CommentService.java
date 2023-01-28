package fr.omg.admiralis.mscomputer.comments;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Retourne tous les commentaires
     * @return la liste des commentaires
     */
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /**
     * Sauvegarde un commentaire
     * @param comment
     * @return le commentaire sauvegardé
     */
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Retourne un commentaire par son id
     * @param id
     * @return le commentaire
     */
    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Supprime un commentaire par son id
     * @param id
     */
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
