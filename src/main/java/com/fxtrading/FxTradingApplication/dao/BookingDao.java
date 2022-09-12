package com.fxtrading.FxTradingApplication.dao;
import com.fxtrading.FxTradingApplication.entity.Book;

import org.springframework.stereotype.Repository;

@Repository
public class BookingDao {
	//Booking the trade
	
	public String bookTrade(Book BookingDetails, String bookingConfirmation) {

		
		
		if(BookingDetails.getCustomerName().matches("[a-zA-Z\\s\\.].*$")) {
			
		if (BookingDetails.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			final double rateOfUsd = 66.00;
			
			double inrAmount = rateOfUsd * BookingDetails.getTranferAmount();
			if(BookingDetails.getRate().equalsIgnoreCase("yes")) {
				
				if(bookingConfirmation.equalsIgnoreCase("book")) {
					
					PrintDao.tradeNo++;
					PrintDao printdao = new PrintDao();
					printdao.addTrading(PrintDao.tradeNo ,BookingDetails.getCurrencyPair(),BookingDetails.getCustomerName() , inrAmount, rateOfUsd);
					
					return "you are transferring INR " + inrAmount + " to " + BookingDetails.getCustomerName()+".(Assuming that rate was 66.00)"+"\n"+
				"Trade for " + BookingDetails.getCurrencyPair() + " has been booked with rate " + rateOfUsd + " , The amount of Rs."+ inrAmount +
				" will be transferred in 2 days to " + BookingDetails.getCustomerName() + "\n";

			}
			else if (bookingConfirmation.equalsIgnoreCase("cancel")) {
				return "The trade is cancelled";
			} else {
				return "invalid option";
			}
			}
			else if(BookingDetails.getRate().equalsIgnoreCase("no")) {
				if(bookingConfirmation.equalsIgnoreCase("book")) {
					PrintDao.tradeNo++;
					
					PrintDao printdao = new PrintDao();
					printdao.addTrading(PrintDao.tradeNo ,BookingDetails.getCurrencyPair(),BookingDetails.getCustomerName() , inrAmount, rateOfUsd);
					
	
				return  "Trade for " + BookingDetails.getCurrencyPair() + " has been booked with rate " + rateOfUsd + " , The amount of Rs."+ inrAmount +
						" will be transferred in 2 days to " + BookingDetails.getCustomerName() + "\n";

			}
			else if (bookingConfirmation.equalsIgnoreCase("cancel")) {
				
				return "The trade is cancelled";
				
				
			} else {
				
				return "Invalid option ....";
			}
			}

			else {
				return "invalid input";
			}

		} else {
			return "Invalid data!!!...Try again...";
			
		}

	}
		else {
			return "Invalid Customer name ...Try again";
			
			
		}
}
	
}