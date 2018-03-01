package com.exadel.Food;

import com.exadel.Human;

public class Vegetables extends Food {
    @Override
    public boolean canHumanEatIt(Human human) {
        return true;
    }

    @Override
    public String toString() {
        return type;

    }
}
