package tests;

import turtles.TurtleNGon;

public class TestTurtleNGon
{
    public static void main(String[] args)
    {
        TurtleNGon t = new TurtleNGon();
        t.throttle(100); // delay by N milliseconds
        t.right();

        for(int i = 3; i < 10; i++)
        {
            t.forward(100);
            t.randompenhexcolor();
            t.drawNGon(300, i);
        }

    }
}
