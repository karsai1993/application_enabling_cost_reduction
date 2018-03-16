package laszlo.karsai.diploma.work;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class helps the Main class by creating charts.
 *
 */
public class GraphPanel extends JPanel {

    private int height;
    private int padding = 40;
    private int labelPadding = 40;
    private Color lineColor = Color.BLUE;
    private Color pointColor = Color.RED;
    private Color gridColor = Color.GRAY;
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
    private List<Double> scores;
    private String method;
    private String type;

    /**
     * The function of this constructor is to make the GraphPanel class usable.
     * @param scores List<Double>
     * @param type String
     * @param method String
     */
    public GraphPanel(List<Double> scores, String type, String method) {
        this.scores = scores;
        this.type = type;
        this.method = method;
    }
    
    /**
     * It is a default constructor.
     */
    public GraphPanel() {
    }

    /**
     * Its function is to create graphs.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        height = getHeight() / 2;
        double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (scores.size() - 1);
        double yScale = ((double) height - 2 * padding - labelPadding) / 100;
        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((100 - scores.get(i)) * yScale + padding);
            graphPoints.add(new Point(x1, y1));
        }
        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, height - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

        // create hatch marks and grid lines for y axis.
        int yAxisDescriptionXCoordinate = 0;
        int yAxisDescriptionYCoordinate = 0;
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = height - ((i * (height - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (scores.size() > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((100 * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y1);
            yAxisDescriptionYCoordinate = y0;
            yAxisDescriptionXCoordinate = x0;
        }
        if (type.equals("cpu")) {
        	g2.drawString("Overall CPU Utilization [%] (calculated by "+method+")", yAxisDescriptionXCoordinate - 40, yAxisDescriptionYCoordinate - 20);
        } else {
        	g2.drawString("Overall Memory Used Size [%] (calculated by "+method+")", yAxisDescriptionXCoordinate - 45, yAxisDescriptionYCoordinate - 20);
        }
        // and for x axis
        int xAxisDescriptionXCoordinate = 0;
        int xAxisDescriptionYCoordinate = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.size() > 1) {
                int x0 = i * (getWidth() - padding * 2 - labelPadding) / (scores.size() - 1) + padding + labelPadding;
                int x1 = x0;
                int y0 = height - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((scores.size() / 20.0)) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, height - padding - labelPadding - 1 - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                }
                g2.drawLine(x0, y0, x1, y1);
                xAxisDescriptionYCoordinate = y0;
                xAxisDescriptionXCoordinate = x1;
            }
        }
        g2.drawString("Last 20 Samples [1]", xAxisDescriptionXCoordinate - 80, xAxisDescriptionYCoordinate + 25);

        // create x and y axes 
        g2.drawLine(padding + labelPadding, height - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, height - padding - labelPadding, getWidth() - padding, height - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }

    /**
     * Its function is to set the scores of a graph.
     * @param scores List<Double>
     */
    public void setScores(List<Double> scores) {
        this.scores = scores;
        invalidate();
        this.repaint();
    }

    /**
     * Its function is to get the scores of a graph.
     * @return List<Double>
     */
    public List<Double> getScores() {
        return scores;
    }
    
    /**
     * Its function is to get the type of the chart.
     * @return String
     */
    public String getType() {
		return type;
	}

    /**
     * Its function is to set the type of the chart.
     * @param type String
     */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Its function is to set the calculation method based on which the score values are calculated.
	 * @param method String
	 */
	public void setMethod(String method) {
        this.method = method;
        invalidate();
        this.repaint();
    }

	/**
	 * Its function is to get the calculation method based on which the score values are calculated.
	 * @return String
	 */
    public String getMethod() {
        return method;
    }
}