public class NGon extends BetterTurtle
{
    private static final long serialVersionUID = 3183339095077682335L;
    
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
            right(360.0 / sides);
        }
    }

    // program starts here
    public static void main(String[] args)
    {
        
    }

}
