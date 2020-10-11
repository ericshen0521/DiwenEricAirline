package com.flightsearch.service;


import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;

public interface PaymentService {
	public PaymentModel saveOrder(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket);
	public int cancelOrder(PaymentModel paymentModel);
}
