package com.designPatterns.abstractFactory;

/**
 * 抽象工厂模式:
 * 抽象出一个超级工厂AbstractFactory，普通工厂继承超级工厂，通过工厂的生产者创建生产者需要的工厂
 * 关键代码：在一个工厂里聚合多个同类产品
 * 优点：当一个产品族中的多个对象被设计成一起工作时，能保证客户端始终只使用同一个产品族中的对象
 * 缺点：产品族扩展非常困难
 *
 * @author dingfubing
 * @since 2020/8/19 13:39
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
class AbstractFactoryPatternDemo{

    public static void main(String[] args) {
        AbstractFactory shape = FactoryProducer.getFactory("shape");
        assert shape != null;
        Shape aShape = shape.getShape("aShape");
        aShape.shape();
        AbstractFactory color = FactoryProducer.getFactory("AColor");
        assert color != null;
        Color aColor = color.getColor("AColor");
        aColor.color();
    }
}
class FactoryProducer{
    public static AbstractFactory getFactory(String factoryName){
        if (factoryName.equalsIgnoreCase("Shape")) {
            return new ShapeFactory();
        } else if (factoryName.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        }
        return null;
    }
}
class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("AShape")) {
            return new AShape();
        } else if (shape.equalsIgnoreCase("BShape")) {
            return new BShape();
        } else if (shape.equalsIgnoreCase("CShape")) {
            return new CShape();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null){
            return null;
        }
        if (color.equalsIgnoreCase("AColor")) {
            return new AColor();
        } else if (color.equalsIgnoreCase("BColor")) {
            return new BColor();
        } else if (color.equalsIgnoreCase("CColor")) {
            return new CColor();
        }
        return null;
    }
}
interface Shape {

    void shape();
}

class AShape implements Shape {

    @Override
    public void shape() {
        System.out.println("AShape");
    }
}

class BShape implements Shape {

    @Override
    public void shape() {
        System.out.println("BShape");
    }
}

class CShape implements Shape {

    @Override
    public void shape() {
        System.out.println("CShape");
    }
}

interface Color {

    void color();
}

class AColor implements Color {

    @Override
    public void color() {
        System.out.println("AColor");
    }
}

class BColor implements Color {

    @Override
    public void color() {
        System.out.println("BColor");
    }
}

class CColor implements Color {

    @Override
    public void color() {
        System.out.println("CColor");
    }
}