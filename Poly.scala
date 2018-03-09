package animegular

import java.awt.{Color, Graphics2D}

import Move._

class Poly(points: Movements, center: Point, color: Color) {

  def rotate(φ : Double): Poly = {

    def noncentralRotation(v1: Movement, v2: Movement) =
      ((v1 - v2) rotate φ) + v2

    new Poly (points map (noncentralRotation(_, center)), center, color)

  }

  def move(δv: Movement): Poly = new Poly (points map (δv + _), center + δv, color)

  def draw(g: Graphics2D) {

    val (xpoints, ypoints) = (points map (_.asTuple)).unzip

    g.setColor(color)
    g.fillPolygon(xpoints.toArray map (_.toInt),
      ypoints.toArray map (_.toInt),
      points.length)

  }
}

object Poly {
  def apply(points: Movements, center: Point, color: Color): Poly = new Poly(points, center, color)
}