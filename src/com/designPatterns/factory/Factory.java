package com.designPatterns.factory;

/**
 * 工厂模式：在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * 主要解决：主要解决接口选择问题
 * 如何解决：让子类实现工厂接口，返回的也是抽象的一个产品
 * 关键代码：创建过程让子类执行
 * 优点：1.调用者只需要知道名称就可以创建一个对象 2.拓展性高，想增加一个产品，只要拓展一个工厂类就行 3.屏蔽了产品的具体实现，调用者只关心产品的接口
 * 缺点：1.每次增加一个产品都需要增加一个具体的类和对象实现工厂，使得系统中的类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖，不是什么好事
 * @author dingfubing
 * @since 2020/8/19 11:21
 */
public class Factory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape a = shapeFactory.getShapeByName("F");
        a.getShape();
        new Thread(()->{}).start();

    }
}
class ShapeFactory{
    public Shape getShapeByName(String shapeName){
        if (shapeName == null){
            System.out.println("输入需要创建的模型名称");
            return null;
        }
        if (shapeName.equalsIgnoreCase("A")){
            return new AShape();
        } else if (shapeName.equalsIgnoreCase("B")){
            return new BShape();
        } else if (shapeName.equalsIgnoreCase("C")){
            return new CShape();
        }
        return null;
    }
}

interface Shape{
    void getShape();
}
class AShape implements Shape{

    @Override
    public void getShape() {
        System.out.println("AShape");
    }
}
class BShape implements Shape{

    @Override
    public void getShape() {
        System.out.println("BShape");
    }
}
class CShape implements Shape{

    @Override
    public void getShape() {
        System.out.println("CShape");
    }
}
