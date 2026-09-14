object MyCalculator {
    // def sum(a: Int, b: Int) = a + b
    val sum: (Int, Int) => Int = (a,b) => a + b
    // def sum(a: Int, b: Int) = a + b
    // val sum = { (a: Int, b: Int) => a + b }
    // val sum: (Int, Int) => Int = _ + _
    def subtract(a: Int, b: Int) = a - b
    def multiply(a: Int, b: Int) = a * b
    def divide(a: Int, b: Int) = a / b
    def negate(a: Int) = subtract(0, a)
}