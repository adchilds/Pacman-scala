import java.awt.{Color, Dimension, Font, Graphics, Image, Point}
import java.awt.event.{ActionEvent, ActionListener, KeyEvent, KeyListener, MouseEvent, MouseListener}
import java.text.DecimalFormat
import java.util.Random
import javax.swing.{ImageIcon, JFrame, JOptionPane}

/**
 * The UserInterface class handles the view of the game and input
 * from the user.
 * 
 * @author Adam Childs
 * @version 0.01
 * @since 0.01
 */
class UserInterface extends JFrame with ActionListener with KeyListener with MouseListener
{
	private var start_menu_initiated = false
	private var game_objects_initialized = false
	private var keyPressed = false
	private val version = 0.01
	private val aPos = new Point(275, 260)
	private var arrow_pos = Arrow_Pos.START_GAME
	private var game_state = Game_State.START_SCREEN
	private var f: Font = null
	private var image: Image = null
	private var graphics: Graphics = null
	private val start_menu = loadImage( "start_menu.jpeg" )
	private val start_menu_arrow: ImageIcon = loadImage( "start_menu_arrow.png" )

	def createAndShowGUI
	{
		addKeyListener(this)
		addMouseListener(this)

		// Testing out some different scala syntax styles
		// bear with me here
		this setTitle "Pacman"
		this setContentPane getContentPane
		this setSize new Dimension(405, 405)
		this setResizable false
		this setFocusable true
		this setLocationRelativeTo null
		this setDefaultCloseOperation JFrame.EXIT_ON_CLOSE
		this setVisible true
	}

	def loadImage(i: String): ImageIcon =
	{
		new ImageIcon(getClass().getResource("images/" + i))
	}

	override def paint(g: Graphics): Unit =
	{
		image = createImage(getWidth, getHeight)
		graphics = image.getGraphics
		
		paintComponent(graphics)
		g.drawImage(image, 0, 0, null)
		
		repaint()
	}

	def paintComponent(g: Graphics): Unit =
	{
		/*
		 * Check what the current game_state is and draw
		 * images according to the current state
		 */
		if (game_state == Game_State.START_SCREEN)
		{
			g.drawImage(start_menu.getImage, 0, 0, 405, 405, null)

			// Set the arrow point to the correct String
			if (keyPressed) // Only update is a key has been pressed
			{
				if (arrow_pos == Arrow_Pos.START_GAME)
					aPos.setLocation(275, 260)
				else if (arrow_pos == Arrow_Pos.CREDITS)
					aPos.setLocation(250, 290)
				else if (arrow_pos == Arrow_Pos.HELP)
					aPos.setLocation(235, 320)
				else if (arrow_pos == Arrow_Pos.QUIT)
					aPos.setLocation(235, 350)
				else
					aPos.setLocation(aPos.getLocation())

				keyPressed = false
			}
			g.drawImage(start_menu_arrow.getImage, aPos x, aPos y, 45, 23, null)

			f = new Font("Dialog", Font.PLAIN, 25)
			drawString(g, "Start Game", 135, 280, Color.YELLOW, f)
			drawString(g, "Credits", 160, 310, Color.YELLOW, f)
			drawString(g, "Help", 175, 340, Color.YELLOW, f)
			drawString(g, "Quit", 175, 370, Color.YELLOW, f)
		}
	}

	/**
	 * Helper function to control drawing text to the screen in the specified
	 * location, color, font, and size.
	 * 
	 * @param g The graphics context to draw to
	 * @param s The String of text to render
	 * @param x X position
	 * @param y Y position
	 * @param c Color of the text
	 * @param f Font styling for the text, i.e.: new Font("Dialog", Font.PLAIN, 20)
	 */
	def drawString(g: Graphics, s: String, x: Int, y: Int, c: Color, f: Font)
	{
		g.setFont(f)
		g.setColor(c)
		g.drawString(s, x, y)
	}

	@Override
	def actionPerformed(e: ActionEvent): Unit =
	{
	  
	}

