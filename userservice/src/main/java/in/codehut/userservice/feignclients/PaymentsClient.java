package in.codehut.userservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.codehut.userservice.ui.models.PaymentsIO;

@FeignClient(name="paymentservice")
public interface PaymentsClient {
	@GetMapping("/payments/{userid}")
	public List<PaymentsIO> getPayments(@PathVariable("userid") int userid);
}
