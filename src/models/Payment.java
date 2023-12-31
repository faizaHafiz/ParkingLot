package models;

import java.util.Date;

public class Payment {
    private PaymentMode paymentMode;
    private int amount;
    private Date time;
    private PaymentStatus paymentStatus;
    private String referenceNUmber;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReferenceNUmber() {
        return referenceNUmber;
    }

    public void setReferenceNUmber(String referenceNUmber) {
        this.referenceNUmber = referenceNUmber;
    }
}
