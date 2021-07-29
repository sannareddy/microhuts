package in.codehut.userservice.ui.models;


import java.util.Date;

public class PaymentsIO {
	private int paymentId;
	private int userId;
	private Date paymentDate;
	private String paymentStatus;

	public double getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentsIO(int paymentId, int userId, Date paymentDate, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}


}
