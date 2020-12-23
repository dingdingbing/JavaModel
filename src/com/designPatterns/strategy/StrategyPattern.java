package com.designPatterns.strategy;

/**
 * 策略模式
 * 意图：定义一系列的算法，把他们封装起来，并使他们可以互相替换
 * 主要解决的问题：在有许多算法相似的情况下，使用if..else.. 所带来的复杂和难以维护
 * 如何解决：将这些算法封装成一个个的类，任意的替换
 * 关键的代码：实现同一个接口
 * 代码的主要思路：实现同一个接口，使用一个类将该接口变成他的属性，该类需要一个方法调用接口的实现方法。主要是在玩接口的属性吧应该算是
 *
 * @author dingfubing
 * @since 2020/12/22 16:57
 */
public class StrategyPattern {

    public static void main(String[] args) {
        // new
        OperationAdd operationAdd = new OperationAdd();
        StrategyDemo strategyDemo = new StrategyDemo(operationAdd);

        int i = strategyDemo.strategyContext(1, 2);
        System.out.println(i);

        strategyDemo.setStrategy(new OperationSub());
        int i1 = strategyDemo.strategyContext(2, 1);
        System.out.println(i1);

        strategyDemo.setStrategy(new OperationMulti());
        int i2 = strategyDemo.strategyContext(2, 2);
        System.out.println(i2);
    }
}
class StrategyDemo {
    private Strategy strategy;

    public int strategyContext(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
    public StrategyDemo() {
    }

    public StrategyDemo(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
interface Strategy{
    int doOperation(int num1, int num2);
}
class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
class OperationSub implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
class OperationMulti implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
class OperationDiv implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1/num2;
    }
}
