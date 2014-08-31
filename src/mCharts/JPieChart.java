package mCharts;

import java.awt.*;
import java.util.ArrayList;
import static java.awt.RenderingHints.*;

public class JPieChart extends JChart {

    public JPieChart(Dimension size, ArrayList<Double> values) {
        super(size, values);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D) g.create();
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);

        double total = 0;
        for(int i = 0; i < values.size(); i++) { //Reference for absolute to relative conversion
            total += values.get(i);
        }

        for(int i = 0; i < values.size(); i++) {
            int startAngle = 0;
            if(i != 0)
                for(int j = 0; j < i; j++)
                    startAngle += round(values.get(j) / total * 360); //Conversion from absolute to relative

            g2.setColor(colorPalette.get(cycleColorIndex(i)));
            g2.fillArc(0, 0, getWidth(), getHeight(), -startAngle + 90, -round(values.get(i) / total * 360));
        }

    }
}
