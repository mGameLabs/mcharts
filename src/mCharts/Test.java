package mCharts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static mCharts.JChart.colorPalette;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ArrayList<Double> testValues = new ArrayList<Double>();
        testValues.add(5d);
        testValues.add(16d);
        testValues.add(2d);
        testValues.add(9d);
        testValues.add(11d);
        testValues.add(5d);
        testValues.add(0d);
        testValues.add(2d);
        testValues.add(9d);
        testValues.add(11d);

        colorPalette.add(new Color(217, 48, 79));
        colorPalette.add(new Color(26, 49, 64));
        colorPalette.add(new Color(101, 159, 166));
        colorPalette.add(new Color(242, 214, 162));
        colorPalette.add(new Color(242, 120, 109));

        frame.add(new JLineChart(new Dimension(500, 500), testValues, true, true));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}
