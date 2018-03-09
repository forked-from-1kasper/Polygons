package animegular

object Move {
  type Point = V
  def Point(x: Int, y: Int) = V(x,y)

  type Movements = List[Point]
  def Movements(ms: Point*) = List(ms: _*)
}
