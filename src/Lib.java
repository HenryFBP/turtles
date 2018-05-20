import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class Lib
{

    public static String normalize_newlines(String s, CharSequence replacement)
    {
        s = s.replace("\r\n", replacement);

        s = s.replace("\r", replacement);

        return s;
    }
    
    public static String normalize_newlines(String s)
    {
        return normalize_newlines(s, "\n");
    }

    public static Color[] stringstocolor(String s)
    {
        ArrayList<Color> ret = new ArrayList<>();

        for(String str : s.split(","))
        {
            ret.add(stringtocolor(str));
        }

        return ret.toArray(new Color[ret.size()]);
    }

    public static Color stringtocolor(String s)
    {

        s = s.replaceAll(" ", "");

        Color c;
        try
        {
            Field f = java.awt.Color.class.getField(s);
            c = (Color) f.get(null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            c = null;
        }
        return c;
    }

    public static double randrange(double start, double stop)
    {
        double diff = (stop - start);
        return ((Math.random() * diff) + start);
    }

    public static String filetostring(File f)
    {
        String s = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null)
            {
                s += line + "\n";
            }
            br.close();

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return s;
    }
}
