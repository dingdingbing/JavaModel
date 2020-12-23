package com.designPatterns.prototype;

import java.util.Hashtable;
import java.util.Map;

/**
 * 原型模式：
 * 主要解决：在运行期建立和删除原型。
 * 意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 优点：1、性能提高。 2、逃避构造函数的约束。
 * 缺点：1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。
 * 2、必须实现 Cloneable 接口。
 *
 * @author dingfubing
 * @since 2020/9/4 10:41
 */
public class prototype {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape map = ShapeCache.getMap("1");
        System.out.println(map.getId() + " === " + map.getType());

        Shape map1 = ShapeCache.getMap("2");
        System.out.println(map1.getType());
    }
}

class ShapeCache {
    private static final Map<String, Shape> map = new Hashtable<>();

    public static Shape getMap(String shapeId){
        Shape shape = map.get(shapeId);
        return (Shape)shape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");

        map.put(circle.getId(), circle);
        map.put(rectangle.getId(), rectangle);
    }

}
class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Circle draw()");
    }
}
class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle draw()");
    }
}
abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }
}
