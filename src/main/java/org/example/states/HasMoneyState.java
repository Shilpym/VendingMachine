package org.example.states;

import org.example.models.VendingMachine;

public class HasMoneyState extends State{

    public HasMoneyState() {
    System.out.println("Insert money...");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int coin) {
       System.out.println("Money received : "+ coin);
        vendingMachine.addMoney(coin);
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new SelectionState());
        System.out.println("Enter code for required product...");
    }
}
