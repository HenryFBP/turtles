import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class LibPixel
{

    public static Color[][] ASCIItoColor(String ascii, HashMap<Character, Color> colorMap)
    {
        ascii = Lib.normalize_newlines(ascii);

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
                row.add(colorMap.get(c)); // add char
            }
        }

        Color[][] imagec = image.stream().map(u -> u.toArray(new Color[0])).toArray(Color[][]::new); // tl;dr is { ArrayList<ArrayList<Color>> -> Color[][] }

        return imagec;

    }

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

    public static HashMap<Character, Color> colormapfromfile(String s)
    {
        return colormapfromfile(new File(s));
    }

    public static Color[][] ASCIItoColor(String ascii_location, String color_map_location)
    {
        return ASCIItoColor(Lib.filetostring(ascii_location), LibPixel.colormapfromfile(color_map_location));
    }

}
