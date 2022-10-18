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

  def isDead():Boolean = {
    if(pos.x < 0 || pos.x > 800 || pos.y < 0 || pos.y > 800) true
    else false
  }

  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(force:Vec2):Unit = {
    vel += force
  }
  
}