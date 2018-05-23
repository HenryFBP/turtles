package turtles;

import TurtleGraphics.TGPoint;

@SuppressWarnings("serial")
public class SpiralTurtle extends BetterTurtle
{
    public SpiralTurtle(int w, int h)
    {
        super(w, h);
    }

    /***
     * 
     * @param length
     *            Rough diameter of the spiral.
     * 
     * @param curve
     *            Factor at which the spiral either:<br>
     * 
     *            <code>
     * curve &gt; 0: Gets smaller,<br>
     * curve &lt; 0: Gets larger.<br>
     * <br>
     * </code>
     * @param angle
     *            How steep is the curve?
     * @param steps
     *            How far in should we go?
     */
    public void spiral(double length, double curve, double angle, int steps)
    {
        pendown();
        for(int i = 0; i < steps; i++)
        {
            forward(length);
            right(angle);

            length /= curve; // go forward less
        }
        penup();
    }
    

    public static void main(String[] args)
    {
        SpiralTurtle t = new SpiralTurtle(1920, 1080);
        t.throttle(10);
        t.penup();
        t.setxy(new TGPoint(-500, 0));

        t.spiral(50, 1.05, 30, 100); // an inward one!
        t.offsetxy(new TGPoint(150, 0));
        t.sety(0);
        t.setheading(0);

        t.spiral(50, 0.99, 30, 50); // an outward one!
        t.offsetxy(new TGPoint(300, 0));
        t.sety(0);
        t.setheading(0);
        
        t.spiral(100, 1.05, 90, 50); // a square one!
        t.offsetxy(new TGPoint(300, 0));
        t.sety(0);
        t.setheading(0);
        
        t.spiral(50, 1.05, -30, 100); // an inward one, but backwards!
        t.offsetxy(new TGPoint(150, 0));
        t.sety(0);
        t.setheading(0);

        
    }

}
