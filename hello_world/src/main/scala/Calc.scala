object Calc {
  var marksSum: Double = 0
  var marksCount = 0
  var lowest: Double = 0
  var highest: Double = 0

  def averageMark: Double =
    marksSum.toDouble / marksCount

  def markExam(q1: Double, q2: Double, q3: Double) = {
    val avgScore = (q1 + q2 + q3) / 3
    val scaledScore = avgScore * 10 / 3
    val mark = Math.round(scaledScore)

    marksSum += mark
    marksCount += 1

    if (lowest == highest) {
      lowest = mark
      highest = mark
    } else if (lowest > mark) {
      lowest = mark
    } else if (highest < mark) {
      highest = mark
    }
    mark
  }

  def discount(price: Int) = if (price < 50) {price} else if (price < 100) { price * 0.9 } else {price * 0.85}

  def pow(exponent: Int, base: Int = 2): Int = {
    return pow(exponent, base, 1)
  }

  def pow(exponent: Int, base: Int, res: Int): Int = {
    if (exponent < 1) {
      return res
    }
    return pow(exponent - 1, base, res * base)
  }
}