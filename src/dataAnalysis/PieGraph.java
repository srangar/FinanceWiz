package dataAnalysis;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 * 
 * @version 05/13/15 
 * 
 * Creates a Pie Graph
 */
public class PieGraph extends JPanel {


	/**
	 * @post Creates a PieGraph
	 */
	public PieGraph() {
		
	}

	/**
	 * @param g Graphics Object that is used to draw the Pie Graph
	 * @post The Pie Graph is drawn using the Graphics object.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth();
		int h = getHeight();
		int x = w / 2;
		int y = h / 2;
		int r = Math.min(w, h) / 3;
		drawPieChart(g, x, y, r);
		drawLegend(g, x, y, r);
	}

	private void drawPieChart(Graphics g, int x, int y, int r) {
		int total = 20;
		int fromDegree = 0;

		if (total > 0) {
			int degrees;

			g.setColor(Color.RED);
			degrees = countToDegrees(4, total);
			drawSector(g, x, y, r, fromDegree, degrees);
			fromDegree += degrees;

			g.setColor(Color.GREEN);
			degrees = countToDegrees(4, total);
			drawSector(g, x, y, r, fromDegree, degrees);
			fromDegree += degrees;

			g.setColor(Color.BLUE);
			degrees = countToDegrees(4, total);
			drawSector(g, x, y, r, fromDegree, degrees);
			fromDegree += degrees;

			g.setColor(Color.ORANGE);
			degrees = countToDegrees(4, total);
			drawSector(g, x, y, r, fromDegree, degrees);
			fromDegree += degrees;

			g.setColor(Color.CYAN);
			degrees = countToDegrees(4, total);
			drawSector(g, x, y, r, fromDegree, degrees);
			fromDegree += degrees;

		} else {
			g.setColor(Color.LIGHT_GRAY);
			drawSector(g, x, y, r, fromDegree, 360);
		}
	}

	private void drawSector(Graphics g, int x, int y, int r, int fromDegree,
			int degrees) {
		if (degrees > 359)
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
		else
			g.fillArc(x - r, y - r, 2 * r, 2 * r, fromDegree, degrees);
	}

	private int countToDegrees(int count, int total) {
		int degrees = (int) (((double) count / (double) total) * 360.0 + 0.5);
		return degrees;
	}

	private void drawLegend(Graphics g, int x, int y, int r) {

		y += (r + 20);
		g.setColor(Color.BLACK);

		g.drawString("data1" + "=" + 4, x - r - r - r / 4, y);

		g.drawString("data2" + "=" + 4, x - r - r / 2, y);

		g.drawString("data3" + "=" + 4, x - r / 2, y);

		g.drawString("data4" + "=" + 4, x + r / 2, y);

		g.drawString("data5" + "=" + 4, x + r + r / 2, y);

		y += 5;
		x -= 2;
		g.setColor(Color.RED);
		g.fillRect(x - r - r - r / 4, y, 10, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x - r - r / 2, y, 10, 10);
		g.setColor(Color.BLUE);
		g.fillRect(x - r / 2, y, 10, 10);
		g.setColor(Color.ORANGE);
		g.fillRect(x + r / 2, y, 10, 10);
		g.setColor(Color.CYAN);
		g.fillRect(x + r + r / 2, y, 10, 10);
	}

}
