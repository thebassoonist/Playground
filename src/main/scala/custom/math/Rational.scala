package custom.math

class Rational(a: Long, b: Long) extends Ordered[Rational] {
  val (top, bottom) = Rational.reduce(a, b)

  def this(n: Long) = this(n, 1)

  def isValid: Boolean = this.b != 0L

  override def compare(that: Rational): Int = {
    val comp = this.top * that.bottom - that.top * this.bottom
    if (comp < 0) -1
    else if (comp > 0) 1
    else 0
  }

  // I think this is an okay hash, not really sure
  override def hashCode(): Int = this.top.toInt * (41 * this.bottom.toInt)

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: Rational => this.top == that.top && this.bottom == that.bottom
    case that: Any => super.equals(that)
  }

  override def toString: String = {
    if (isValid) {
      //if (this.bottom == 1) ""+this.top
      //else
      "%d / %d".format(this.top, this.bottom)
    }
    else "Invalid"
  }
}

object Rational {
  import scala.language.implicitConversions
  implicit def long2Rational(n: Long) = Rational(n)

  def apply(top: Long, bottom: Long): Rational = new Rational(top, bottom)
  def apply(n: Long): Rational = new Rational(n)

  def reduce(a: Long, b: Long): (Long, Long) = {
    val g = Numbers.gcd(a, b)
    (a / g) -> (b / g)
  }
}
