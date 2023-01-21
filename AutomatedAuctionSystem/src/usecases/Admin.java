package usecases;

import java.sql.SQLException;
import java.util.List;

import dao.AdminDao;
import dao.AdminDaoImpl;
import model.Dispute;
import model.Transaction;
import model.User;

public class Admin {
	public static void main(String[] args) throws SQLException {
		 AdminDao admin = new AdminDaoImpl();

	        // Get the list of registered buyers
	        List<User> buyers =admin.getAllBuyerDetails();
	        // Print the list of registered buyers
	        for (User buyer : buyers) {
	            System.out.println("User ID: " + buyer.getId());
	            System.out.println("Username: " + buyer.getUsername());
	            System.out.println();
	        }
	        
	     // Get the list of registered sellers
	        List<User> sellers = admin.getAllSellers();

	        // Print the list of registered sellers
	        for (User seller : sellers) {
	            System.out.println("User ID: " + seller.getId());
	            System.out.println("Username: " + seller.getUsername());
	            System.out.println();
	        }
	        
	        List<Dispute> dailyDisputeReport = admin.getDailyDisputeReport();
	        for (Dispute dispute : dailyDisputeReport) {
	            System.out.println("Dispute ID: " + dispute.getDisputeId());
	            System.out.println("Transaction ID: " + dispute.getTransactionId());
	            System.out.println("Dispute Reason: " + dispute.getDisputeReason());
	            System.out.println("Dispute Date: " + dispute.getDisputeDate());
	            System.out.println("Status: " + dispute.getStatus());
	            System.out.println("-------------------");
	        }
	        
	        List<Transaction> dailyTransactionReport = admin.getDailyTransactionReport();
	        for (Transaction transaction : dailyTransactionReport) {
	            System.out.println("Transaction ID: " + transaction.getTransactionId());
	            System.out.println("Buyer ID: " + transaction.getBuyerId());
	            System.out.println("Item ID: " + transaction.getItemId());
	            System.out.println("Price: " + transaction.getPrice());
	            System.out.println("Transaction Date: " + transaction.getTransactionDate());
	            System.out.println("Quantity: " + transaction.getQuantity());
	            System.out.println("-------------------");
	        }

	        
	        
	        
	        
	        
	}
}
