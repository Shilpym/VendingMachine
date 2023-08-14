package org.example.states;

import org.example.VendingMachineApplication;
import org.example.models.Item;
import org.example.models.VendingMachine;

public abstract class State {

    public void pressInsertCoinButton(VendingMachine vendingMachine) {
        // to be impl
    }

    public void insertMoney(VendingMachine vendingMachine, int coin){
        // to be impl
    }

    public void pressProductSelectionButton(VendingMachine vendingMachine){
        // to be impl
    }

    public void chooseProduct(VendingMachine vendingMachine, int code){
        // to be impl
    }

    public void pressCancelButton(VendingMachine vendingMachine){
        // to be impl
    }

    public void returnChange(int extraMoney){
        // to be impl
    }

    public void dispenseProduct(VendingMachine vendingMachine, int code){

    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber){

    }

    public void refundFullMoney(VendingMachine vendingMachine){

    }
}
