package lib;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import TurtleGraphics.TGPoint;

public final class Lib
{

    /***
     * Add two points together
     */
    public static TGPoint add(TGPoint a, TGPoint b)
    {
        return new TGPoint((a.x + b.x), (a.y + b.y));
    }

    /***
     * Multiply two points together.
     */
    public static TGPoint mult(TGPoint a, TGPoint b)
    {
        return new TGPoint((a.x * b.x), (a.y * b.y));
    }

    /***
     * Replace all newline sequences with one type of newline sequence.
     */
    public static String normalize_newlines(String s, CharSequence replacement)
    {
        s = s.replace("\r\n", replacement);

        s = s.replace("\r", replacement);

        return s;
    }

    /***
     * See {@link #normalize_newlines(String, CharSequence)}
     */
    public static String normalize_newlines(String s)
    {
        return normalize_newlines(s, "\n");
    }

    public static List<Color> stringstocolor(String s)
    {
        List<Color> ret = new ArrayList<>();

        for(String str : s.split(","))
        {
            ret.add(stringtocolor(str));
        }

        return ret;
    }

    /***
     * Given a String, return a {@link java.awt.Color Color}.<br>
     * Example:
     * 
     * <pre>
     * <code>
     * "RED" -> java.awt.Color.RED
     * </pre>
     * </code>
     */
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

    public static String filetostring(String s)
    {
        return filetostring(new File(s));
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

    /**
     * Transpose your (presumably rectangular) 2d array!
     */
    public static <T> List<List<T>> transpose(List<List<T>> source)
    {
        List<List<T>> result = new ArrayList<>();

        int rowsize = ((List<T>) source.get(0)).size();

        for(int i = 0; i < rowsize; i++)
        {
            List<T> col = new ArrayList<>();

            for(List<T> row : source)
            {
                col.add(row.get(i));
            }

            result.add(col);
        }

        return result;

    }
}
