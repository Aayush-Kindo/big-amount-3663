package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.Buyer;
import model.Item;
import model.User;

public interface BuyerDao {
	  public String registerBuyer(Buyer buyer) throws SQLException;
	   public List<Item> getItemsByCategory(String category) throws SQLException;
	   public Map<User, List<Item>> getBuyersWithItems() throws SQLException;
	   
	  
}
