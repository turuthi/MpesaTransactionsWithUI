package com.company.logic;

public class Withdrawals {
    public String withdrawalText;

    private String transactionType;
    private String entity;


    public Withdrawals(String withdrawalText) {

        this.withdrawalText = withdrawalText;

        int startEntityIndex = withdrawalText.indexOf("-")+2;
        int endEntityIndex = withdrawalText.indexOf("New")-1;

        transactionType = "Withdrawal";
        entity = withdrawalText.substring(startEntityIndex, endEntityIndex);
    }

    //Extract the amount
    public String withdrawalAmount(String withdrawalText){
        int start = withdrawalText.indexOf("Ksh");
        int end = withdrawalText.indexOf("from")-1;
        String amount = withdrawalText.substring(start, end);

        return amount;
    }

    //Extract the date
    public String withdrawalDate(String withdrawalText){
        int start = withdrawalText.indexOf(".on ")+4;
        int end = withdrawalText.indexOf(" at ");

        String dateString = withdrawalText.substring(start, end);
        return dateString;
    }

    //Extract the time
    public String withdrawalTime(String withdrawalText){
        int start = withdrawalText.indexOf("at")+3;
        int end = withdrawalText.indexOf("Withdraw ");

        String timeString = withdrawalText.substring(start, end);
        return timeString;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEntity() {
        return entity;
    }

}
