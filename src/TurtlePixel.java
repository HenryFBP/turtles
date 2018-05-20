import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import TurtleGraphics.TGPoint;

@SuppressWarnings("serial")
public class TurtlePixel extends BetterTurtle
{
    public static Color[][] ASCIItoColor(String ascii, HashMap<Character, Color> color_map)
    {
        ArrayList<ArrayList<Color>> image = new ArrayList<>();
        ArrayList<Color> row = new ArrayList<>();

        for(Character c : ascii.toCharArray())
        {
            if(c == '\n')
            {
                image.add(row); // add row
                row = new ArrayList<>(); // new row
            }
            else
            {
                row.add(color_map.get(c)); // add char
            }
        }

        Color[][] imagec = image.stream().map(u -> u.toArray(new Color[0])).toArray(Color[][]::new); // tl;dr is { ArrayList<ArrayList<Color>> -> Color[][] }

        return imagec;

    }

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
    }

}
