package org.example.models;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventory {

    private ItemShelf[] itemShelves;

    public Inventory() {
    }

    public void setItemShelves(ItemShelf[] itemShelves) {
        this.itemShelves = itemShelves;
    }

    public ItemShelf[] getItemShelves() {
        return itemShelves;
    }

    public Item getItem(int code){
        List<ItemShelf> itemShelfList = Arrays.stream(itemShelves).filter(itemShelf -> itemShelf.getCodeNum() == code)
                .filter(itemShelf -> itemShelf.isAvailable()).collect(Collectors.toList());
        return itemShelfList.get(0).getItem();
    }

    public void setNotAvailable(int code) {
        List<ItemShelf> itemShelfList = Arrays.stream(itemShelves).filter(itemShelf -> itemShelf.getCodeNum() == code)
                .filter(itemShelf -> itemShelf.isAvailable()).collect(Collectors.toList());
        ItemShelf itemShelf = itemShelfList.get(0);
        itemShelf.setAvailable(false);
    }
}
