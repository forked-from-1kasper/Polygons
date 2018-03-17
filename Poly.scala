package animegular

import scala.language.postfixOps

import java.awt.{Color, Graphics2D}

import Move._

//import scalaz._
//import Scalaz._

case class Poly(points: List[Point], center: Point, color: Color) {

  def rotate(φ : Double): Poly = {

    def noncentralRotation(v1: Point, v2: Point) =
      ((v1 - v2) rotate φ) + v2

    Poly(points map (noncentralRotation(_, center)), center, color)

  }

  def move(δv: Point): Poly = Poly(points map (δv + _), center + δv, color)

  def draw(g: Graphics2D) {

    val (xpoints, ypoints) = (points map (_.asTuple)) unzip

    g.setColor(color)
    g.fillPolygon(xpoints.toArray map (_.toInt), ypoints.toArray map (_.toInt), points.length)

  }
}
