import java.awt.Color;
import java.util.HashMap;

import TurtleGraphics.TGPoint;

public class TestTurtlePixel
{
    @SuppressWarnings("serial")
    public static void main(String[] args)
    {
        Color[] rainbow = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, };
        Color[] blackwhite = { Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE };

        HashMap<Character, Color> colormap = new HashMap<Character, Color>()
        {
            {
                put('.', Color.PINK);
                put('#', Color.YELLOW);
                put('A', Color.GREEN);
            }
        };
        
        //@formatter:off
        String happyfacestr = ""
                + ".....\n"
                + ".#.#.\n"
                + "..A..\n"
                + "#...#\n"
                + ".###.\n";
        //@formatter:on

        Color[][] happyface = TurtlePixel.ASCIItoColor(happyfacestr, colormap);

        TurtlePixel t = new TurtlePixel();
        t.throttle(100);
        int i = 0;

        t.drawPixel(Color.PINK, new TGPoint(0, (t.scale * i--)));
        t.drawPixels(rainbow, new TGPoint(0, (t.scale * i--)));
        t.drawPixels(blackwhite, new TGPoint(0, (t.scale * i--)));
        t.drawPixels(happyface, new TGPoint(0, (t.scale * i--)));

    }

}
