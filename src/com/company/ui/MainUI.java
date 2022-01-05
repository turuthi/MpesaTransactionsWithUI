package com.company.ui;

import com.company.logic.PaidTo;
import com.company.logic.Receivables;
import com.company.logic.Sents;
import com.company.logic.Withdrawals;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JPanel rootPanel;
    private JTextField txtMpesaText;
    private JButton btnEnterText;
    private JTable transactionsTable;

    public MainUI (){
        createTable();
        btnEnterText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    //Create a table where transactions will be shown
    private void createTable() {
        transactionsTable.setModel(new DefaultTableModel(
                null,
                new String[] {"Transaction Type","Agent/Person/Business", "Amount", "Date", "Time"}
        ));
    }

    private void addTransaction() {
        //get the text
        String mpesaText = txtMpesaText.getText();
        //check the kind of the Mpesa text;
        checkTransaction(mpesaText);
    }

    private void checkTransaction(String mpesaText) {
        //check what type of transaction it is and return its details.

        if (mpesaText.contains("Withdraw")){

            Withdrawals withDrawals = new Withdrawals(mpesaText);
            String transactionType = withDrawals.getTransactionType();
            String entity = withDrawals.getEntity();
            String amount = withDrawals.withdrawalAmount(withDrawals.withdrawalText);
            String time = withDrawals.withdrawalTime(withDrawals.withdrawalText);
            String date = withDrawals.withdrawalDate(withDrawals.withdrawalText);

            DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{
                    transactionType, entity, amount, time, date
            });
            TableColumnModel columns = transactionsTable.getColumnModel();
            columns.getColumn(1).setMinWidth(200);

            DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
            centerRender.setHorizontalAlignment(JLabel.CENTER);
            columns.getColumn(0).setCellRenderer(centerRender);
            columns.getColumn(2).setCellRenderer(centerRender);
            columns.getColumn(3).setCellRenderer(centerRender);
            columns.getColumn(4).setCellRenderer(centerRender);


        } else if (mpesaText.contains("received")) {
            //check if the transaction message is a receivable and show the entity and amount
            if (mpesaText.contains("received")) {

                Receivables receivables = new Receivables(mpesaText);

                String transactionType = receivables.getTransactionType();
                String entity = receivables.getEntity();
                String amount = receivables.receivedAmount(receivables.receiveText);
                String date = receivables.receivedDate(receivables.receiveText);
                String time = receivables.receivedTime(receivables.receiveText);

                DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{
                        transactionType, entity, amount, time, date
                });
                TableColumnModel columns = transactionsTable.getColumnModel();
                columns.getColumn(1).setMinWidth(200);

                DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
                centerRender.setHorizontalAlignment(JLabel.CENTER);
                columns.getColumn(0).setCellRenderer(centerRender);
                columns.getColumn(2).setCellRenderer(centerRender);
                columns.getColumn(3).setCellRenderer(centerRender);
                columns.getColumn(4).setCellRenderer(centerRender);

            }
        } else if (mpesaText.contains("paid to")){
            //Get the details of the transaction

                PaidTo paidTo = new PaidTo(mpesaText);
                String transactionType = paidTo.getTransactionType();
                String entity = paidTo.getEntity();
                String amount = paidTo.paidAmount(paidTo.paidToText);
                String time = paidTo.paidTime(paidTo.paidToText);
                String date = paidTo.paidDate(paidTo.paidToText);

                DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{
                        transactionType, entity, amount, date, time
                });
                TableColumnModel columns = transactionsTable.getColumnModel();
                columns.getColumn(1).setMinWidth(200);

                DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
                centerRender.setHorizontalAlignment(JLabel.CENTER);
                columns.getColumn(0).setCellRenderer(centerRender);
                columns.getColumn(2).setCellRenderer(centerRender);
                columns.getColumn(3).setCellRenderer(centerRender);
                columns.getColumn(4).setCellRenderer(centerRender);

        } else{
            if (mpesaText.contains("sent to")){

                    Sents sents = new Sents(mpesaText);
                    String transactionType = sents.getTransactionType();
                    String entity = sents.getEntity();
                    String amount = sents.sentAmount(sents.sentText);
                    String time = sents.sentTime(sents.sentText);
                    String date = sents.sentDate(sents.sentText);

                    DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
                    tableModel.setRowCount(0);
                    tableModel.addRow(new Object[]{
                            transactionType, entity, amount, date, time
                    });
                    TableColumnModel columns = transactionsTable.getColumnModel();
                    columns.getColumn(1).setMinWidth(200);

                    DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
                    centerRender.setHorizontalAlignment(JLabel.CENTER);
                    columns.getColumn(0).setCellRenderer(centerRender);
                    columns.getColumn(2).setCellRenderer(centerRender);
                    columns.getColumn(3).setCellRenderer(centerRender);
                    columns.getColumn(4).setCellRenderer(centerRender);
            }
        }

    }
}
