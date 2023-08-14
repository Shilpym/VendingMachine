package org.example.states;

import org.example.models.Coin;
import org.example.models.Item;
import org.example.models.ItemShelf;
import org.example.models.VendingMachine;

public class SelectionState extends State{

    public SelectionState() {
        System.out.println(" Machine in product selection state...");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) {
       Item item = vendingMachine.getInventory().getItem(code);
       System.out.println("Request received for product : "+ item.getItemType());
       if(item == null){
           System.out.println("Item unavailable");
           return;
       }
       int paidMoney = 0;
       for(Coin coin: vendingMachine.getCoins()){
           paidMoney += coin.value;
       }
       if(paidMoney < item.getPrice()){
           System.out.println("Insufficient money");
           refundFullMoney(vendingMachine);
           return;
       }
       if(paidMoney > item.getPrice()){
           returnChange(paidMoney - item.getPrice());
       }
       vendingMachine.setVendingMachineState(new DispensingState(vendingMachine, code));
    }

    @Override
    public void returnChange(int extraMoney) {
        System.out.println("Extra money returned "+ extraMoney);
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
       vendingMachine.moneySpent();
       vendingMachine.setVendingMachineState(new  IdleState(vendingMachine));
       System.out.println("Please collect ur money");
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        super.pressCancelButton(vendingMachine);
    }
}
