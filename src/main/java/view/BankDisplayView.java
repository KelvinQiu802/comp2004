package view;

import model.Bank;

public class BankDisplayView {
    /***
     * A method to print all cards in the bank
     * @param bank bank
     */
    public static void printBank(Bank bank) {
        CardDisplayView.printCard(bank.getBankCards());
    }
}
