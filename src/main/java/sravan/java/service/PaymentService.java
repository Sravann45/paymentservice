package sravan.java.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sravan.java.models.Payment;
import sravan.java.repositories.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo repo;

	public Payment doPayment(Payment payment) {
		payment.setTxnId(UUID.randomUUID().toString());
		 payment.setStatus(paymentProcessing());
		 System.out.println("***** "+payment.getStatus());
		return repo.save(payment);
	}

	public String paymentProcessing() {
		// api gateway call of payment eg: paytm,gpay
		return new Random().nextBoolean() ? "success" : "failed";
	}
	
	 public Payment findPaymentHistoryByOrderId(int orderId) {
	        Payment payment=repo.findByOrderId(orderId);
	       // logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
	        return payment ;
	    }

}
