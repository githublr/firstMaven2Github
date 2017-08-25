package designPattern.strategy.allDuck;

/**
 * Created by zack.lr on 2017/8/23.
 */
public class SimUDuck{
    public static void main(String[] args)
    {
        MallardDuck duck1=new MallardDuck();
        System.out.println("Ò°Ñ¼×Ó³ö³¡-----------------");
        /*System.out.println(duck1.performQuack());
        System.out.println(duck1.swim());
        System.out.println(duck1.display());
        System.out.println(duck1.performFly());*/

        duck1.performQuack();
        duck1.swim();
        duck1.display();
        duck1.performFly();
    }
}
