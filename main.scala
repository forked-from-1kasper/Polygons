package polygons

import javax.swing._

import java.awt.image.BufferedImage
import java.awt.image.ImageObserver

import java.awt.RenderingHints
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D

class MyWindow extends JFrame("Some Swing application") {
  import java.awt.Dimension
  import javax.swing.Timer
  import java.awt.event.ActionEvent

  import JFrame._

  setDefaultLookAndFeelDecorated(true)
  setDefaultCloseOperation(EXIT_ON_CLOSE)

  val panel = new JPanel
  getContentPane() add panel

  pack

  override val size = new Dimension(800, 600)

  setSize(size.width, size.height)
  setVisible(true)
  setResizable(false)

  var p1 = new Polygon(
      List(
        GeneralVector(100, 100),
        GeneralVector(300, 100),
        GeneralVector(100, 300),
        GeneralVector(300, 300)),
      GeneralVector(200, 200),
      Color.blue)
  var p2 = new Polygon(
      List(
        GeneralVector(300, 300),
        GeneralVector(300, 400),
        GeneralVector(500, 500),
        GeneralVector(400, 300)),
      GeneralVector(400, 400),
      Color.blue)

  def paintPanel(g : Graphics2D)(e : ActionEvent) {
    val img = new BufferedImage(size.width, size.height,
      BufferedImage.TYPE_INT_RGB)
    val g2 = img.getGraphics.asInstanceOf[Graphics2D]

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON)
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

    g2.setColor(Color.white)
    g2.fillRect(0, 0, size.width, size.height)

    p1 = (p1 rotate (math.Pi / 180.0)) move GeneralVector(1, 1)
    p2 = p2 rotate (math.Pi / 360.0)

    p1 draw g2
    p2 draw g2

    g2.dispose

    g.clearRect(0, 0, size.width, size.height)
    g.drawImage(img, 0, 0, null)
  }

  val graphics = panel.getGraphics.asInstanceOf[Graphics2D]

  val timer = new Timer (35, paintPanel(graphics))
  timer.start
}

object GraphicsApp {
  def main(args : Array[String]): Unit = {
    val win = new MyWindow
  }
}
