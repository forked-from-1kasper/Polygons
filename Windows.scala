package animegular

import javax.swing.{JFrame, JPanel}

abstract class Windows extends JFrame("Some Swing Application") {

  import JFrame._
  import java.awt.Dimension
  import java.awt.event.ActionEvent
  import javax.swing.Timer

  setDefaultLookAndFeelDecorated(true)
  setDefaultCloseOperation(EXIT_ON_CLOSE)

  private val panel = new JPanel
  getContentPane add panel

  pack()


}
