import java.awt.*;
import java.awt.event.*;

/**@author Kaspar Winston
 */
class GraphingCalculator extends Frame
{
	public static void main(String[] args)
	{
		new GraphingCalculator();
	}

	GraphingCalculator()
	{
		super("Graphing Calculator");

		// Terminate when window is closed
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		setSize(1000, 1000);
		add("Center", new CvGraphingCalculator());
		setVisible(true);
	}

	class CvGraphingCalculator extends Canvas
	{
		public void paint(Graphics g)
		{
			Dimension d;
			int maxX, maxY;

			// get the size of the canvas
			d = getSize();

			maxX = d.width - 1;
			maxY = d.height - 1;
			
			drawGraph(g, maxX, maxY);
			equation(g, maxX, maxY, 100, 100, true);
		}

		/** @param g awt graphics
		 * @param maxX max y coordinate (top and bottom edges of the graph)
		 * @param maxY max y coordinate (right and left edges of the graph)
		 * @param scale scale of the graph (how "zoomed in" it is)
		 * @param resolution resolution of the graph (space between each point drawn; higher resolution = closer together)
		 */
		void equation(Graphics g, int maxX, int maxY, int scale, int resolution)
		{
			float x, y;

			// set the origin at the center of the canvas
			g.translate(maxX / 2, maxY / 2);

			g.setColor(Color.black);

			for (x = -(maxX / 2); x < maxX / 2; x += (float) .01 / resolution)
			{
				y = (float)
				-(
			   		// equation goes here
					Math.sin(100 * x) + Math.sin(x)
				);

				g.drawLine(Math.round(x * scale), Math.round(y * scale), Math.round(x * scale), Math.round(y * scale));
			}
		}

		/** @param g awt graphics
		 * @param maxX max y coordinate (top and bottom edges of the graph)
		 * @param maxY max y coordinate (right and left edges of the graph)
		 */
		void drawGraph(Graphics g, int maxX, int maxY)
		{
			int midX = maxX / 2;
			int midY = maxY / 2;

			// draw x and y axis
			g.setColor(Color.lightGray);
			g.drawLine(0, midY, maxX, midY);
			g.drawLine(midX, 0, midX, maxY);
		}
	}
}
