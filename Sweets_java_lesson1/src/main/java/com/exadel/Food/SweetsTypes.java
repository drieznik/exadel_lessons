package com.exadel.Food;

public enum SweetsTypes {

    SNIKERS(200), CHOCOLATE(300), RASIN(100);
    public int calories;

    SweetsTypes(int calories){
        this.calories = calories;
    }
}
