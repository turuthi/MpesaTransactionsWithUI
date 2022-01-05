package com.company.logic;

public class Sents {
    public String sentText;

    private String transactionType;
    private String entity;


    public Sents (String sentText) {

        this.sentText = sentText;

        int startEntityIndex = this.sentText.indexOf("to")+2;
        int endEntityIndex = this.sentText.indexOf(" on")-1;

        transactionType = "Sent";
        entity = this.sentText.substring(startEntityIndex, endEntityIndex);
    }

    //Extract the amount
    public String sentAmount(String sentText){
        int start = sentText.indexOf("Ksh");
        int end = sentText.indexOf("sent")-1;
        String amount = sentText.substring(start, end);

        return amount;
    }

    //Extract the date
    public String sentDate(String sentText){
        int start = sentText.indexOf(" on ")+3;
        int end = sentText.indexOf(" at ");

        String dateString = sentText.substring(start, end);
        return dateString;
    }

    //Extract the time
    public String sentTime(String sentText){
        int start = sentText.indexOf("at")+3;
        int end = sentText.indexOf(". New");

        String timeString = sentText.substring(start, end);
        return timeString;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEntity() {
        return entity;
    }

}
