package animegular

import java.awt.Color
import animegular.Move.Point

object Figures {
  def rectangle(pos: Point, width: Int, height: Int, color: Color) = {
    val halfWidth = width / 2
    val halfHeight = height / 2

    Poly(
      List(
        Point(-halfWidth, halfHeight),
        Point(halfWidth, halfHeight),
        Point(halfWidth, -halfHeight),
        Point(-halfWidth, -halfHeight)) map (pos + _),
      pos,
      color)
  }

  def regularPolygon(pos: Point, radius: Int, n: Int, color: Color) = {
    val forRotate = pos + Point(radius, 0)
    val centralAngle = (2.0 * math.Pi) / n
    val points =
      (0 to n - 1) map (φ =>
        forRotate.noncentralRotate(centralAngle * φ, pos))
    Poly(points.toList, pos, color)
  }
}
