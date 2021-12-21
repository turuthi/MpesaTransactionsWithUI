package com.company.logic;

public class Receivables {
    public String receiveText;

    private final String transactionType;
    private final String entity;



        public Receivables(String receiveText) {

            this.receiveText = receiveText;

            int startEntityIndex = receiveText.indexOf("from")+5;
            int endEntityIndex = receiveText.indexOf(" on ");

            transactionType = "Receive";
            entity = receiveText.substring(startEntityIndex, endEntityIndex);
            System.out.println("You have received from " + entity);
        }

        //Derive the amount received
        public String receivedAmount(String receiveText){
            int start = receiveText.indexOf("Ksh");
            int end = receiveText.indexOf("from")-1;
            String amount = receiveText.substring(start, end);
            return amount;
        }

        //Derive the date
        public String receivedDate(String withdrawalText){
            int start = withdrawalText.indexOf(" on ")+4;
            int end = withdrawalText.indexOf(" at ");

            String dateString = withdrawalText.substring(start, end);

            return dateString;
        }

        //Extract the time
        public String receivedTime(String withdrawalText){
            int start = withdrawalText.indexOf("at")+3;
            int end = withdrawalText.indexOf(" New ");

            String dateString = withdrawalText.substring(start, end);

            return dateString;
        }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEntity() {
        return entity;
    }
    }
