package ashley.project1

object BSTNode {
  def apply[T <: Int](newData: T) = new BSTNode(newData, None, None)
  def unapply[T <: Int](node: BSTNode[T]): Option[Tuple3[T, Option[BSTNode[T]], Option[BSTNode[T]]]] = Some((node.data, node.left, node.right))
}

class BSTNode[T <: Int](val data: T, val left: Option[BSTNode[T]], val right: Option[BSTNode[T]])
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

  def find(value: T): Option[BSTNode[T]] = (left, right) match {
    case _                  if(value == data) => Some(this)
    case (Some(left),  _)   if(value < data)  => left.find(value)
    case (_, Some(right))   if(value > data)  => right.find(value)
    case _                                    => None
  }

  def traversePre: String = {
    List(
      Some(data.toString),
      left.map(_.traversePre),
      right.map(_.traversePre)
    ).flatten.mkString(" ")
  }

  def traverseIn: String = {
    List(
      left.map(_.traverseIn),
      Some(data.toString),
      right.map(_.traverseIn)
    ).flatten.mkString(" ")
  }

  def traversePost: String = {
    List(
      left.map(_.traversePost),
      right.map(_.traversePost),
      Some(data.toString)
    ).flatten.mkString(" ")
  }

  def copy(data: T = data, left: Option[BSTNode[T]] = left, right: Option[BSTNode[T]] = right) = {
    new BSTNode(data, left, right)
  }
}

object MyApp extends App {
  val nums = List(51, 29, 68, 90, 36, 40, 22, 59, 44, 99, 77, 60, 27, 83, 15, 75, 3)

  val tree = nums.tail.foldLeft(BSTNode(nums.head))( (last, next) => last.insert(next) )
  println(tree)

  println(tree.find(22))

  println(tree.traversePre)
  println(tree.traverseIn)
  println(tree.traversePost)
}
