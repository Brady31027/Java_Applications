import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BubblePanel extends JPanel {

	private List<Bubble> bubbleList;
	private int size = 30;
	
	private class Bubble {
		private int x, y, size;
		private Color color;
		
		public Bubble(int newX, int newY, int newSize) {
			x = newX;
			y = newY;
			size = newSize;
			color = new Color( (float) Math.random(), 
					           (float) Math.random(), 
					           (float) Math.random());
		}
	}
	
	private class BubbleListener implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(), e.getY(), size));
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(), e.getY(), size));
			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public BubblePanel() {
		bubbleList = new ArrayList<Bubble>();
		
		addMouseListener( new BubbleListener());
		addMouseMotionListener( new BubbleListener());
		
		setBackground(Color.BLACK);
		setPreferredSize( new Dimension(800, 480));
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		for (Bubble b: bubbleList) {
			page.setColor(b.color);
			page.fillOval(b.x - b.size / 2 , 
					      b.y - b.size / 2, 
					      b.size, 
					      b.size);
		}
		
		page.setColor(Color.GREEN);
		page.drawString("Count: "+bubbleList.size(), 30, 30);
	}
	
}
