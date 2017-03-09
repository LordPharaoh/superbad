import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class MovingObjectsPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	final Dimension defaultDim;// = new Dimension(800,600);
	public static final int FRAME_RATE = 30;
	GameMap gm;
	private Timer t;// belongs to the class


	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		//TODO decouple painting and ticking (low priority)
		//Do the gamemap here
		gm = new SuperbadGameMap(defaultDim);// let the map know what dim is
		setUpKeyMappings();
		t = new Timer(1000/FRAME_RATE, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();// I tell the GameMap to tick... do what
					// you do every time the clock goes off.
				repaint();// naturally, we want to see the new view

				//This sketchy stuff requests a mouse location every frame so it repaints
		        //MouseInfo.getPointerInfo().getLocation();
			}
		});
		t.start();


	}
	private void setUpClickListener() {
		// Whoever has focus is who can interact with mouse and keyboard, etc
		this.requestFocusInWindow();

		// similar to having an entity ready to interact with the Mouse
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// when the mouse enters the panel, this is called

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// duh...

			}

			@Override
			public void mousePressed(MouseEvent click) {
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// use this to find out when the mouse was released

			}

		});

	}


	private void setUpKeyMappings() {
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		//this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"Jump");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"),"left");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"),"right");
		this.getInputMap().put(KeyStroke.getKeyStroke("W"),"jump");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"),"crouch");
		//Note from Nate - I think that we should implement shooting in the form of clicking the mouse
		//And have a type of aiming system (A line extending from the gun) to indicate where the bullet will go
		//based on the aiming of the mouse pointer. Just a thought

		//  This associates the command shoot with some action.  In this
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...

		/*this.getActionMap().put("shoot",new AbstractAction(){

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((SuperbadGameMap) gm).shoot();
			}
		});*/

		this.getActionMap().put("left",new AbstractAction(){
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((SuperbadGameMap) gm).move("left");
			}
		});

		this.getActionMap().put("right",new AbstractAction(){
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((SuperbadGameMap) gm).move("right");
			}
		});

		this.getActionMap().put("jump",new AbstractAction(){
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((SuperbadGameMap) gm).move("jump");
			}
		});

		this.getActionMap().put("crouch",new AbstractAction(){
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((SuperbadGameMap) gm).move("crouch");
			}
		});


		this.requestFocusInWindow();
	}




	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO paint gamemap
		gm.draw(g);
	}

}
