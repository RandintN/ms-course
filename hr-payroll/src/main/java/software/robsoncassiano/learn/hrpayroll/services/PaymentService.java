package software.robsoncassiano.learn.hrpayroll.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import software.robsoncassiano.learn.hrpayroll.entities.Payment;
import software.robsoncassiano.learn.hrpayroll.entities.Worker;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;
    @Value("${hr-worker.host}")
    public String workerHost;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(Long workerId, Integer days) {
        final Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("workerId", String.valueOf(workerId));
        final Worker worker = restTemplate.getForObject(workerHost + "/workers/{workerId}", Worker.class, uriVariables);
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
