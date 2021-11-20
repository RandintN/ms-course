package software.robsoncassiano.learn.hrpayroll.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.learn.hrpayroll.entities.Payment;
import software.robsoncassiano.learn.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer days,
                                              @PathVariable Long workerId) {

        final Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
}
