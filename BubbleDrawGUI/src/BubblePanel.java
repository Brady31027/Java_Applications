import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BubblePanel extends JPanel {

	private List<Bubble> bubbleList;
	private int size = 30;
	private int fps = 33;// 33ms
	private Timer timer;
	private JTextField textSize;
	private JTextField textFps;
	
	private class Bubble {
		private int x, y, size, x_diff, y_diff;
		private Color color;
		
		public Bubble(int newX, int newY, int newSize) {
			x = newX;
			y = newY;
			size = newSize;
			color = new Color( (float) Math.random(), 
					           (float) Math.random(), 
					           (float) Math.random(),
					           (float) Math.random());
			x_diff = (int)((Math.random() - 0.5 ) * 10 + 1);
			y_diff = (int)((Math.random() - 0.5 ) * 10 + 1);
		}
		
		private void update() {
			x += x_diff;
			y += y_diff;
		}
	}
	
	private class BubbleListener implements MouseListener, MouseMotionListener, ActionListener {
		
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

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (Bubble b: bubbleList) {
				b.update();
			}
			repaint();
		}
		
	}
	
	public BubblePanel() {
		bubbleList = new ArrayList<Bubble>();
		
		addMouseListener( new BubbleListener());
		addMouseMotionListener( new BubbleListener());
		timer = new Timer(fps, new BubbleListener());
		
		setBackground(Color.BLACK);
		setPreferredSize( new Dimension(800, 480));
		
		JPanel controlPanel = new JPanel();
		add(controlPanel);
		
		JLabel lblSize = new JLabel("Size:");
		controlPanel.add(lblSize);
		
		textSize = new JTextField();
		textSize.setHorizontalAlignment(SwingConstants.CENTER);
		textSize.setText("30");
		controlPanel.add(textSize);
		textSize.setColumns(4);
		
		JLabel lblFps = new JLabel("FPS:");
		controlPanel.add(lblFps);
		
		textFps = new JTextField();
		textFps.setText("30");
		textFps.setHorizontalAlignment(SwingConstants.CENTER);
		controlPanel.add(textFps);
		textFps.setColumns(2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// update size and fps
				try {
					int update_fps = Integer.parseInt(textFps.getText());
					int update_size = Integer.parseInt(textSize.getText());
					timer.setDelay(1000/update_fps);
					size = update_size;
					repaint();
				}catch (Exception e) {
					// do nothing
				}
			}
		});
		controlPanel.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubbleList = new ArrayList<Bubble>();
				repaint();
			}
		});
		controlPanel.add(btnClear);
		
		timer.start();
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
		
		//page.setColor(Color.GREEN);
		//page.drawString("Count: "+bubbleList.size(), 30, 30);
	}
	
}
