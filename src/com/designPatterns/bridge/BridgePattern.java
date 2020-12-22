package com.designPatterns.bridge;

/**
 * 桥接模式
 *
 * @author dingfubing
 * @since 2020/11/10 9:57
 */
public class BridgePattern {

}
interface DrawAPI {
    void drawCircle();
}
abstract class Shape {
    DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    abstract void draw();
}
class RedCircle {

}
class GreenCircle {

}
