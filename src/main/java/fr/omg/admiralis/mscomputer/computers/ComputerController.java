package fr.omg.admiralis.mscomputer.computers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.omg.admiralis.mscomputer.computers.dto.ComputerFullDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computers")
@CrossOrigin
public class ComputerController {
    private final ComputerService computerService;
    private final ObjectMapper objectMapper;


    public ComputerController(ComputerService computerService, ObjectMapper objectMapper) {
        this.computerService = computerService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<ComputerFullDto> findAll() {
        List<Computer> computers = computerService.findAll();
        return computers.stream().map(computer -> objectMapper.convertValue(computer, ComputerFullDto.class)).toList();
    }

    @PostMapping
    public ComputerFullDto save(@RequestBody Computer newComputer) {
        Computer computer = computerService.save(newComputer);
        return objectMapper.convertValue(computer, ComputerFullDto.class);
    }

    @GetMapping("{id}")
    public ComputerFullDto findById(@PathVariable String id) {
        Computer computer = computerService.findById(id);
        return objectMapper.convertValue(computer, ComputerFullDto.class);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        computerService.deleteById(id);
    }

    @DeleteMapping("{computerId}/comments/{commentId}")
    public Computer deleteComment(@PathVariable String computerId, @PathVariable String commentId) {
        return computerService.deleteComment(computerId, commentId);
    }
}
