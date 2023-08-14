package org.example;

import org.example.models.VendingMachine;
import org.example.states.IdleState;
import org.example.states.State;

public class VendingMachineApplication {
    public static void main(String[] args) {

        System.out.println("Hiee, Please use the Vending Machine!");
        VendingMachine vm = new VendingMachine();
        vm.displayVendingMachine();
        vm.setVendingMachineState(new IdleState(vm));
        State state = vm.getState();
        state.pressInsertCoinButton(vm);
        state = vm.getState();
        state.insertMoney(vm,10);
        state.insertMoney(vm, 20);
        state.insertMoney(vm, 10);
        state.insertMoney(vm, 2);
        state.pressProductSelectionButton(vm);
        state = vm.getState();
        state.chooseProduct(vm, 103);
    }
}