class Angle(private var rad:Double) {
  recenter()

  private def recenter():Unit = {
    this.rad = this.rad % (2*math.Pi)
    while(rad < 0) rad = rad + 2*math.Pi
  }

  def + (other:Angle):Angle = {
    val thing = new Angle(this.rad + other.rad)
    thing
  }
  def + (amt:Double):Angle = {
    new Angle(this.rad + amt)
  }
  def += (other:Angle):Unit = {
    this.rad += other.rad
    recenter()
  }
  def += (amt:Double):Unit = {
    this.rad += amt
    recenter()
  }

  def apply(amt:Double):Angle = {
    new Angle(this.rad + amt)
  }

  def unary_- :Angle = {
    new Angle(-this.rad)
  }

  def * (scalar:Double):Angle = {
    new Angle(this.rad * scalar)
  }
  def *= (scalar:Double):Unit = {
    this.rad *= scalar
    recenter()
  }

  def radians:Double = { rad }
  def radians_=(amt:Double):Unit = {
    rad = amt
    recenter()
  }

  def degrees:Double = { rad / math.Pi * 180 }
  def degrees_=(amt:Double):Unit = {
    rad = amt / 180 * math.Pi
    recenter()
  }
  
  override def toString():String = rad.toString()

}

object Angle {
  def apply():Angle = new Angle(0)
  def apply(amt:Double):Angle = {
    val tmp = new Angle(amt)
    tmp
  }

  val PI = Angle(math.Pi)

  def main(args:Array[String]):Unit = {
    println("Hello world!")
    val a = new Angle(math.Pi)
    val b = Angle() //Angle.apply()
    val c = Angle(3*math.Pi/4) //Angle.apply(3*math.Pi/4)
    println(b)
    println(Angle.PI)

  }

}


