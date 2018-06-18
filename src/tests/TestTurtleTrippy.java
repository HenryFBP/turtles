package tests;

import javax.swing.JOptionPane;

import turtles.BetterTurtle;

public class TestTurtleTrippy
{
    public static void main(String[] args)
    {

        String s = JOptionPane.showInputDialog("Seizure warning!\n" + "Type 'OK' to continue, anything else to quit.");

        if(!s.equalsIgnoreCase("OK"))
        {
            return;
        }

        BetterTurtle t = new BetterTurtle();

        t.throttle(10);

        for(double i = 0; i < 1000; i += 0.20)
        {
            t.pendown();
            t.randompenhexcolor();
            t.forward(i);
            t.left(i);
        }
    }
}
