package sravan.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sravan.java.models.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	Payment findByOrderId(int orderId);
	
}
