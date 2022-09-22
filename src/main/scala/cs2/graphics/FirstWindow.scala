package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scalafx.animation.AnimationTimer

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My Window!"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas
      val g = canvas.graphicsContext2D

      def cap(c:Double):Int = {
        if(c < 0) 0
        else if(c > 255) 255
        else c.toInt
      }

      g.strokeRect(200,50, 300,200)
      g.setStroke(Color.DodgerBlue)
      g.setFill(Color.rgb(200,100,50))
      g.setLineWidth(30)
      g.strokeLine(0,0, 600,200)
      g.fillOval(200,50, 300,200)
      g.fillText("Hello, how are you?", 200,50)
      
      for(x <- 0 until 600) {
        g.setStroke(Color.rgb(0, cap(x / 300.0 * 255), 255 - (x / 600.0 * 255).toInt))
        g.strokeLine(x,0, x,400)
      }
      
      g.setStroke(Color.Black)
      g.setLineWidth(1)

      def drawCirc(x:Double, y:Double, r:Double):Unit = {
        g.strokeOval(x-r, y-r, r*2,r*2)
        if(r > 5) {
          drawCirc(x-r,y, r/2)
          drawCirc(x+r,y, r/2)
          drawCirc(x,y-r, r/2)
          drawCirc(x,y+r, r/2)
        }
      }

      drawCirc(300,200, 100)

      g.setFill(Color.White)
      g.fillRect(0,0, 600,400)

      g.setStroke(Color.Black)
      canvas.onMouseDragged = (e:MouseEvent) => {
        g.strokeLine(300,200, e.x,e.y)
      }

      canvas.onKeyPressed= (e:KeyEvent) => {
        if(e.code == KeyCode.Space && e.controlDown) {
          g.setFill(Color.White)
          g.fillRect(0,0, 600,400)
        }
        if(e.code == KeyCode.R) {
          g.setFill(Color.Red)
          g.fillRect(0,0, 600,400)
        }
      }
      canvas.requestFocus()

      var xpos:Double = 300
      var xvel:Double = 2
      val timer = AnimationTimer(t => {
        g.setFill(Color.White)
        g.fillRect(0,0, 600,400)
        g.setFill(Color.SkyBlue)
        g.fillOval(xpos,200, 100,100)
        if(xpos + 100 >= 600 || xpos < 0) {
          xvel = -xvel
        }
        xpos += xvel
      })
      timer.start()



    }
  }
}


