package cs2.particles

import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color

object ParticleSystemApp extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,800) {
      val canvas = new Canvas(800,800)
      content = canvas
      val g = canvas.graphicsContext2D

      val ps = new ParticleSystem(new Vec2(400,200))
      
      val timer = AnimationTimer(t => {
        g.setFill(Color.White)
        g.fillRect(0,0, width.value, height.value)
        ps.display(g)
        ps.timeStep()
        ps.addParticle()
      })
      timer.start()

    }
  }
}