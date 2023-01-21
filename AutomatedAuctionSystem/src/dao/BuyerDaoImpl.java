package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.masai.utility.DBUtil;

import model.Buyer;
import model.Item;
import model.User;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) throws SQLException {
		// TODO Auto-generated method stub
		String msg="Not Registered";
		try (Connection conn= DBUtil.provideConnection()){
			 String query = "INSERT INTO users (username,  password, role) VALUES (?,?,?)";
		        PreparedStatement statement = conn.prepareStatement(query);
		        statement.setString(1, buyer.getUserName());
		       
		        statement.setString(2, buyer.getPassword());
		        statement.setString(3, buyer.getRole());
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
	public List<Item> getItemsByCategory(String category) throws SQLException {
		// TODO Auto-generated method stub
		  List<Item> items = new ArrayList<>();
		  try (Connection conn= DBUtil.provideConnection()){
			  
			  String query = "SELECT * FROM items WHERE category = ?";
			  PreparedStatement statement = conn.prepareStatement(query);
		        statement.setString(1, category);
		        ResultSet resultSet = statement.executeQuery();
		       
		        while (resultSet.next()) {
		            int itemId = resultSet.getInt("item_id");
		            int sellerId = resultSet.getInt("seller_id");
		            String name = resultSet.getString("name");
		            double price = resultSet.getDouble("price");
		            int quantity = resultSet.getInt("quantity");
		            Item item = new Item(itemId, sellerId, name, category, price, quantity);
		            items.add(item);
				
			} 
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}

		  
		return items;
	}

	@Override
	public Map<User, List<Item>> getBuyersWithItems() throws SQLException {
		// TODO Auto-generated method stub
		 Map<User, List<Item>> buyersWithItems = new HashMap<>();
		 try (Connection conn= DBUtil.provideConnection()){
			  
			  String query = "SELECT * FROM users WHERE role = 'buyer'";
			  PreparedStatement statement = conn.prepareStatement(query);
		       
		        ResultSet rs = statement.executeQuery();
		       
		        while (rs.next()) {
		        	int userId = rs.getInt("user_id");
		            String userName = rs.getString("username");
		            
		            User buyer = new User(userId,userName);
		            
		            String itemQuery = "SELECT * FROM items WHERE seller_id = ?";
		            PreparedStatement itemStmt = conn.prepareStatement(itemQuery);
		            itemStmt.setInt(1, userId);
		            ResultSet itemResult = itemStmt.executeQuery();
		            List<Item> items = new ArrayList<>();
		            while (itemResult.next()) {
		                int itemId = itemResult.getInt("item_id");
		                int sellerId = itemResult.getInt("seller_id");
		                String name = itemResult.getString("name");
		                String category = itemResult.getString("category");
		                double price = itemResult.getDouble("price");
		                int quantity = itemResult.getInt("quantity");
		                Item item = new Item(itemId, sellerId, name, category, price, quantity);
		                items.add(item);
		            }
		            buyersWithItems.put(buyer, items);
				
			} 
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		 
		return buyersWithItems;
	}

}
