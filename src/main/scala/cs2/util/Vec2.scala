package cs2.util

class Vec2(var x:Double, var y:Double) {
  def += (other:Vec2):Unit = {
    this.x += other.x
    this.y += other.y
  }

  override def clone():Vec2 = {
    new Vec2(x,y)
  }
}