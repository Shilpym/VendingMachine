package org.example.states;

import org.example.models.Item;
import org.example.models.VendingMachine;

public class DispensingState extends State{

    public DispensingState(VendingMachine vendingMachine, int code) {
        dispenseProduct(vendingMachine, code);
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int code) {
        Item item = vendingMachine.getInventory().getItem(code);
        System.out.println("Item "+ item.getItemType() + " has been dispensed...");
        vendingMachine.getInventory().setNotAvailable(code);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

}
