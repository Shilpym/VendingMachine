package org.example.models;

public class ItemShelf {

    private  int codeNum;

    private Item item;

    private boolean isAvailable;

    public ItemShelf(int codeNum, Item item) {
        this.codeNum = codeNum;
        this.item = item;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Item getItem() {
        return item;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCodeNum() {
        return codeNum;
    }

}
