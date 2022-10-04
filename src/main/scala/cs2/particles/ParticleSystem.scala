package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(protected var origin:Vec2) {
  protected var parts:List[Particle] = List()

  def display(g:GraphicsContext):Unit = {
    for(p <- parts) {
      p.display(g)
      //println(parts.length)
    }
    //parts.foreach(_.display(g))
  }

  def timeStep():Unit = {
    for(p <- parts) p.timeStep()
  }
  def applyForce(force:Vec2):Unit = {
    parts.foreach((x:Particle) => x.applyForce(force))
  }

  def addParticle():Unit = {
    //if(math.random() < 0.5) {
      parts ::= new RainbowParticle(origin.clone(),
                  new Vec2(math.random()*4-2, math.random()*4-2))
    //} else {
    //  parts ::= new SquareParticle(origin.clone(),
    //             new Vec2(math.random()*4-2, math.random()*4-2))
    //}
  }


}