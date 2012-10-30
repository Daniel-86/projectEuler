def ( maxlen, answer ) = [ 0, 0 ]
 
def CACHE_SIZE = 1000000
def cache = new int[CACHE_SIZE]
 
for (i in 1..<1000000) {
  long n = i
  def len = 1
  while (n > 1) {
      if ((n < CACHE_SIZE) && (cache[(int)n] != 0)) {
          len += cache[(int)n] - 1
          break
      }
      n = (n % 2 == 0) ? n / 2 : (3 * n + 1)
      len++
  }
  cache[i] = len
  if (len > maxlen) ( maxlen, answer ) = [ len, i ]
}

println answer
