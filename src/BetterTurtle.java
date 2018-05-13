import java.util.ArrayList;

import TurtleGraphics.TurtleGraphicsWindow;

/**
 * A Turtle, but better!
 */
@SuppressWarnings("serial")
public class BetterTurtle extends TurtleGraphicsWindow
{
    /**
     * The number of degrees in a circle.
     */
    public static double DEG_IN_CIRC = 360.0D;

    public void rt()
    {
        this.right();
    }

    public void right()
    {
        this.right(DEG_IN_CIRC / 4);
    }

    public void lt()
    {
        this.left();
    }

    public void left()
    {
        this.left(DEG_IN_CIRC / 4);
    }

    /***
     * Adds one to the current pen color.<br>
     * If it would be outside of 'logo' colors, set it to 0.
     */
    public void incrementpencolor()
    {
        this.setpencolor(this.pencolor() + 1);

        if(this.pencolor() > MAX_LOGO_COLOR)
        {
            this.setpencolor(0);
        }
    }

    public void follow_path(ArrayList<int[]> path)
    {

    }

}
