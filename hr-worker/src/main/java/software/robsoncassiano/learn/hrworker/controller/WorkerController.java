package software.robsoncassiano.learn.hrworker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.learn.hrworker.entities.Worker;
import software.robsoncassiano.learn.hrworker.repositories.WorkerRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkerController {
    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping(path = "/workers")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(path = "/workers/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(workerRepository.findById(id).get());
    }
}
