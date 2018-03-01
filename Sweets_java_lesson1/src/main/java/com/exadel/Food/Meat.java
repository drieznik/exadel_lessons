package com.exadel.Food;

import com.exadel.Human;

import java.util.*;

public class Meat extends Food {

     MeatType type;

    public Meat(MeatType type, int weight){
        this.type = type;
        this.weight = weight;
    }

    @Override
    public boolean canHumanEatIt(Human human) {
        setCalories(type.calories);
        switch (type){
            case PORK:  return (!human.isOnDiet() && !human.isVegan());
            case CHICKEN:  return (!human.isVegan());
            case BEEF: return (!human.isVegan());
        }
       return !human.isVegan();
    }

    @Override
    public String toString() {
        return type.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meat)) return false;
        Meat meat = (Meat) o;
        return type == meat.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type);
    }
}
