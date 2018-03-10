package animegular

import scalaz._
import Scalaz._

import java.awt.Color

import animegular.Move.{Movements, Point}

object GraphicsApp extends App {
  val p1: Poly = Poly(
    Movements(
      Point(100, 100),
      Point(300, 100),
      Point(100, 300),
      Point(300, 300),
    ),
    Point(200, 200),
    Color.blue
  )

  val p2 = Poly(
    Movements(
      Point(300, 300),
      Point(300, 400),
      Point(500, 500),
      Point(400, 300),
    ),
    Point(400, 400),
    Color.blue
  )
  val polygons = List(p1, p2)

  def transform(source: List[Poly]) = {
    def transformPoly(tuple: (animegular.Poly, Int)) = {
      val (p, index) = tuple
      index match {
        case 0 => (p rotate (math.Pi / 180.0)) move V(1.0, 1.0)
        case 1 => p rotate math.Pi / 360.0
        case _ => p
      }
    }
    source.zipWithIndex ∘ transformPoly
  }

  val win = new Window(800, 600, fps = 24, transform, polygons)
}
