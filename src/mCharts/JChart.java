package mCharts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JChart extends JComponent {

    public static ArrayList<Color> colorPalette = new ArrayList<Color>();
    public static Color background = Color.white;

    public ArrayList<Double> values; //publicly changeable

    protected Graphics2D g2;

    protected JChart(Dimension size, ArrayList<Double> values) {
        this.setSize(size);
        this.values = values;
    }

    protected int cycleColorIndex(int value) {
        while (value >= colorPalette.size()) {
            value -= colorPalette.size();
        }

        return value;
    }

    protected int round(double value) {
        return (int) (value + 0.5); //Just casting to int will always result in the smaller number
    }

}
