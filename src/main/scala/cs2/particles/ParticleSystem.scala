package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(private var origin:Vec2) {
  private var parts:List[Particle] = List()

  def display(g:GraphicsContext):Unit = {
    for(p <- parts) {
      p.display(g)
      println(parts.length)
    }
    //parts.foreach(_.display(g))
  }

  def timeStep():Unit = {
    for(p <- parts) p.timeStep()
  }

  def addParticle():Unit = {
    parts ::= new Particle(origin.clone(),
                 new Vec2(math.random()*4-2, math.random()*4-2))
  }


}