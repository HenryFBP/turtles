package turtles;
import java.awt.Color;
import java.util.List;

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

    public TurtlePixel(int width, int height, int scale)
    {
        super(width, height);
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

    public void drawPixelRow(List<Color> colors, TGPoint l)
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

    public void drawPixels(List<List<Color>> image, TGPoint l)
    {
        int r = (int) l.y;

        for(List<Color> row : image)
        {
            drawPixelRow(row, new TGPoint(l.x, r));
            r -= scale;
        }

        penup();
    }
    
    public void drawImages(List<List<List<Color>>> images, TGPoint l)
    {
        int r = (int) l.y;

        for(List<List<Color>> image : images)
        {
            drawPixels(image, new TGPoint(l.x, r));
            r -= (scale * image.size()); //subtract image's height
        }
    }

}
