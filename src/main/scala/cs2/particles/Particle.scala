package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

abstract class Particle(protected var pos:Vec2, protected var vel:Vec2) {
  protected var col:Color = Color.rgb(scala.util.Random.nextInt(256),
                                    scala.util.Random.nextInt(256),
                                    scala.util.Random.nextInt(256))
  protected val r:Double = 20

  def display(g:GraphicsContext)

  def timeStep():Unit = {
    pos += vel
  }
  
}