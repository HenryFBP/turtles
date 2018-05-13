import TurtleGraphics.TurtleGraphicsWindow;

public class BetterTurtle extends TurtleGraphicsWindow
{
    
    public void rt()
    {
        this.right();
    }

    public void right()
    {
        this.right(90);
    }
    
    public void lt()
    {
        this.left();
    }
    
    public void left()
    {
        this.left(90);
    }
    
    /***
     * Adds one to the current pen color.<br>
     * If it would be too large, sets it to 0.
     */
    public void incrementpencolor()
    {
        this.setpencolor(this.pencolor() + 1);

        if(this.pencolor() >= 32)
        {
            this.setpencolor(0);
        }
    }
    

}
