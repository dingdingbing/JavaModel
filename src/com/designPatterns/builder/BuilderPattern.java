package com.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式：以汉堡店套餐为例 汉堡和饮料是固定的，价格也是固定的，但是套餐是可以随意搭配的，消费者只需要选择已经固定好的套餐就可以
 * 主要解决: 对象本身变化比较复杂，但是多个不同对象组合却相当稳定
 * 如何解决：将不变与变分离开
 * 对比：想比于工厂模式，建造者模式更注重于零件装配的顺序
 * 优点：1.建造者独立，易拓展 2.便于控制细节风险
 * 缺点: 1.产品必须要有共同点，范围有限制 2.如内部变化复杂，会有很多构建类
 * @author dingfubing
 * @since 2020/8/19 15:17
 */
public class BuilderPattern {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareNoVegMeal();
        meal.showItems();
        float cost = meal.getCost();
        System.out.println(cost);
        Meal selfMeal = mealBuilder.selfMeal("chickenBurger", "coke");
        assert selfMeal != null;
        selfMeal.showItems();
    }
}
// 套餐建造者
class MealBuilder{

    /**
     * 自定义套餐
     * @param BurgerName
     * @param DrinkName
     * @return
     */
    public Meal selfMeal(String BurgerName, String DrinkName){
        Meal meal = new Meal();
        if (BurgerName.equalsIgnoreCase("VegBurger")){
            meal.addItem(new VegBurger());
        } else if (BurgerName.equalsIgnoreCase("ChickenBurger")){
            meal.addItem(new ChickenBurger());
        } else {
            return null;
        }
        if (DrinkName.equalsIgnoreCase("Coke")){
            meal.addItem(new Coke());
        } else if (DrinkName.equalsIgnoreCase("pepsi")){
            meal.addItem(new Pepsi());
        } else {
            return null;
        }
        return meal;
    }
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    public Meal prepareNoVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
// 菜单信息
class Meal{
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost = 0f;
        for (Item item : items){
            cost += item.price();
        }
        return cost;
    }
    public void showItems(){
        for (Item item : items){
            System.out.print("Item: " + item.name());
            System.out.print(" Packing: " + item.packing().pack());
            System.out.println(" Price: " + item.price());
        }
    }
}
// 商品明细
interface Item{
    String name();
    float price();
    Packing packing();
}
class VegBurger extends Burger{

    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
// 实现Item的抽象类 汉堡包
abstract class Burger implements Item{

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 5.0f;
    }
}
class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
// 实现Item的抽象类，饮料
abstract class ColdDrink implements Item{

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
// 打包类型
interface Packing{
    String pack();
}
// 纸盒包装
class Wrapper implements Packing{

    @Override
    public String pack() {
        return "Wrapper";
    }
}
// 杯子包装
class Bottle implements Packing{

    @Override
    public String pack() {
        return "Bottle";
    }
}
