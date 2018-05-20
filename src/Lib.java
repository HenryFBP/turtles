
public final class Lib
{
    public static double randrange(double start, double stop)
    {
        double diff = (stop - start);
        return ((Math.random() * diff) + start);
    }
}
