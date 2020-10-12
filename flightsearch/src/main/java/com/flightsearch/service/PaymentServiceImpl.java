package com.flightsearch.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DAO.PaymentDAO;
import com.flightsearch.DAO.UserDAO;
import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;

@Service
@ComponentScan(basePackages = "com.flightsearch.DAO")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;


	@Override
	@Transactional
	public PaymentModel saveOrder(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket) {
		return paymentDAO.save(paymentInfoDTO, ticket);
	}


	@Override
	public int cancelOrder(PaymentModel paymentModel) {
		return paymentDAO.cancel(paymentModel);
	}
}
