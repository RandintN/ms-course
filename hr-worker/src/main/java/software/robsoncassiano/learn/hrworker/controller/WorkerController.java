package software.robsoncassiano.learn.hrworker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.learn.hrworker.entities.Worker;
import software.robsoncassiano.learn.hrworker.repositories.WorkerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/worker-ms")
public class WorkerController {
    private static final Logger log = LoggerFactory.getLogger(WorkerController.class);

    private final Environment environment;

    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository, Environment environment) {
        this.workerRepository = workerRepository;
        this.environment = environment;
    }

    @GetMapping(path = "/workers")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(path = "/workers/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable(name = "id") Long id) throws Exception {

        log.info("PORT: " + environment.getProperty("local.server.port"));

        if (workerRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(workerRepository.findById(id).get());
        } else {
            throw new Exception(String.format("The worker with Id %s wasn't found", id));
        }
    }
}
