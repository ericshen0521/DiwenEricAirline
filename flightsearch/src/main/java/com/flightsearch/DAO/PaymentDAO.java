package com.flightsearch.DAO;

import java.util.List;

import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;

public interface PaymentDAO {
	public PaymentModel save(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket);
	public int cancel(PaymentModel paymentModel);
	public List<PaymentModel> fetchPayments();
	public PaymentModel fetchPaymentByID(int paymentID);
	public void save(PaymentModel payment);
	public void update(PaymentModel payment);
	public void delete(PaymentModel payment);
}
