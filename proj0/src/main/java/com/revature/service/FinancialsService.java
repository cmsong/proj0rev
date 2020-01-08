package com.revature.service;

import java.util.List;

import com.revature.dao.FinancialsDAO;
import com.revature.dao.FinancialsDAOimpl;
import com.revature.models.Financials;

public class FinancialsService {
	public static FinancialsDAO fd = new FinancialsDAOimpl();
	
	public static boolean makeOffer(int c_id, String user, double price) {
		return fd.makeOffer(c_id, user, price);
	}
	public static boolean acceptOffer(int c_id, String user) {
		return fd.acceptOffer(c_id, user);
	}
	public static List<Financials> viewOffers() {
		return fd.viewOffers();
	}
	public static List<Financials> custViewPayments(String user) {
		return fd.custViewPayments(user);
	}
	public static boolean rejectOtherOffers(int c_id, String user) {
		return fd.rejectOtherOffers(c_id, user);
	}
	public static Financials getOffer(int c_id, String user) {
		return fd.getOffer(c_id, user);
	}
	public static boolean rejectOffer(int c_id, String user) {
		return fd.rejectOffer(c_id, user);
	}
	public static List<Financials> empViewPayments() {
		return fd.empViewPayments();
	}
	public static boolean removeAllOffer(int c_id) {
		return fd.removeAllOffer(c_id);
	}
}
