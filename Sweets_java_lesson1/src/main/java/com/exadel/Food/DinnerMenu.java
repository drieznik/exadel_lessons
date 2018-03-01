package com.exadel.Food;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DinnerMenu {
    int weight;
    Random randomWeight = new Random();
    MeatType mType;
    SweetsTypes sType;
    StringBuilder menu = new StringBuilder();

    public Set<Meat> allMeat = new HashSet<>();
    public Set<Sweets> allSweets = new HashSet<>();
    public Set<Vegetables> allVegetables = new HashSet<>();

    public void populateFoodMap() {
       populateMeatMap();
       populateSweetsMap();
        writeMenu();
    }

    protected void populateMeatMap(){
        for (MeatType dir : MeatType.values()) {
            weight = 100 + randomWeight.nextInt(300 - 100);
            mType = dir;
            Meat m = new Meat(mType, weight);
            allMeat.add(m);
        }
    }

    protected void populateSweetsMap(){
        for (SweetsTypes dir : SweetsTypes.values()) {
            weight = 50 + randomWeight.nextInt(100 - 50);
            sType = dir;
            Sweets s = new Sweets(sType, weight);
            allSweets.add(s);
        }
    }

    protected void writeMenu(){
        menu.append("Hello! Todays menu is:" + System.getProperty("line.separator"));
        for (Meat m : allMeat){
            menu.append(m.type + " " + m.weight + "gr" + System.getProperty("line.separator"));
        }
        for (Sweets s : allSweets){
            menu.append(s.type + " " + s.weight + "gr" + System.getProperty("line.separator"));
        }
        System.getProperty("line.separator");
        System.out.println(menu);

    }
}
