package com.exadel.Food;

public enum MeatType {
    CHICKEN(100), BEEF(150), PORK(300);

    public int calories;

    MeatType(int cal){
        calories = cal;
    }
}
