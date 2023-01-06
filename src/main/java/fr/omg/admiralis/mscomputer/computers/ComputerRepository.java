package fr.omg.admiralis.mscomputer.computers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerRepository extends MongoRepository<Computer, String> {
}
