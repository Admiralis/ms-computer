package fr.omg.admiralis.mscomputer.computers;

import jakarta.websocket.MessageHandler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerRepository extends MongoRepository<Computer, String> {
    Computer findBySerialNumber(String serialNumber);
}
