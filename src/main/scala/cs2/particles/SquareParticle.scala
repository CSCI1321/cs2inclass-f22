package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class SquareParticle(p:Vec2, v:Vec2) extends Particle(p,v) {

  override def display(g:GraphicsContext):Unit = {
    g.setFill(this.col)
    g.fillRect(this.pos.x, this.pos.y, this.r*2, this.r*2)
  }

}