package model;

import java.sql.Date;

public class Dispute {
    private int disputeId;
    private int transactionId;
    private String disputeReason;
    private Date disputeDate;
    private String status;

    public Dispute(int disputeId, int transactionId, String disputeReason, Date disputeDate, String status) {
        this.disputeId = disputeId;
        this.transactionId = transactionId;
        this.disputeReason = disputeReason;
        this.disputeDate = disputeDate;
        this.status = status;
    }
    public Dispute () {
    	
    }

    public int getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(int disputeId) {
        this.disputeId = disputeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getDisputeReason() {
        return disputeReason;
    }

    public void setDisputeReason(String disputeReason) {
        this.disputeReason = disputeReason;
    }

    public Date getDisputeDate() {
        return disputeDate;
    }

    public void setDisputeDate(Date disputeDate) {
        this.disputeDate = disputeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

