package com.flightsearch.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.PaymentModel;
import com.flightsearch.model.TicketInfo;
import com.flightsearch.model.UserModel;
import com.flightsearch.service.PaymentService;
import com.flightsearch.service.UserService;

@Controller
@ComponentScan(basePackages = "com.flightsearch.service")
@SessionAttributes({ "user", "previousRequest", "selectedTicket" })
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping("/admin")
	public String goToAdmin(HttpSession session) {
		UserModel user = (UserModel) session.getAttribute("user");
		if (user == null) {
			return "loginForm";
		}

		if (user.isAdmin()) {
			return "adminPage";
		}
		return "index";
	}

	@RequestMapping(value = "/admin/users")
	public ModelAndView listUsers(ModelAndView model) throws IOException {
		List<UserModel> listUsers = userService.fetchUsers();
		model.addObject("listUsers", listUsers);
		model.setViewName("displayUsers");
		return model;
	}
	
	@RequestMapping(value = "/admin/orders")
	public ModelAndView listOrders(ModelAndView model) throws IOException {
		List<PaymentModel> listOrders = paymentService.fetchPayments();
		model.addObject("listOrders", listOrders);
		model.setViewName("displayOrders");
		return model;
	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView model) {
		UserModel newUser = new UserModel();
		model.addObject("newUser", newUser);
		model.setViewName("adminAddUserForm");
		return model;
	}
	
	@RequestMapping(value = "/admin/addOrder", method = RequestMethod.GET)
	public ModelAndView addOrder(ModelAndView model) {
		PaymentModel newOrder = new PaymentModel();
		model.addObject("newOrder", newOrder);
		model.setViewName("adminAddOrderForm");
		return model;
	}

	@RequestMapping(value = "/admin/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userID = Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(userService.fetchUserByID(userID));
		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value = "/admin/deleteOrder", method = RequestMethod.GET)
	public ModelAndView deleteOrder(HttpServletRequest request) {
		int orderID = Integer.parseInt(request.getParameter("id"));
		paymentService.delete(paymentService.fetchPaymentByID(orderID));
		return new ModelAndView("redirect:/admin/orders");
	}

	@RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, HttpSession session) {
		int userID = Integer.parseInt(request.getParameter("id"));
		UserModel userToUpdate = userService.fetchUserByID(userID);
		ModelAndView model = new ModelAndView("adminEditUserForm");
		model.addObject("userToUpdate", userToUpdate);
		model.addObject("updatedUser", userToUpdate);
		session.setAttribute("editUserID", userToUpdate.getId());
		
		return model;
	}
	
	@RequestMapping(value = "/admin/editOrder", method = RequestMethod.GET)
	public ModelAndView editOrder(HttpServletRequest request, HttpSession session) {
		int orderID = Integer.parseInt(request.getParameter("id"));
		PaymentModel paymentToUpdate = paymentService.fetchPaymentByID(orderID);
		ModelAndView model = new ModelAndView("adminEditOrderForm");
		model.addObject("paymentToUpdate", paymentToUpdate);
		model.addObject("updatedOrder", paymentToUpdate);
		session.setAttribute("editOrderID", paymentToUpdate.getId());
		
		return model;
	}

	@RequestMapping(value = "/admin/saveAddUser", method = RequestMethod.POST)
	public ModelAndView saveAddUser(@ModelAttribute("newUser") UserModel newUser) {
		newUser.setAdmin(false);
		userService.addUser(newUser);

		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value = "/admin/saveAddOrder", method = RequestMethod.POST)
	public ModelAndView saveAddOrder(@ModelAttribute("newOrder") PaymentModel newOrder) {
		paymentService.save(newOrder);

		return new ModelAndView("redirect:/admin/orders");
	}

	@RequestMapping(value = "/admin/saveEditUser",  method = RequestMethod.POST)
	public ModelAndView saveEditUser(@ModelAttribute("updatedUser") UserModel updatedUser, HttpSession session) {
		
		updatedUser.setId((int) session.getAttribute("editUserID"));
		userService.updateUser(updatedUser);
		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value = "/admin/saveEditOrder",  method = RequestMethod.POST)
	public ModelAndView saveEditOrder(@ModelAttribute("updatedOrder") PaymentModel updatedOrder, HttpSession session) {
		
		updatedOrder.setId((int) session.getAttribute("editOrderID"));
		paymentService.update(updatedOrder);
		return new ModelAndView("redirect:/admin/orders");
	}

}
