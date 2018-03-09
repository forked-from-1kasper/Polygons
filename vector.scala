package polygons

case class GeneralVector (x : Double, y : Double) {
  val asTuple = (x, y)

  def +(other : GeneralVector) = other match {
    case GeneralVector(x̂, ŷ) => GeneralVector(x + x̂, y + ŷ)
  }

  def unary_-() = GeneralVector(-x, -y)
  def -(other : GeneralVector) = this + (-other)
  def *(k : Double) = GeneralVector(x * k, y * k)

  def rotate(φ : Double) =
    GeneralVector(x * math.cos(φ) - y * math.sin(φ),
                  x * math.sin(φ) + y * math.cos(φ))
}
