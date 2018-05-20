
public class TestTurtleNGon extends TurtleNGon
{

    public static void main(String[] args)
    {
        TestTurtleNGon t = new TestTurtleNGon();
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
