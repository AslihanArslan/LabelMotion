import java.awt.Component;
import java.awt.EventQueue;
import java.awt.PageAttributes;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LabelMotion {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelMotion window = new LabelMotion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LabelMotion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.addKeyListener(new KeyAdapter() {
			
			
		});
		lblWelcome.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				double x=e.getPoint().getX();
				double y=e.getPoint().getY();
				
				System.out.println("clicked at x=" +x + "and y="+ y);
				
				
				Point locationInFrame = SwingUtilities.convertPoint(e.getComponent(),
						e.getPoint(), e.getComponent().getParent());
				
				System.out.println("clicked at x=" +locationInFrame.getX() + "and y="+ locationInFrame.getY());
				
				
				e.getComponent().setLocation(locationInFrame);
				
				e.getComponent().getParent().repaint();
				
			}
		});
		

		lblWelcome.addMouseListener(new MouseAdapter() {//
			@Override
			public void mouseClicked(MouseEvent e) {
				double x=e.getPoint().getX();
				double y=e.getPoint().getY();
				
				System.out.println("clicked at x=" +x + "and y="+ y);
				
				
				Point locationInFrame = SwingUtilities.convertPoint(e.getComponent(),
						e.getPoint(), e.getComponent().getParent());
				
				System.out.println("clicked at x=" +locationInFrame.getX() + "and y="+ locationInFrame.getY());
				
				locationInFrame.setLocation(locationInFrame.getX()+10, locationInFrame.getY()+10);
				e.getComponent().setLocation(locationInFrame);
				
				e.getComponent().getParent().repaint();
			}
		});//
		lblWelcome.setBounds(219, 136, 63, 22);
		frame.getContentPane().add(lblWelcome);
	}
}
