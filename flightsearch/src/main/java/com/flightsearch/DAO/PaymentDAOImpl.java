package com.flightsearch.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DTO.FlightPathDTO;
import com.flightsearch.DTO.PaymentInfoDTO;
import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.model.FlightPathBack;
import com.flightsearch.model.FlightPathGo;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;



@Transactional
@Repository
@ComponentScan(basePackages = "com.flightsearch")
public class PaymentDAOImpl implements PaymentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public PaymentModel save(PaymentInfoDTO paymentInfoDTO, TicketInfo ticket) {
		PaymentModel payment = new PaymentModel();
		
		payment.setTicket(ticket);
		payment.setFirstName(paymentInfoDTO.getFirstName());
		payment.setLastName(paymentInfoDTO.getLastName());
		payment.setAddress1(paymentInfoDTO.getAddress1());
		payment.setAddress2(paymentInfoDTO.getAddress2());
		payment.setCountry(paymentInfoDTO.getCountry());
		payment.setState(paymentInfoDTO.getState());
		payment.setZipcode(paymentInfoDTO.getZipcode());
		payment.setNameOnCard(paymentInfoDTO.getNameOnCard());
		payment.setCreditCardNumber(paymentInfoDTO.getCreditCardNumber());
		payment.setExpirationDate(paymentInfoDTO.getExpirationDate());
		payment.setCvv(paymentInfoDTO.getCvv());
		payment.setOrderTotal(ticket.getTotalPrice());
		
		int paymentID = (Integer)getSession().save(payment);
		return payment;
	}

	@Override
	public int cancel(PaymentModel paymentModel) {
		paymentModel.setStatus("Canceled");
		getSession().saveOrUpdate(paymentModel);
		return paymentModel.getId();
	}
	
	@Override
	public List<PaymentModel> fetchPayments() {
		CriteriaQuery<PaymentModel> criteria = getSession().getCriteriaBuilder().createQuery(PaymentModel.class);
		criteria.select(criteria.from(PaymentModel.class));
		return getSession().createQuery(criteria).getResultList();
	}
	
	@Override
	public PaymentModel fetchPaymentByID(int paymentID) {
		return getSession().get(PaymentModel.class, paymentID);
	}
	
	@Override
	public void save(PaymentModel payment) {
		getSession().save(payment);
	}
	
	@Override
	public void update(PaymentModel payment) {
		getSession().update(payment);
	}

	@Override
	public void delete(PaymentModel payment) {
		getSession().delete(payment);
	}
}
