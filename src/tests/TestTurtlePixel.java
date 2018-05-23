package tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import TurtleGraphics.TGPoint;
import lib.Lib;
import lib.LibPixel;
import turtles.TurtlePixel;

public class TestTurtlePixel
{
    @SuppressWarnings("serial")
    public static void main(String[] args)
    {
        List<Color> rainbow = Lib.stringstocolor("RED, ORANGE, YELLOW, GREEN, BLUE, MAGENTA");
        List<Color> blackwhite = Lib.stringstocolor("BLACK, WHITE, BLACK, WHITE, BLACK, WHITE");

        //@formatter:off
        List<List<Color>> happyface =       LibPixel.ASCIItoColor(      "resources/happyface.txt",    "resources/happyface.map");
        List<List<Color>> hello =           LibPixel.ASCIItoColor(      "resources/hello.txt",        "resources/hello.map");
        List<List<Color>> happyfacepng =    LibPixel.imageFileToColor(  "resources/happyface.png");
        List<List<Color>> awwyeah =         LibPixel.imageFileToColor(  "resources/awwyeah.png");
        List<List<Color>> ants =            LibPixel.imageFileToColor(  "resources/ants.png");
        //@formatter:on

        List<List<List<Color>>> images = new ArrayList<List<List<Color>>>()
        {
            {
                add(happyface);
                add(hello);
                add(happyfacepng);
                add(awwyeah);
                add(ants);
            }
        };

        TurtlePixel t = new TurtlePixel(1900, 1000, 10);
        t.throttle(10);

        int x = -900;
        int y = 0;

        t.drawPixel(Color.PINK, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixelRow(rainbow, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixelRow(blackwhite, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawImages(images, new TGPoint(x, t.scale * (y -= 1)));
    }

}
