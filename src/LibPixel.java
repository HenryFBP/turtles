import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

public class LibPixel
{

    public static List<List<Integer>> imageFileToPixels(File f)
    {
        List<List<Integer>> pixels = new ArrayList<>();

        try
        {
            BufferedImage bi = ImageIO.read(f);
            Raster r = bi.getData();

            int x = bi.getWidth();
            int y = bi.getHeight();

            // System.out.printf("File %s is '%d' by '%d'.\n", f.getName(), x, y);

            for(int i = 0; i < x; i++)
            {
                List<Integer> row = new ArrayList<>();

                for(int j = 0; j < y; j++)
                {
                    int p = bi.getRGB(i, j);
                    row.add(p);
                    System.out.printf("[%d,%d] = %08x ", i, j, p);
                }
                System.out.println();

                pixels.add(row);

            }
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        pixels = Lib.transpose(pixels);
        
        return pixels;

    }

    public static List<List<Color>> imageFileToColor(File f)
    {
        List<List<Color>> c = new ArrayList<>();

        List<List<Integer>> pixels = imageFileToPixels(f);

        for(List<Integer> row : pixels)
        {
            List<Color> crow = new ArrayList<>();

            for(int pixel : row)
            {
                Color color = new Color(pixel);
                crow.add(color);
            }

            c.add(crow);
        }

        return c;
    }

    public static List<List<Color>> ASCIItoColor(String ascii, HashMap<Character, Color> colorMap)
    {
        ascii = Lib.normalize_newlines(ascii);

        List<List<Color>> image = new ArrayList<>();
        List<Color> row = new ArrayList<>();

        for(Character c : ascii.toCharArray())
        {
            if(c == '\n')
            {
                image.add(row); // add row
                row = new ArrayList<>(); // new row
            }
            else
            {
                row.add(colorMap.get(c)); // add char
            }
        }

        return image;

    }

    @SuppressWarnings("serial")
    public static HashMap<Character, Color> colormapfromline(String s)
    {
        // System.out.printf("String '%s' -> ", s);
        String[] arr = s.split("=");

        Character c = arr[0].charAt(0);

        Color color = Lib.stringtocolor(arr[1].toUpperCase());

        HashMap<Character, Color> ret = new HashMap<Character, Color>()
        {
            {
                put(c, color);

            }
        };

        // System.out.println(ret.toString());

        return ret;
    }

    public static HashMap<Character, Color> colormapfromfile(File f)
    {
        HashMap<Character, Color> ret = new HashMap<Character, Color>();

        String s = Lib.filetostring(f);
        s = Lib.normalize_newlines(s);

        for(String l : s.split("\n"))
        {
            ret.putAll(colormapfromline(l)); // append single line
        }
        return ret;
    }

    public static HashMap<Character, Color> colormapfromfile(String path)
    {
        return colormapfromfile(new File(path));
    }

    public static List<List<Color>> ASCIItoColor(String asciiPath, String colormapPath)
    {
        return ASCIItoColor(Lib.filetostring(asciiPath), LibPixel.colormapfromfile(colormapPath));
    }

    public static List<List<Color>> imageFileToColor(String string)
    {
        return imageFileToColor(new File(string));
    }

}
