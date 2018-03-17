package animegular

//import scalaz._
//import Scalaz._

import java.awt.Color
import animegular.Move.Point

object GraphicsApp extends App {
  val p1: Poly =
    Figures.rectangle(Point(200, 200), 100, 50, Color.blue)

  val p2 =
    Figures.regularPolygon(Point(400, 400), 50, 7, Color.blue)
  val polygons = List(p1, p2)

  def transform(source: List[Poly]) = {
    def transformPoly(tuple: (animegular.Poly, Int)) = {
      val (p, index) = tuple
      index match {
        case 0 => (p rotate (math.Pi / 180.0)) move Vector2D(1.0, 1.0)
        case 1 => p rotate math.Pi / 360.0
        case _ => p
      }
    }
    source.zipWithIndex map transformPoly
  }

  val win = new Window(800, 600, fps = 30, transform, polygons)
}
