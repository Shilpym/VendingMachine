package org.example.models;

public enum Coin {

    ONE(1),

    TWO (2),

    FIVE(5),

    TEN(10);

    public int value;

    Coin(int sum) {
    this.value = sum;
    }
}
