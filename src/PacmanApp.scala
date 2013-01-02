import javax.swing.SwingUtilities

/**
 * The PacmanApp class handles loading the program in a thread-safe manner.
 * 
 * @author Adam Childs
 * @version 0.01
 * @since 0.01
 */
object PacmanApp
{
	def main(args: Array[String]): Unit = 
	{
		SwingUtilities.invokeLater(
			new Runnable 
			{
				def run(): Unit = 
				{
					new UserInterface().createAndShowGUI
				}
			}
		)
	}
}