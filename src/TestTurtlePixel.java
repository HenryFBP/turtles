import java.awt.Color;
import java.util.List;

import TurtleGraphics.TGPoint;

public class TestTurtlePixel
{
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

        TurtlePixel t = new TurtlePixel(1900, 1000, 2);
        t.throttle(0);

        int x = -900;
        int y = 100;

        t.drawPixel(Color.PINK, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixelRow(rainbow, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixelRow(blackwhite, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(happyface, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(hello, new TGPoint(x, (t.scale * (y -= (happyface.get(0).size()))))); // go down by 1 column...\
        t.drawPixels(happyfacepng, new TGPoint(x, (t.scale * (y -= hello.get(0).size()))));
        t.drawPixels(awwyeah, new TGPoint(x, (t.scale * (y -= happyfacepng.get(0).size()))));
        t.drawPixels(ants, new TGPoint(x, (t.scale * (y -= ants.get(0).size()))));
    }

}
