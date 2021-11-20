package software.robsoncassiano.learn.hrpayroll.services;

import org.springframework.stereotype.Service;
import software.robsoncassiano.learn.hrpayroll.entities.Payment;
import software.robsoncassiano.learn.hrpayroll.entities.Worker;
import software.robsoncassiano.learn.hrpayroll.feignClients.WorkerFeignClient;

@Service
public class PaymentService {

    private final WorkerFeignClient feignClient;

    public PaymentService(WorkerFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public Payment getPayment(Long workerId, Integer days) {
        final Worker worker = feignClient.findById(workerId).getBody();
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
