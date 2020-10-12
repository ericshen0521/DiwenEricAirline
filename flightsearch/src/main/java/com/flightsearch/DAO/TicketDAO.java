package com.flightsearch.DAO;

import com.flightsearch.DTO.TicketInfoDTO;
import com.flightsearch.model.TicketInfo;

public interface TicketDAO {
	public TicketInfo save(TicketInfoDTO ticketInfoDTO);
	public void update(TicketInfo ticketInfo);
}
