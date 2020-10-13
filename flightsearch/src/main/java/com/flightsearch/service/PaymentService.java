package com.flightsearch.service;


import java.util.List;

import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;

public interface PaymentService {
	public PaymentModel saveOrder(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket);
	public int cancelOrder(PaymentModel paymentModel);
	public List<PaymentModel> fetchPayments();
	public PaymentModel fetchPaymentByID(int paymentID);
	public void save(PaymentModel payment);
	public void update(PaymentModel payment);
	public void delete(PaymentModel payment);
}
