def getFactores(numero){
    def n = numero
    def factor = 2
    def factores = []
    while(n > 1)
        if((BigInteger)n % factor == 0){
            factores += factor
            n /= factor
        }
        else
            factor++
    return factores
}

def getMaximoFactor(numero){
    factores = getFactores(numero)
    return factores.max()
}

//println getMaximoFactor(600851475143)
