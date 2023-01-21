package dao;

import java.sql.SQLException;
import java.util.List;

import model.Dispute;
import model.Transaction;
import model.User;

public interface AdminDao {
    public List<User> getAllBuyerDetails()  ;
    public List<User> getAllSellers() ;
    public List<Dispute> getDailyDisputeReport() throws SQLException;
    public List<Transaction> getDailyTransactionReport() throws SQLException;
        
}
