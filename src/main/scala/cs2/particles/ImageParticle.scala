package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2, v:Vec2) extends Particle(p,v) {
  
  var alpha:Double = 1.0
  
  override def isDead(): Boolean = { alpha < 0 }

  def display(g:GraphicsContext):Unit = {
    g.globalAlpha = alpha
    g.drawImage(MyImages.smokeImg, pos.x,pos.y)
    g.globalAlpha = 1.0

    alpha -= 0.025
  }
}

object MyImages {
  val path = getClass().getResource("/images/Smoke.png")
  val smokeImg = new Image(path.toString)
}


