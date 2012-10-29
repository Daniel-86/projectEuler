/*	Daniel Jimenez Ortega
*	
*	Dada una cuadricula 20x20, cuantas rutas existen para ir del extremo superior izquierdo
*	al extremo inferior derecho.
*
*	Este es un problema combinatorio; el numero de rutas de una esquina es la suma de las rutas
*	de los "caminos" adyacentes a esa esquina. Es decir los valores del triangulo de Pascal.
*
*		combinacion(n, r) = n! / (n-r!)r!	numero de maneras de elegir r elementos de n
*/

import groovy.time.*
import Factorial


/*
*	combinacion(n, k) = n! / ( (n-k!) * k! )
*/
def coeficienteBinomial
coeficienteBinomial = {n, k->
    if (k > n)
        return 0
    BigInteger facN = Factorial.get(n)
    BigInteger facK = Factorial.get(k)
    BigInteger facNK = Factorial.get(n-k)
    return facN/(facK*facNK)
}


def numeroRutasGrid = { filas, columnas->
    Integer altura = filas * 2
    Integer objetivo = Math.ceil( filas * 2 / 2.0 ) as Integer
    return coeficienteBinomial(altura, objetivo)
}



Date inicio = new Date()
def filas = 20
def columnas = 20

println "La grid $filas x $columnas tiene ${numeroRutasGrid(filas, columnas)} rutas posibles de extremo a extremo"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"




/*
*	El triangulo de Pascal de altura 'n' es la expansion binomial: (x + y)**n,
*	cada elemento de la expansion es el 'r' coeficiente binomial: combinacion(n, r)
*/

def expansionBinomial
expansionBinomial = { exponente->
    List coeficientes = (0..exponente).collect{ coeficienteBinomial(exponente, it)}
    return coeficientes
}


def trianguloPascal = { indice->
    (0..indice).each{ println " "*(indice-it) + "${expansionBinomial(it)}" }
}

