@SuppressWarnings("serial")
public class TurtleNGon extends BetterTurtle
{
    public void drawTriangle(double length)
    {
        drawNGon(length, 3);
    }

    public void drawSquare(double length)
    {
        drawNGon(length, 4);
    }

    public void drawNGon(double length, int sides)
    {
        for(int i = 0; i < sides; i++)
        {
            forward(length / sides);
            right(DEG_IN_CIRC / sides);
        }
    }
}
