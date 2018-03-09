package animegular

case class V(x: Double, y: Double) {

  import math._

  val asTuple: (Double, Double) = (x, y)

  def +(other: V): V = other match {
    case V(x̂, ŷ) => V(x + x̂, y + ŷ)
  }

  def unary_-(): V = V(-x, -y)

  def -(other: V): V = this + (-other)

  def *(k: Double): V = V(x * k, y * k)

  def rotate(φ: Double): V = V(x * cos(φ) - y * sin(φ), x * sin(φ) + y * cos(φ))

}
