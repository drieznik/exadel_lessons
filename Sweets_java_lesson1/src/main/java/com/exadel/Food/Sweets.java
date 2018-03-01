package com.exadel.Food;

import com.exadel.Human;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sweets extends Food {

    SweetsTypes type;

    public Sweets(SweetsTypes stype, int weight){
        this.type = stype;
        this.weight = weight;
    }

    @Override
    public boolean canHumanEatIt(Human human) {
        setCalories(type.calories);
        switch (type){
            case SNIKERS:  return (!human.isAllergic() && !human.isOnDiet());
            case CHOCOLATE:   return !human.isOnDiet();
            case RASIN: return !human.isAllergic();
        }
       return (!human.isAllergic() && !human.isOnDiet());
    }

    @Override
    public String toString() {
        return type.toString();

    }
}
