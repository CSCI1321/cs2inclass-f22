package cs2.graphics

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My Window!"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas
      val g = canvas.graphicsContext2D

      g.fillRect(100,100, 300,200)

    }
  }
}


