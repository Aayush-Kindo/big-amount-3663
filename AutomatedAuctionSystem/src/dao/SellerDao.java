package dao;

import java.sql.SQLException;

import model.Item;
import model.Seller;

public interface SellerDao {
	 public String registerSeller(Seller seller) throws SQLException;
	 boolean createItem(Item item) throws SQLException;
	  boolean updateItem(Item item) throws SQLException;
}
