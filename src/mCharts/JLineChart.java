package mCharts;

import java.awt.*;
import java.util.ArrayList;

public class JLineChart extends JChart {

    private boolean relative;
    private boolean nodes;

    protected JLineChart(Dimension size, ArrayList<Double> values, boolean relative, boolean nodes) {
        super(size, values);
        this.relative = relative;
        this.nodes = nodes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2.setColor(colorPalette.get(0));

        int renderWidth = getWidth();
        int nodeWidth = round(clamp(5, 1000, getWidth() / 80));
        if(nodes) renderWidth -= nodeWidth;

        int[] xPoints = new int[values.size()];
        int[] yPoints = new int[values.size()];

        double highestValue = 0;
        for(Double value : values) {
            if(highestValue < value) highestValue = value;
        }

        for(int i = 0; i < values.size(); i++) {
            if(relative) yPoints[i] = getHeight() - round(values.get(i) / highestValue * getHeight());
            else yPoints[i] = getHeight() - round(values.get(i) * getHeight());
            xPoints[i] = round(renderWidth / (values.size() - 1) * i + nodeWidth / 2);
            if(nodes) {
                if(yPoints[i] == 0) yPoints[i] += nodeWidth / 2;
                else if(yPoints[i] == getHeight()) yPoints[i] -= nodeWidth / 2;
                //noinspection SuspiciousNameCombination
                g2.fillOval(xPoints[i] - nodeWidth / 2, yPoints[i] - nodeWidth / 2, nodeWidth, nodeWidth);
            }
        }
        g2.setStroke(new BasicStroke(nodeWidth / 5));
        g2.drawPolyline(xPoints, yPoints, values.size());
    }
}
