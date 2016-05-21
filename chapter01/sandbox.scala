import java.math.BigInteger

def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

println(factorial(30))

def factorial2(x: BigInteger): BigInteger = {
  if (x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial2(x.subtract(BigInteger.ONE)))
}

println(factorial2(BigInteger.valueOf(30)))
