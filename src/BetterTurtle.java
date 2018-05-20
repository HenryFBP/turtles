import java.awt.Color;
import java.util.ArrayList;

import TurtleGraphics.TGPoint;
import TurtleGraphics.TurtleGraphicsWindow;

/**
 * A Turtle, but better!
 */
@SuppressWarnings("serial")
public class BetterTurtle extends TurtleGraphicsWindow
{

    public BetterTurtle()
    {
        super();
    }

    public BetterTurtle(int w, int h)
    {
        super(w, h);
    }

    public TGPoint getlocation()
    {
        return new TGPoint(getX(), getY());
    }

    /**
     * The number of degrees in a circle.
     */
    public static double DEG_IN_CIRC = 360.0D;

    /***
     * Face north.
     */
    public void north()
    {
        seth(DEG_IN_CIRC * (0.0 / 4.0));
    }

    /***
     * Face east.
     */
    public void east()
    {
        seth(DEG_IN_CIRC * (1.0 / 4.0));
    }

    /***
     * Face south.
     */
    public void south()
    {
        seth(DEG_IN_CIRC * (2.0 / 4.0));
    }

    /***
     * Face west.
     */
    public void west()
    {
        seth(DEG_IN_CIRC * (3.0 / 4.0));
    }

    /***
     * Face a random direction.
     */
    public void randomheading()
    {
        seth(Lib.randrange(0, 360));
    }

    public void setpc(Color c)
    {
        setpencolor(c.getRGB());
    }

    public void setpencolor(Color c)
    {
        setpc(c);
    }

    public void rt()
    {
        right();
    }

    public void right()
    {
        right(DEG_IN_CIRC / 4);
    }

    public void lt()
    {
        left();
    }

    public void left()
    {
        left(DEG_IN_CIRC / 4);
    }

    public void setpencolor(double c)
    {
        setpencolor((int) c);
    }

    /**
     * Random Logo color.
     * 
     * @see #setpencolor(int)
     */
    public void randompenlogocolor()
    {
        double color = Lib.randrange(0, MAX_LOGO_COLOR);

        setpencolor(color);
    }

    /***
     * Random 24-bit RGB color.
     * 
     * @see #setpencolor(int)
     */
    public void randompenhexcolor()
    {
        double color = Lib.randrange(32, Math.pow(2, 24)); // between 0x000002 and 0xFFFFFF

        setpencolor(color);
    }

    /***
     * Adds one to the current pen color.<br>
     * If it would be outside of 'logo' colors, set it to 0.
     */
    public void incrementpencolor()
    {
        setpencolor(pencolor() + 1);

        if(pencolor() > MAX_LOGO_COLOR)
        {
            setpencolor(0);
        }
    }

    public void follow_path(ArrayList<int[]> path)
    {

    }

}
