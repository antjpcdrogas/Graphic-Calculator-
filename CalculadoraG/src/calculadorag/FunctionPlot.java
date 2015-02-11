package calculadorag;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.function.Function;

import javax.swing.JPanel;

/**
 * A Functional Plot2D. No abstract plot yet implemented but this works.
 * @author james
 *
 */
public class FunctionPlot extends JPanel implements ComponentListener{
	
	// Instance Variables.
	private static final long serialVersionUID = -7220817713786168906L;

	/** The function of x to plot. */
	protected Function function = null;
	
	/** The min and max x Values */
	protected double xMin = 0, xMax = 0;

	/** 
	 * Whether or not to invert the Y axis.
	 * Default to true (as screen x,y are the inverse of traditional x,y)
	 * TODO implement this, currently unused.
	 */
	protected boolean invertY = true;
	
	/**
	 * Create a new Plot2D panel.
	 * @param function
	 * @param xMin
	 * @param xMax
	 */
	public FunctionPlot(Function function, double xMin, double xMax){
		
		this.function = function;
		this.xMin = xMin;
		this.xMax = xMax;
		
		repaint(); // Paint the graph
		
		
		if(null == function){
			//TODO handle error.
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		// Get essetial values.
		int width = this.getWidth();
		int height = this.getHeight();
		

		
		// Calculate y values.
		java.util.Vector<Double> y = new java.util.Vector<>();
		double xStep = (xMax-xMin)/(width*10);
		
		for(double i = xMin; i < xMax; i+=xStep){
			//y.add(new Double(function.eval(i)));
		}
		
		double yMax = -Double.MAX_VALUE;
		double yMin = Double.MAX_VALUE;
		for(Double value : y){
			if(value > yMax) yMax = value;
			if(value < yMin) yMin = value;
		}
		
		// Set up graphics object.
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw Axes
		g2.setColor(Color.BLACK);
		g2.drawLine(0, height/2, width, height/2);
		g2.drawLine(width/2, 0, width/2, height);
		
		// Draw graph
		g2.setColor(Color.BLUE);
		
		// Calculate ratios.
		double xRatio = width/(xMax-xMin);
		double yRatio = height/(yMax-yMin);
		
		for(int i = 0; i < y.size() - 1; i++){
			
			/*
			Calculate x and y values. This is done by:
			- Invert if y and if invertY -- Not implemented, currently always inverts.
			- Multiply by Ratio (i.e. *width, /range)
			- Optionally subtract min*ratio (make minimum be at 0) -- Not implemented
			- add width/2 (or height for y values)
			- Round to nearest int and plot
			*/
			
			double x1 = xMin+xStep*i;
			x1 = (x1*xRatio) + (width/2);
			double y1 = y.get(i);
			y1 = (-y1*yRatio) + (height/2);
			double x2 = xMin+xStep*(i+1);
			x2 = (x2*xRatio) + (width/2);
			double y2 = y.get(i+1);
			y2 = (-y2*yRatio) + (height/2);
			
			// Test plottability
			Double yTest1 = new Double(y1);
			Double yTest2 = new Double(y2);
			if(yTest1.isInfinite() || yTest1.isNaN() || yTest2.isInfinite() || yTest2.isNaN()){
				// Do Nothing.
			}
			else{
				g2.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
			}
		}
	}



	@Override
	public void componentResized(ComponentEvent e) {
		this.repaint();
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
	
}