package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = Stack[Int]()

  @Before def initStack():Unit = {
    s = Stack[Int]()
  }

  @Test def checkIsEmpty():Unit = {
    assertTrue(s.isEmpty())
    s.push(10)
    assertTrue(!s.isEmpty())
    s.pop()
    assertTrue(s.isEmpty())
    s.push(12)
  }

  @Test def checkPushPop():Unit = {
    for(i <- 10 to 50) {
      s.push(i)
      assertTrue(s.peek() == i)
    }
    for(i <- 50 to 10 by -1) {
      assertTrue(s.peek() == i)
      assertTrue(s.pop() == i)
    }
    assertTrue(s.isEmpty())
  }


}


