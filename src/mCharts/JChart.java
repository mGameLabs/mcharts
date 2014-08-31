package mCharts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.RenderingHints.*;

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

    protected double clamp(double min, double max, double value) {
        if (value < min) value = min;
        else if (value > max) value = max;
        return value;
    }

    protected int round(double value) {
        return (int) (value + 0.5); //Just casting to int will always result in the smaller number
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D) g.create();
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);

    }
}
