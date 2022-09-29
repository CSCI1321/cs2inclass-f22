package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class RoundParticle(p:Vec2,v:Vec2) extends Particle(p,v) {

  override def display(g: GraphicsContext):Unit = {
    g.setFill(col)
    g.fillOval(this.pos.x, this.pos.y, this.r*2, this.r*2)
  }

}