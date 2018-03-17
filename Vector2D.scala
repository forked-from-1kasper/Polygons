package animegular

case class Vector2D(x: Double, y: Double) {

  import math._

  val asTuple: (Double, Double) = (x, y)

  def +(other: Vector2D): Vector2D = other match {
    case Vector2D(n, m) => Vector2D(x + n, y + m)
  }

  def unary_-(): Vector2D = Vector2D(-x, -y)

  def -(other: Vector2D): Vector2D = this + (-other)

  def *(k: Double): Vector2D = Vector2D(x * k, y * k)

  def rotate(φ: Double): Vector2D = Vector2D(x * cos(φ) - y * sin(φ), x * sin(φ) + y * cos(φ))

}
