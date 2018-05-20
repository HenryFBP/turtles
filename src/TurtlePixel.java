import java.awt.Color;

import TurtleGraphics.TGPoint;

@SuppressWarnings("serial")
public class TurtlePixel extends BetterTurtle
{
    public int scale = 50;

    public TurtlePixel()
    {
        super();
    }

    public TurtlePixel(int scale)
    {
        super();
        this.scale = scale;
    }

    public void drawPixel(Color c, TGPoint l)
    {
        setxy(l);
        setpencolor(c);
        setpensize(scale);
        pendown();
        east();
        forward(scale);

        penup();
    }

    public void drawPixels(Color[] colors, TGPoint l)
    {
        setxy(l);
        setpensize(scale);
        pendown();
        east();

        for(Color c : colors)
        {
            setpc(c);
            forward(scale);
        }

        penup();
    }

    public void drawPixels(Color[][] image, TGPoint l)
    {
        int r = (int) l.y;

        for(Color[] row : image)
        {
            drawPixels(row, new TGPoint(l.x, r));
            r -= scale;
        }
        
        penup();
    }

}
