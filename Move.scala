package animegular

object Move {
  type Point = V
  def Point(x: Int, y: Int) = V(x,y)

  type Movement = V
  def Movement(x: Int, y: Int) = V(x, y)

  type Movements = List[Movement]
  def Movements(ms: Movement*) = List(ms: _*)
}
