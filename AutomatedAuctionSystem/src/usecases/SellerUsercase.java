package usecases;

import java.sql.SQLException;
import java.util.Scanner;


import dao.SellerDao;
import dao.SellerDaoImpl;
import model.Item;
import model.Seller;

public class SellerUsercase {
	public static void main(String[] args) throws SQLException {
		SellerDao sellerDao=new SellerDaoImpl();
		
		Scanner scn=new Scanner(System.in);
//		
//		System.out.println("Register a Seller");
//		
//		System.out.println("Enter name");
//		String name=scn.next();
//		System.out.println("Enter Password");
//		String password=scn.next();
//		
//		Seller seller = new Seller(name,password,"seller");
//		String msg=sellerDao.registerSeller(seller);
//		System.out.println(msg); 
		
		
		// add item
//		System.out.println("Enter seller id");
//		int seller_id=scn.nextInt();
//		
//		System.out.println("Enter item name");
//		String p_name=scn.next();
//		
//		System.out.println("Enter category name");
//		String p_category=scn.next();
//		
//		System.out.println("Enter price");
//		double p_price=scn.nextDouble();
//		
//		System.out.println("Enter quantity");
//		int p_quantity=scn.nextInt();
//		
//		Item item = new Item( seller_id,p_name, p_category, p_price, p_quantity);
//		 boolean success = sellerDao.createItem(item);
//		 if (success) {
//	            System.out.println("Item added successfully");
//	        } else {
//	            System.out.println("Failed to add item");
//	        }
		
		 
		 //update item 
		System.out.println("Update Item");
		System.out.println("Enter item id");
		int u_id=scn.nextInt();
		System.out.println("Enter seller id");
		int u_sid=scn.nextInt();
		System.out.println("Enter  name");
		String u_name=scn.next();
		System.out.println("enter category name");
		String u_category=scn.next();
		System.out.println("enter  price");
		int u_price=scn.nextInt();
		System.out.print("enter category quantity");
		int u_q=scn.nextInt();
		
		
		
		 
		   Item item1 = new Item(u_id,u_sid, u_name, u_category, u_price, u_q);
	        boolean success1 = sellerDao.updateItem(item1);
	        if (success1) {
	            System.out.println("Item updated successfully");
	        } else {
	            System.out.println("Failed to update item");
	        }
		 
		
		
		
		
		
		
		
		
		
		
	}
}
