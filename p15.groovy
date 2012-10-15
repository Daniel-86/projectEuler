def factoriales = [1:1]
def factorial
factorial = {BigInteger numero->
    if(numero <= 1)
        return 1
    if (factoriales.containsKey(numero))
        return factoriales[numero]
    def nuevo = numero * factorial(numero-1)
    factoriales[numero] = nuevo
    return nuevo
}


def coeficienteBinomial
coeficienteBinomial = {n, k->
    if (k > n)
        return 0
    BigInteger facN = factorial(n)
    BigInteger facK = factorial(k)
    BigInteger facNK = factorial(n-k)
    //println "DATOS biniomial $facN / $facK * $facNK"
    return facN/(facK*facNK)
}


def expansionBinomial
expansionBinomial = {exponente->
    List coeficientes = (0..exponente).collect{ coeficienteBinomial(exponente, it)}
    return coeficientes
}


def trianguloPascal = {indice->
    (0..indice).each{println " "*(indice-it) + "${expansionBinomial(it)}"}
}


def numeroRutasGrid = {filas, columnas->
    def altura = (filas) * 2
    def objetivo = Math.ceil(filas*2/2.0) as Integer
    //println "calcular ($altura $objetivo)"
    return coeficienteBinomial(altura, objetivo)
}


def numero = 2
def exponente = 7
def indCoef = 4
def alturaTriangulo = 15
//println "el factorial de $numero es ${factorial(numero)}"
//(1..numero).each{println "el factorial de $it es ${factorial(it)}\n"}
//println "dado (x + y)*$exponente, ($exponente $indCoef) = ${coeficienteBinomial(exponente, indCoef)}"
//println "los coeficientes binomiales de (x + y)*$exponente son ${expansionBinomial(exponente)}"
//trianguloPascal(alturaTriangulo)
def filas = 20
def columnas = 20
println "La grid $filas x $columnas tiene ${numeroRutasGrid(filas, columnas)} rutas posibles de extremo a extremo"