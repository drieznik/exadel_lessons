package com.exadel;

import com.exadel.Food.*;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) throws com.fasterxml.jackson.core.JsonProcessingException {
        //Petya is allergic
        Human petya = new Human("Petya", true, false, false);
        //Vasya is on diet
        Human vasya = new Human("Vasya", false, true, false);
        //Vova is vegan
        Human vova = new Human("Vova", false, false, true);

        Human sasha = new Human();
        sasha.setName("Alex");
        sasha.setAllergic(false);
        sasha.setOnDiet(true);
        sasha.setVegan(true);

        List<Human> humans = new ArrayList<>();
        humans.add(petya);
        humans.add(vasya);
        humans.add(vova);
        humans.add(sasha);

        Collections.sort(humans);

        DinnerMenu m = new DinnerMenu();
        m.populateFoodMap();

        int ateWeight;
        int ateCalories;

        StringBuilder outString = new StringBuilder();

        for (Human h : humans) {
            System.out.println(h);
            ateWeight = 0;
            ateCalories = 0;
            Boolean canEat;
            h.setWeight();
            outString.append("My weight is " + h.getWeight() + ". I ");
            for (Meat f : m.allMeat) {
                canEat = f.canHumanEatIt(h);
                outString.append((canEat ? "can " : "can't ") + "eat " + f.toString() + ", ");
                ateWeight = ateWeight + (canEat ? f.getWeight() : 0);
                ateCalories = ateCalories + (canEat ? f.getCaloriesPerPortion() : 0);
            }
            for (Sweets s : m.allSweets) {
                canEat = s.canHumanEatIt(h);
                outString.append((canEat ? "can " : "can't ") + "eat " + s.toString() + ", ");
                ateWeight = ateWeight + (canEat ? s.getWeight() : 0);
                ateCalories = ateCalories + (canEat ? s.getCaloriesPerPortion() : 0);
            }
            outString.append("I ate " + ateWeight + "gr" + ". This is " + ateCalories + " calories." + " Now my weight is " + (h.getWeight() + ateWeight / 100));
            System.out.println(outString);

            System.out.println(h.amHumanHungry(ateCalories) + " " + Human.sayThankYou());
            outString.delete(0, outString.length());


        }

        Human strangeOne = new Human();
        strangeOne.setName("StrangeName /\" & ?");
        strangeOne.setAllergic(false);
        strangeOne.setOnDiet(true);
        strangeOne.setVegan(true);
        strangeOne.setWeight();

        System.out.println(strangeOne.toString());

        Human.toJson(strangeOne);

        System.out.println("Escaped : " + StringEscapeUtils.escapeHtml4(strangeOne.getName()));
        System.out.println("Unescaped : " + StringEscapeUtils.unescapeHtml4(strangeOne.getName()));
    }
}
