package com.designPatterns.decorator;

/**
 * 装饰器模式
 *
 * @author dingfubing
 * @since 2020/12/23 14:50
 */
public class DecoratorPattern {

}
interface Shape {
    void draw();
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle Shape");
        String s = "";
        if (s== null || s.length() == 0) {

        }
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle Shape");
    }
}
abstract class DecoratorShape implements Shape{
    protected Shape decoratorShape;

    public DecoratorShape(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
class RedDecoratorShape extends DecoratorShape{

    public RedDecoratorShape(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        setRedShape(decoratorShape);
    }

    private void setRedShape(Shape decoratorShape) {
        System.out.println("Red Shape");
    }
}