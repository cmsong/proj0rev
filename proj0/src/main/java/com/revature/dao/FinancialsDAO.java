package com.revature.dao;

import java.util.List;

import com.revature.models.Financials;

public interface FinancialsDAO {
	public boolean makeOffer(int c_id, String user, double price);
	public Financials getOffer(int c_id, String user);
	public boolean acceptOffer(int c_id, String user);
	public List<Financials> viewOffers();
	public List<Financials> custViewPayments(String user);
	public List<Financials> empViewPayments();
	public boolean rejectOtherOffers(int c_id, String user);
	public boolean rejectOffer(int c_id, String user);
	public boolean removeAllOffer(int c_id);
}


