import java.awt.Color;
import java.io.File;
import java.util.HashMap;

import TurtleGraphics.TGPoint;

public class TestTurtlePixel
{

    @SuppressWarnings("serial")
    public static void main(String[] args)
    {
        Color[] rainbow = Lib.stringstocolor("RED, ORANGE, YELLOW, GREEN, BLUE, MAGENTA");
        Color[] blackwhite = Lib.stringstocolor("BLACK, WHITE, BLACK, WHITE, BLACK, WHITE");

        HashMap<Character, Color> colormap = TurtlePixel.colormapfromfile(new File("resources/happyface.map"));
        String happyfacestr = Lib.filetostring(new File("resources/happyface.txt"));
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
