package dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.masai.utility.DBUtil;

import model.Dispute;
import model.Transaction;
import model.User;

public class AdminDaoImpl implements AdminDao {

	@Override
	public List<User> getAllBuyerDetails() {
		// TODO Auto-generated method stub
		List<User> buyers = new ArrayList<>();
		try (Connection conn= DBUtil.provideConnection()){
			 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'buyer'");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("user_id");
	                String username = rs.getString("username");
	                buyers.add(new User(id, username));
			
	            }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			//message= e.getMessage();
		}
		return buyers;
	}

	@Override
	public List<User> getAllSellers() {
		// TODO Auto-generated method stub
		  List<User> sellers = new ArrayList<>();
		  try (Connection conn= DBUtil.provideConnection()){
				 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'seller'");
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		            	  int id = rs.getInt("user_id");
		                  String username = rs.getString("username");
		                  sellers.add(new User(id, username));
		              
				
		            }
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		  
		return sellers;
	}

	@Override
	public List<Dispute> getDailyDisputeReport() throws SQLException {
		List<Dispute>disputes=new ArrayList<>();
		
		  try (Connection conn= DBUtil.provideConnection()){
			  String query = "SELECT * FROM disputes WHERE DATE(dispute_date) = CURDATE()";
		        PreparedStatement statement = conn.prepareStatement(query);
		        ResultSet resultSet = statement.executeQuery();
		       
		        while (resultSet.next()) {
		            int i = resultSet.getInt("dispute_id");
		            int t = resultSet.getInt("transaction_id");
		            String dR = resultSet.getString("dispute_reason");
		            Date disputeDate = resultSet.getDate("dispute_date");
		            String s = resultSet.getString("status");
		            Dispute dispute=new Dispute();
		            dispute.setDisputeId(i);
		            dispute.setTransactionId(t);
		            dispute.setDisputeReason(dR);
		            dispute.setStatus(s);
		            dispute.setDisputeDate(disputeDate);
		            
		            disputes.add(dispute);
		            
		        }
		        
				
			} catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		
		// TODO Auto-generated method stub
		return disputes;
	}

	@Override
	public List<Transaction> getDailyTransactionReport() throws SQLException {
		// TODO Auto-generated method stub
		 List<Transaction> transactions = new ArrayList<>();
		  try (Connection conn= DBUtil.provideConnection()){
			  String query = "SELECT * FROM transactions WHERE DATE(transaction_date) = CURDATE()";
				 PreparedStatement stmt = conn.prepareStatement(query);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		            	
		            	   int transactionId = rs.getInt("transaction_id");
		                   int buyerId = rs.getInt("buyer_id");
		                   int itemId = rs.getInt("item_id");
		                   double price = rs.getDouble("price");
		                   Date transactionDate = rs.getDate("transaction_date");
		                   int quantity = rs.getInt("quantity");
		                   transactions.add(new Transaction(transactionId, buyerId, itemId, price, transactionDate, quantity));
				
		            }
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		 
		return transactions;
	}

	

	
		
	}

