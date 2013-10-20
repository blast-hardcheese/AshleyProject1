package ashley.project1

object BSTNode {
  def apply[T <: Int](newData: T) = new BSTNode(newData, None, None)
}

class BSTNode[T <: Int](data: T, left: Option[BSTNode[T]], right: Option[BSTNode[T]])
{
  override def toString = s"BSTNode($data, $left, $right)"

  def insert(newData: T): BSTNode[T] = {
    (left, right) match {
      case _ if(newData == data) => this
      case (Some(lnode), _) if(newData < data) => this.copy(left = Some(lnode.insert(newData)))
      case (None, _)        if(newData < data) => this.copy(left = Some(BSTNode(newData)))
      case (_, Some(rnode)) if(newData > data) => this.copy(right = Some(rnode.insert(newData)))
      case (_, None)        if(newData > data) => this.copy(right = Some(BSTNode(newData)))
    }
  }

  def copy(data: T = data, left: Option[BSTNode[T]] = left, right: Option[BSTNode[T]] = right) = {
    new BSTNode(data, left, right)
  }
}

object MyApp extends App {
  val nums = List(51, 29, 68, 90, 36, 40, 22, 59, 44, 99, 77, 60, 27, 83, 15, 75, 3)

  val tree = nums.tail.foldLeft(BSTNode(nums.head))( (last, next) => last.insert(next) )
  println(tree)
}
