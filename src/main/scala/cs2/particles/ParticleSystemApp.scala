package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.image.Image

object ParticleSystemApp extends JFXApp with Rainbowness {

  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,800) {
      val canvas = new Canvas(800,800)
      content = canvas
      val g = canvas.graphicsContext2D

      var ps = List[ParticleSystem]()
      
      canvas.onMouseClicked = (e:MouseEvent) => {
        ps ::= new ImageParticleSystem(new Vec2(e.x, e.y))
      }

      var wind = new Vec2(0,0)
      canvas.onMouseMoved = (e:MouseEvent) => {
        wind = new Vec2((400 - e.x) / 100.0, 0)
      }

      val timer = AnimationTimer(t => {
        g.setFill(stepColor())
        g.fillRect(0,0, width.value, height.value)
        for(sys <- ps) {
          sys.addParticle()
          sys.display(g)
          sys.timeStep()
          sys.applyForce(new Vec2(0,-0.5))
          sys.applyForce(wind)
        }  
      })
      timer.start()

    }
  }
}