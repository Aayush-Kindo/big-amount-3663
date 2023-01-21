package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.utility.DBUtil;

import model.Item;
import model.Seller;

public class SellerDaoImpl implements SellerDao {

	@Override
	public String registerSeller(Seller seller) throws SQLException {
		// TODO Auto-generated method stub
		String msg="Not Registered";
		try (Connection conn= DBUtil.provideConnection()){
			 String query = "INSERT INTO users (username,  password, role) VALUES (?,?,?)";
		        PreparedStatement statement = conn.prepareStatement(query);
		        statement.setString(1, seller.getUserName());
		       
		        statement.setString(2, seller.getPassword());
		        statement.setString(3, seller.getRole());
		        int rowsAffected = statement.executeUpdate();
		        if(rowsAffected==1) {
		        	return "Sucessfully Registerd";
		        }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			//message= e.getMessage();
		}
		return msg;
		
	}

	@Override
	public boolean createItem(Item item) throws SQLException {
		 boolean res=false;
		// TODO Auto-generated method stub
		 try (Connection conn= DBUtil.provideConnection()){
			  String query = "INSERT INTO items (seller_id, name, category, price, quantity) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement stmt = conn.prepareStatement(query);
		        stmt.setInt(1, item.getSellerId());
		        stmt.setString(2, item.getName());
		        stmt.setString(3, item.getCategory());
		        stmt.setDouble(4, item.getPrice());
		        stmt.setInt(5, item.getQuantity());
		        int rowsAffected = stmt.executeUpdate();
		        if(rowsAffected==1) {
		        	return true;
		        }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			//message= e.getMessage();
		}
		return res;
	}

	@Override
	public boolean updateItem(Item item) throws SQLException {
		// TODO Auto-generated method stub
		boolean res=false;
		 try (Connection conn= DBUtil.provideConnection()){
			 String query = "UPDATE items SET name = ?, category = ?, price = ?, quantity = ? WHERE item_id = ?";
			 PreparedStatement stmt = conn.prepareStatement(query);
		        stmt.setString(1, item.getName());
		        stmt.setString(2, item.getCategory());
		        stmt.setDouble(3, item.getPrice());
		        stmt.setInt(4, item.getQuantity());
		        stmt.setInt(5, item.getItemId());
		        System.out.println( item.getItemId());
		        int rowsAffected = stmt.executeUpdate();
		      //  System.out.println(rowsAffected);
		        
		        if(rowsAffected==1) {
		        	return true;
		        }
			
		} catch (SQLException e) {
			e.printStackTrace();
			//message= e.getMessage();
		}
		return res;
	}

	
	

}
