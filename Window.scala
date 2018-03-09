package animegular

import java.awt.{Color, Graphics2D, RenderingHints}
import java.awt.image.BufferedImage
import javax.swing.{JFrame, JPanel}

import animegular.Move.{Movements, Point}

class Window(width: Int, height: Int, fps: Int) extends JFrame("Some Swing Application") {

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


  var p1: Poly = Poly(
    Movements(
      Point(100, 100),
      Point(300, 100),
      Point(100, 300),
      Point(300, 300),
    ),
    Point(200, 200),
    Color.blue
  )

  var p2 = Poly(
    Movements(
      Point(300, 300),
      Point(300, 400),
      Point(500, 500),
      Point(400, 300),
    ),
    Point(400, 400),
    Color.blue
  )

  def paintPanel(g: Graphics2D)(e: ActionEvent) {

    val img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB)
    val g2 = img.getGraphics.asInstanceOf[Graphics2D]

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON)
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
      RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

    g2.setColor(Color.white)
    g2.fillRect(0, 0, size.width, size.height)

    p1 = p1 rotate (math.Pi / 180.0)
    p2 = p2 rotate (math.Pi / 360.0)

    p1 draw g2
    p2 draw g2

    g2.dispose()

    g.clearRect(0, 0, size.width, size.height)
    g.drawImage(img, 0, 0, null)
  }

  val graphics = panel.getGraphics.asInstanceOf[Graphics2D]

  val timer = new Timer (fps, paintPanel(graphics))
  timer.start

}

object Window {
  def apply(width: Int, height: Int, fps: Int): Window = new Window(width, height, 1000 / fps)
}