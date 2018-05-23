package turtles;

@SuppressWarnings("serial")
public class SpiralTurtle extends BetterTurtle
{
    /***
     * 
     * @param length
     *            Radius of the spiral (Probably)
     * @param curve
     *            Factor at which the spiral either:
     * 
     *            <pre>
     * <code>
     * curve &gt; 0: Gets smaller,
     * curve &lt; 0: Gets larger.
     * </code>
     *            </pre>
     * 
     * @param angle
     *            How steep is the curve?
     * @param steps
     *            How far in should we go?
     */
    public void spiral(double length, double curve, double angle, int steps)
    {
        for(int i = 0; i < steps; i++)
        {
            forward(length);
            right(angle);

            length /= curve; // go forward less
        }
    }

    public static void main(String[] args)
    {
        SpiralTurtle t = new SpiralTurtle();

        t.spiral(50.0, 1.05, 30.0, 100);
    }

}
