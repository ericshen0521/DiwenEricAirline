package com.flightsearch.DAO;

import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;

public interface PaymentDAO {
	public PaymentModel save(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket);
	public int cancel(PaymentModel paymentModel);
}
