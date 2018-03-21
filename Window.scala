package animegular

//import scalaz._
//import Scalaz._

import java.awt.{Color, Graphics2D, RenderingHints}
import java.awt.image.BufferedImage
import javax.swing.{JFrame, JPanel}

import animegular.Move.Point

class Window(
  width: Int,
  height: Int,
  fps: Int,
  getPolygons: () => List[Poly],
  initialState: List[Poly]) extends JFrame("Some Swing Application") {

  import JFrame._
  import java.awt.Dimension
  import java.awt.event.ActionEvent
  import javax.swing.Timer

  setDefaultLookAndFeelDecorated(true)
  setDefaultCloseOperation(EXIT_ON_CLOSE)

  private val panel = new JPanel
  getContentPane add panel

  pack()

  override val size = new Dimension(width, height)

  setSize(size.width, size.height)
  setVisible(true)
  setResizable(false)

  //var lastState: List[Poly] = initialState

  val img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB)
  val g2 = img.getGraphics.asInstanceOf[Graphics2D]

  def paintPanel(g: Graphics2D)(e: ActionEvent) {
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON)
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
      RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

    g2.setColor(Color.white)
    g2.fillRect(0, 0, size.width, size.height)

    //lastState = transformPolygons(lastState)
    //lastState map (_ draw g2)
    (getPolygons()) map (_ draw g2)

    g.drawImage(img, 0, 0, null)
  }

  val graphics = panel.getGraphics.asInstanceOf[Graphics2D]

  val timer = new Timer (1000 / fps, paintPanel(graphics))
  timer.start

}
