package in.codehut.paymentservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.codehut.paymentservice.model.Payment;

@RestController
@RequestMapping("/payments")
public class PaymentServiceController {
	private static Logger logger = LogManager.getLogger(PaymentServiceController.class);
	private List<Payment> paymentsMock(){
		List<Payment> payments=new ArrayList<>();
		Payment paymentservice=new Payment(1089888,1,new Date(),"inprogress");
		payments.add(paymentservice);
		paymentservice=new Payment(1089889,2,new Date(),"inprogress");
		payments.add(paymentservice);
		paymentservice=new Payment(1089890,1,new Date(),"Completed");
		payments.add(paymentservice);
		return payments;
	}
	@GetMapping("")
	@ResponseBody
	public List<Payment> getPayments() {
		List<Payment> payments = paymentsMock();
		return payments;
	}
	@GetMapping("/{userid}")
	@ResponseBody
	public List<Payment> getPayments(@PathVariable("userid") int userid) {
		logger.info("Payment Controller For User:"+userid);
		List<Payment> payments = paymentsMock();
		payments = payments
			.stream() 
			.filter(payment->payment.getUserId()==userid)
			.collect(Collectors.toList());
		return payments;
	}

}
