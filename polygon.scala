package polygons

import javax.swing._

import java.awt.Color
import java.awt.Graphics2D

class Polygon (points : List[GeneralVector], center : GeneralVector, color : Color) {
  def rotate(φ : Double) = {
    def noncentralRotation(v1 : GeneralVector, v2 : GeneralVector) =
      ((v1 - v2) rotate φ) + v2
    new Polygon (points map (noncentralRotation(_, center)),
      center,
      color)
  }

  def move(δv : GeneralVector) =
    new Polygon (points map (δv + _), center + δv, color)

  def draw(g : Graphics2D) {
    val (xpoints, ypoints) = (points map (_.asTuple)).unzip
    g.setColor(color)
    g.fillPolygon(xpoints.toArray map (_.toInt),
                  ypoints.toArray map (_.toInt),
                  points.length)
  }
}
