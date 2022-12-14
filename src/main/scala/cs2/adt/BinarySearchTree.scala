package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
  private class Node(var data:A, var left:Node, var right:Node) {
    def contains(elem:A):Boolean = {
      if(this.data >= elem && this.data <= elem) true
      else {
        if(elem < this.data) {
          if(this.left == null) false else this.left.contains(elem)
        } else {
          if(this.right == null) false else this.right.contains(elem)
        }
      }
    }
    def insert(elem:A):Unit = {
      if(elem < data) {
        if(left == null) left = new Node(elem, null,null)
        else left.insert(elem)
      } else {
        if(right == null) right = new Node(elem, null,null)
        else right.insert(elem)
      }
    }
    def removeMaxKid():(Node, A) = {
      if(right != null) {
        val (n,v) = right.removeMaxKid()
        right = n
        (this, v)
      } else {
        (left, data)
      }
    }
    def remove(elem:A):Node = {
      if(data >= elem && data <= elem) { //Found it!
        if(right == null) left
        else if(left == null) right
        else { //Two kids!
          val (n,v) = left.removeMaxKid()
          left = n
          data = v
          this
        }
      } else {
        if(elem < data) left = left.remove(elem)
        else right = right.remove(elem)
        this
      }
    }
  }
  private var root:Node = null

  def printPreOrder():Unit = {
    def workOnNode(n:Node):Unit = {
      print(n.data)
      if(n.left != null) workOnNode(n.left)
      if(n.right!= null) workOnNode(n.right)
    }
    workOnNode(root)
  }

  def remove(elem:A):Unit = {
    root = root.remove(elem)
  }

  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null,null)
    else root.insert(elem)
  }

  def contains(elem:A):Boolean = {
    if(root == null) false else root.contains(elem)
    /*var curr:Node = root
    while(curr != null) {
      if(curr.data <= elem && curr.data >= elem) { return true }
      else {
        if(elem < curr.data) {
          curr = curr.left
        } else {
          curr = curr.right
        }
      }
    }
    false */
  }
}

object BSTStuff {
  def main(args:Array[String]):Unit = {
    val bst = new BinarySearchTree[Char]()
    bst.insert('Q')
    bst.insert('F')
    bst.insert('A')
    bst.insert('M')
    bst.insert('Z')
    bst.insert('K')
    bst.printPreOrder()
  }
}


