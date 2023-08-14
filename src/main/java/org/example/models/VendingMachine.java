package org.example.models;

import org.example.states.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VendingMachine {

    private State state;

    private Inventory inventory;

    private List<Coin> coins;

    public VendingMachine() {
        fillUpVendingMachine();
    }

    public void setVendingMachineState(State state){
        this.state = state;
    }

    public void addMoney(int money){
        Optional<Coin> coinOptional = Arrays.stream(Coin.values()).filter(coin1 -> coin1.value == money).findAny();
        coinOptional.ifPresentOrElse(coin -> this.coins.add(coin), () -> System.out.println("Wrong denomination"));
    }

    public void moneySpent() {
        this.coins = new ArrayList<>();
    }

    public State getState() {
        return state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    private void fillUpVendingMachine(){
        inventory = new Inventory();
        ItemShelf[] itemShelves = new ItemShelf[9];
        for(int i=0;i<9;i++){
            ItemShelf itemShelf;
        if(i%2==0){
            itemShelf = new ItemShelf(100 + i, new Item(ItemType.CHIPS, 20));
        }
        else if(i%3==0){
            itemShelf = new ItemShelf(100 + i, new Item(ItemType.CHOCLATE, 65));
        }
        else {
            itemShelf = new ItemShelf(100 + i, new Item(ItemType.NAACHOS, 40));
        }
        itemShelves[i] = itemShelf;
        }
        inventory.setItemShelves(itemShelves);
    }

    public void displayVendingMachine(){
        int size = inventory.getItemShelves().length;
        ItemShelf[] itemShelves = inventory.getItemShelves();
        System.out.println("||========================||===========================||=========================||");
        for(int i=0;i<size;i++){
            System.out.println("|| Code : " + itemShelves[i].getCodeNum() + " || Item Type : "+ itemShelves[i].getItem().getItemType() +" || Price : " + itemShelves[i].getItem().getPrice() + " || Is Item Available : "+ itemShelves[i].isAvailable());
            System.out.println("||========================||===========================||=========================||");
        }
    }
}
