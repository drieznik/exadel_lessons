package com.exadel.Food;

public abstract class Food implements EatFood {

    int calories;
    int weight;
    String type;
    int caloriesPerPortion;

    public void setCalories(int calories) {
        this.calories = calories;
        caloriesPerPortion = calories*weight/100;
    }

    public int getCaloriesPerPortion() {
        return caloriesPerPortion;
    }

    public int getWeight() {
        return weight;
    }

    public Food(){}

}
