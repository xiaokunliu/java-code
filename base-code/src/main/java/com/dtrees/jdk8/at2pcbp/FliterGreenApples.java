package com.dtrees.jdk8.at2pcbp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by keithl on 2017/8/17.
 */
public class FliterGreenApples {

    // the first way
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple:inventory){
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }


    //the second way
    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple:inventory){
            if (color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //third way
    public static List<Apple> filterApplesByWeight(List<Apple> inventory,float weight){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple:inventory){
            if (weight < apple.getWeight()){
                result.add(apple);
            }
        }
        return result;
    }

    //the fourth way
    public static List<Apple> filterApples(List<Apple> inventory,String color,float weight,boolean flag){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple:inventory){
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    // the second parameter is multiple behaviors,one parameter ==> ApplePredicate applePredicate
    public static List<Apple> filterApplesByPredicate(List<Apple> inventory,ApplePredicate applePredicate){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple:inventory){
            if (applePredicate.filterApples(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    // or using anonymous classes
    public static void main(String[] args) {
        //the fifth
        List<Apple> inventory = Lists.newArrayList();
        inventory.add(new Apple("green",190.00f));
        inventory.add(new Apple("green",109.00f));
        inventory.add(new Apple("red",123.00f));
        inventory.add(new Apple("green",144.00f));
        inventory.add(new Apple("red",130.00f));

        List<Apple> result1 = filterApplesByPredicate(inventory, new ApplePredicate() {
            public boolean filterApples(Apple apple) {
                return false;
            }
        });

        //print result

        //sixth way
        List<Apple> result2 = filterApplesByPredicate(inventory,apple -> "red".equals(apple.getColor()));
        System.out.println(result2);

        //using sort
        inventory.sort((Apple a1,Apple a2) -> new Float(a1.getWeight()).compareTo(new Float(a2.getWeight())));

        //using the thread run method
        Thread t = new Thread(() -> System.out.println("hello run method"));
        t.start();
    }
}


interface ApplePredicate{
    boolean filterApples(Apple apple);
}

class AppleColorPredicate implements ApplePredicate{

    public boolean filterApples(Apple apple) {
        return "green".equals(apple.getColor());
    }
}


class AppleWeightPredicates implements ApplePredicate{

    public boolean filterApples(Apple apple) {
        return apple.getWeight() > 150.0f;
    }
}

class Apple{

    private float price;
    private float width;
    private float length;
    private float high;
    private float weight;
    private String color;

    public Apple(String color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "weight:"+weight+",color:"+color;
    }
}
