package mCharts;

import java.awt.*;
import java.util.ArrayList;

public class JRingChart extends JPieChart {

    private double thickness;
    private boolean relative;

    public JRingChart(Dimension size, ArrayList<Double> values, double thickness, boolean relative) {
        super(size, values);
        this.thickness = thickness;
        this.relative = relative;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2.setColor(background);

        if(relative) {
            int tx = round(thickness * getWidth());
            int ty = round(thickness * getHeight());

            g2.fillOval(tx, ty, getWidth() - 2 * tx, getHeight() - 2 * ty);
        }
        else {
            int tr = round(thickness);
            g2.fillOval(tr, tr, getWidth() - 2 * tr, getHeight() - 2 * tr);
        }
    }
}
