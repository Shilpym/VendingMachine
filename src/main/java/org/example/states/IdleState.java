package org.example.states;

import org.example.models.VendingMachine;

public class IdleState extends State{

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Machine in Idle state");
        vendingMachine.moneySpent();
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) {
        System.out.println("Insert coin btn pressed...");
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }
}
