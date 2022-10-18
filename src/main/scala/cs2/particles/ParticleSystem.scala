package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scala.collection.mutable.Buffer

class ParticleSystem(protected var origin:Vec2) {
  protected var parts:Buffer[Particle] = Buffer()

  def display(g:GraphicsContext):Unit = {
    for(p <- parts) {
      p.display(g)
      //println(parts.length)
    }
    //parts.foreach(_.display(g))
  }

  def timeStep():Unit = {
    for(p <- parts) p.timeStep()
    /* This is bad
    for(p <- parts) {
      if(p.isDead()) {
        parts -= p
      }
    }*/
    //This works:
    //parts.filterNot((x:Particle) => x.isDead)
    var toRemove:Buffer[Particle] = Buffer()
    for(p <- parts) {
      if(p.isDead()) {
        toRemove += p
      }
    }
    parts --= toRemove
  }
  def applyForce(force:Vec2):Unit = {
    parts.foreach((x:Particle) => x.applyForce(force))
  }

  def addParticle():Unit = {
    //if(math.random() < 0.5) {
      parts += new RainbowParticle(origin.clone(),
                  new Vec2(math.random()*4-2, math.random()*4-2))
    //} else {
    //  parts ::= new SquareParticle(origin.clone(),
    //             new Vec2(math.random()*4-2, math.random()*4-2))
    //}
  }


}