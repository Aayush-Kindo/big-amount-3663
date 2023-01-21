package usecases;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.BuyerDao;
import dao.BuyerDaoImpl;
import model.Buyer;
import model.Item;
import model.User;

public class BuyerUsecase {
	public static void main(String[] args) throws SQLException {
		BuyerDao buyerDao=new BuyerDaoImpl();
		
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Register a Buyer");
		
		System.out.println("Enter name");
		String name=scn.next();
		System.out.println("Enter Password");
		String password=scn.next();
		
		Buyer buyer = new Buyer(name,password,"buyer");
		String msg=buyerDao.registerBuyer(buyer);
		System.out.println(msg);
		
		//serach item by categort first enter category
//		  List<Item> items = buyerDao.getItemsByCategory("Electronics");
//	        for (Item item : items) {
//	            System.out.println("Item ID: " + item.getItemId());
//	            System.out.println("Seller ID: " + item.getSellerId());
//	            System.out.println("Name: " + item.getName());
//	            System.out.println("Category: " + item.getCategory());
//	            System.out.println("Price: " + item.getPrice());
//	            System.out.println("Quantity: " + item.getQuantity());
//	            System.out.println();
//	        }
		
		
		// Select and view all the buyers and also their Items category wise.
		
		
		  Map<User, List<Item>> buyersWithItems = buyerDao.getBuyersWithItems();
	        for (Map.Entry<User, List<Item>> entry : buyersWithItems.entrySet()) {
	            User buyer1 = entry.getKey();
	        
	            System.out.println("Buyer ID: " + buyer1.getId());
	            System.out.println("Name: " + buyer1.getUsername());
	           
	            System.out.println("Items:");
	            for (Item item : entry.getValue()) {
	                System.out.println("  Item ID: " + item.getItemId());
	                System.out.println("  Name: " + item.getName());
	                System.out.println("  Category: " + item.getCategory());
	                System.out.println("  Price: " + item.getPrice());
	                System.out.println("  Quantity: " + item.getQuantity());
	            }
	            System.out.println();
	        }
		
		
	}
}
