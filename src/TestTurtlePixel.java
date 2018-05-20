import java.awt.Color;

import TurtleGraphics.TGPoint;

public class TestTurtlePixel
{

    @SuppressWarnings("serial")
    public static void main(String[] args)
    {
        Color[] rainbow = Lib.stringstocolor("RED, ORANGE, YELLOW, GREEN, BLUE, MAGENTA");
        Color[] blackwhite = Lib.stringstocolor("BLACK, WHITE, BLACK, WHITE, BLACK, WHITE");

        Color[][] happyface = LibPixel.ASCIItoColor("resources/happyface.txt", "resources/happyface.map");
        Color[][] hello = LibPixel.ASCIItoColor("resources/hello.txt", "resources/hello.map");

        TurtlePixel t = new TurtlePixel(5);
        t.throttle(30);

        int x = -200;
        int y = 0;

        t.drawPixel(Color.PINK, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(rainbow, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(blackwhite, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(happyface, new TGPoint(x, (t.scale * (y -= 1))));
        t.drawPixels(hello, new TGPoint(x, (t.scale * (y -= (happyface[0].length))))); // go down by 1 column...

    }

}
