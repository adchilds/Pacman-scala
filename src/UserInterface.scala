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
//	private Arrow_Pos arrow_pos = Arrow_Pos.START_GAME
//	private var f
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
		g.drawImage(start_menu.getImage, 0, 0, 405, 405, null)
	}

	@Override
	def actionPerformed(e: ActionEvent): Unit =
	{
	  
	}

	@Override
	def keyPressed(e: KeyEvent): Unit =
	{
	  
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