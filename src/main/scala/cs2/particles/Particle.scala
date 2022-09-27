package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

class Particle(private var pos:Vec2, private var vel:Vec2) {
  private val col:Color = Color.rgb(scala.util.Random.nextInt(256),
                                    scala.util.Random.nextInt(256),
                                    scala.util.Random.nextInt(256))
  private val r:Double = 20

  def display(g:GraphicsContext):Unit = {
    g.setFill(col)
    g.fillOval(this.pos.x, this.pos.y, this.r*2, this.r*2)
  }

  def timeStep():Unit = {
    pos += vel
  }
  
}