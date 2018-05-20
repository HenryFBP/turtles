import java.awt.Color;

import TurtleGraphics.TGPoint;

public class TestTurtlePixel
{
    public static void main(String[] args)
    {
        Color[] rainbow = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, };
        Color[] blackwhite = { Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE };

        TurtlePixel t = new TurtlePixel();

        t.throttle(100);
        int i = 0;

        t.drawPixel(Color.PINK, new TGPoint(0, (t.scale * i--)));
        t.drawPixels(rainbow, new TGPoint(0, (t.scale * i--)));
        t.drawPixels(blackwhite, new TGPoint(0, (t.scale * i--)));

    }

}