	@Override
	def keyPressed(e: KeyEvent): Unit =
	{
		keyPressed = true
		
		if (e.getKeyCode == KeyEvent.VK_W || e.getKeyCode == KeyEvent.VK_UP)
		{
			if (game_state == Game_State.START_SCREEN)
			{
				/*
				 * Check the arrows current location and move it accordingly
				 */
				if (arrow_pos == Arrow_Pos.START_GAME)
					arrow_pos = Arrow_Pos.QUIT
				else if (arrow_pos == Arrow_Pos.CREDITS)
					arrow_pos = Arrow_Pos.START_GAME
				else if (arrow_pos == Arrow_Pos.HELP)
					arrow_pos = Arrow_Pos.CREDITS
				else
					arrow_pos = Arrow_Pos.HELP
			} else if (game_state == Game_State.IN_GAME) {
				
			}
		}
		else if (e.getKeyCode == KeyEvent.VK_S || e.getKeyCode == KeyEvent.VK_DOWN)
		{
			if (game_state == Game_State.START_SCREEN)
			{
				/*
				 * Check the arrows current location and move it accordingly
				 */
				if (arrow_pos == Arrow_Pos.START_GAME)
					arrow_pos = Arrow_Pos.CREDITS
				else if (arrow_pos == Arrow_Pos.CREDITS)
					arrow_pos = Arrow_Pos.HELP
				else if (arrow_pos == Arrow_Pos.HELP)
					arrow_pos = Arrow_Pos.QUIT
				else
					arrow_pos = Arrow_Pos.START_GAME
			} else if (game_state == Game_State.IN_GAME) {
				
			}
		} else if (e.getKeyCode == KeyEvent.VK_LEFT || e.getKeyCode == KeyEvent.VK_A) {
			if (game_state == Game_State.START_SCREEN)
			{
				
			} else if (game_state == Game_State.IN_GAME) {
				
			}
		} else if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_D) {
			if (game_state == Game_State.START_SCREEN)
			{
				
			} else if (game_state == Game_State.IN_GAME) {
				
			}
		} else if (e.getKeyCode == KeyEvent.VK_ENTER) {
			/*
			 * Check the arrows current location and choose
			 * the correct action
			 */
			if (arrow_pos == Arrow_Pos.START_GAME)
			{
				game_state = Game_State.IN_GAME
				
//				lh = new LevelHandler
			} else if (arrow_pos == Arrow_Pos.CREDITS) {
				JOptionPane.showMessageDialog(this,
						"Adam Childs - adchilds@eckerd.edu",
						"Credits",
						JOptionPane.INFORMATION_MESSAGE)
			} else if (arrow_pos == Arrow_Pos.HELP) {
				val fmt = new DecimalFormat("#0.00")
				JOptionPane.showMessageDialog(this,
						"Current version: v" + fmt.format(version) + "\n" +
						"Created by Adam Childs" + "\n" +
						"adchilds@eckerd.edu",
						"Pacman v" + fmt.format(version),
						JOptionPane.INFORMATION_MESSAGE)
			} else if (arrow_pos == Arrow_Pos.QUIT) {
				System.exit(0)
			}
		}
	}

	@Override
	def keyReleased(e: KeyEvent): Unit =
	{
	  
	}

	@Override
	def keyTyped(e: KeyEvent): Unit =
	{
	  
	}

	@Override
	def mouseClicked(e: MouseEvent): Unit =
	{
		println("(" + e.getX + ", " + e.getY + ")")
	}

	@Override
	def mouseEntered(e: MouseEvent): Unit =
	{
		
	}

	@Override
	def mouseExited(e: MouseEvent): Unit =
	{
	  
	}

	@Override
	def mousePressed(e: MouseEvent): Unit =
	{
		
	}

	@Override
	def mouseReleased(e: MouseEvent): Unit =
	{
		
	}
}

/*
 * Start screens current arrow position
 */
object Arrow_Pos extends Enumeration
{
	type Arrow_Pos = Value
	val START_GAME, CREDITS, HELP, QUIT = Value
}

/*
 * Current game state
 */
object Game_State extends Enumeration
{
	type Game_State = Value
	val START_SCREEN, IN_GAME, GAME_OVER = Value
}