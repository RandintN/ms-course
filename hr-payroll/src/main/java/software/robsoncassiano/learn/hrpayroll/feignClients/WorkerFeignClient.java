package software.robsoncassiano.learn.hrpayroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import software.robsoncassiano.learn.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/worker-ms/workers")
public interface WorkerFeignClient {

    @GetMapping(path = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
