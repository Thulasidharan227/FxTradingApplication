package com.fxtrading.FxTradingApplication.service;

import java.util.ArrayList;

import com.fxtrading.FxTradingApplication.dao.BookingDao;
import com.fxtrading.FxTradingApplication.dao.PrintDao;
import com.fxtrading.FxTradingApplication.entity.Book;
import com.fxtrading.FxTradingApplication.entity.Print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FxTradingService {
@Autowired
BookingDao bookingDao;
@Autowired
PrintDao printDao;

public String bookTrade(Book BookingDetails, String bookingConfirmation) {
	return bookingDao.bookTrade(BookingDetails, bookingConfirmation);
	
}

public ArrayList<Print> printTrading() {
	return printDao.printTrading();
	
}
}
