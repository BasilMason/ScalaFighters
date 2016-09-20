trait A {
  def x: Int
  protected def y: Int
}

case object B extends A {
  override def x = 3
  override def y = 4
}

val b = B.