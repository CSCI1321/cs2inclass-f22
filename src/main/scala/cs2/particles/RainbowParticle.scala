package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color

class RainbowParticle(p:Vec2,v:Vec2) extends RoundParticle(p,v) {

  private var hue:Double = 0

  override def timeStep():Unit = {
    super.timeStep()
    col = Color.hsb(hue, 0.95,0.95)
    hue += 0.5
  }


}