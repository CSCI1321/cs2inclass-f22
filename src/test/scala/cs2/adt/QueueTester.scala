package cs2.adt

import org.junit._
import org.junit.Assert._

class QueueTester {
  var q:Queue[Int] = Queue[Int]()

  @Before def init():Unit = {
    q = Queue[Int]()
  }

  @Test def checkIsEmpty():Unit = {
    assertTrue(q.isEmpty())
    q.enqueue(12)
    assertTrue(!q.isEmpty())
  }

  @Test def checkEnqueueDequeue():Unit = {
    for(i <- 1 to 50) {
      q.enqueue(i)
      assertTrue(q.peek() == 1)
    }
    for(i <- 1 to 50) {
      assertTrue(q.peek() == i)
      assertTrue(q.dequeue() == i)
    }
    assertTrue(q.isEmpty())
  }





}



