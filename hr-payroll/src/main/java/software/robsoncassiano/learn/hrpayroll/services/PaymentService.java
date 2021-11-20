package software.robsoncassiano.learn.hrpayroll.services;

import org.springframework.stereotype.Service;
import software.robsoncassiano.learn.hrpayroll.entities.Payment;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Fulano", 200.0, days);
    }
}
