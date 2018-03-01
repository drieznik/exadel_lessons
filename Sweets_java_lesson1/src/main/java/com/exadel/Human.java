package com.exadel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Objects;

public class Human implements Comparable<Human> {
    protected Double weight;
    private boolean isVegan;
    private boolean isOnDiet;
    private boolean isAllergic;
    private String name;

    //custom constructor

    public Human(String name, Boolean isAllergic, Boolean isOnDiet, Boolean isVegan) {
        this.isVegan = isVegan;
        this.isOnDiet = isOnDiet;
        this.isAllergic = isAllergic;
        this.name = name;
    }

    //default constructor - will use setters

    public Human() {
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = new Double("65.5");
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isOnDiet() {
        return isOnDiet;
    }

    public void setOnDiet(boolean onDiet) {
        isOnDiet = onDiet;
    }

    public boolean isAllergic() {
        return isAllergic;
    }

    public void setAllergic(boolean allergic) {
        isAllergic = allergic;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hello, I am " + name +
                "! I am" +
                (isAllergic ? " allergic" : "") +
                (isOnDiet ? " on diet" : "") +
                (isVegan ? " vegan." : ".");

    }

    private boolean ifAteEnough(int cal) {
        return (cal > 600);
    }

    @org.jetbrains.annotations.Contract(pure = true)
    private boolean ifAteTooMuch(int cal) {
        return (cal > 900);
    }

    protected String amHumanHungry(int cal) {
        if (ifAteEnough(cal)) {
            if (ifAteTooMuch(cal)) {
                return "I ate too much!";
            }
            return "I ate enough.";
        }
        return "I am still hungry!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return isVegan == human.isVegan &&
                isOnDiet == human.isOnDiet &&
                isAllergic == human.isAllergic &&
                Objects.equals(weight, human.weight) &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, isVegan, isOnDiet, isAllergic, name);
    }

    //comparator
    @Override
    public int compareTo(Human h) {
        int l = name.compareTo(h.name);
        return (l != 0 ? l : 1);
    }

    public static String sayThankYou() {
        return "Thank you!";
    }

    public static void toJson(Human h) throws com.fasterxml.jackson.core.JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(h);
        System.out.println(json);
    }


}
