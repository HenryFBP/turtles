
public class TestNGon extends NGon
{

    public static void main(String[] args)
    {
        TestNGon t = new TestNGon();
        t.throttle(100); // delay by N milliseconds
        t.right();

        for(int i = 3; i < 10; i++)
        {
            t.forward(100);
            t.incrementpencolor();
            t.drawNGon(300, i);
        }

    }
}
