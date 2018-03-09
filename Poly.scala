package animegular

import scala.language.postfixOps

import java.awt.{Color, Graphics2D}

import Move._

import scalaz._
import Scalaz._

class Poly(points: Movements, center: Point, color: Color) {

  def rotate(φ : Double): Poly = {

    def noncentralRotation(v1: Point, v2: Point) =
      ((v1 - v2) rotate φ) + v2

    Poly(points ∘ (noncentralRotation(_, center)), center, color)

  }

  def move(δv: Point): Poly = Poly(points ∘ (δv + _), center + δv, color)

  def draw(g: Graphics2D) {

    val (xpoints, ypoints) = (points ∘ (_.asTuple)) unzip

    g.setColor(color)
    g.fillPolygon(xpoints.toArray map (_.toInt), ypoints.toArray map (_.toInt), points.length)

  }
}

object Poly {
  def apply(points: Movements, center: Point, color: Color): Poly = new Poly(points, center, color)
}
