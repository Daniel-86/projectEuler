/*
*    Daniel Jimenez Ortega
*    Cual es el primer numero triangulo que tiene mas de 500 divisores
*/

/*		NOTAS
     todo numero perfecto es igual a la suma de sus divisores (excluyendo el numero mismo)
     todo numero perfecto es un numero triangular (no se conoce un numero perfecto impar, todos son pares)
     el primer numero en tener mas de N divisores siempre es un numero par
     la secuencia de los numeros triangulares sigue el patron (impar, impar, par, par, impar, impar, par, par, ...)
*/

import groovy.time.*
import Primo

BigInteger numTriByIndx (indice) {
    return indice * (indice + 1) / 2
}


Date inicio = new Date()
Integer indx = 3
Integer nDiv = 500
Integer numTri = numTriByIndx(indx)
while ( Primo.getNumDiv(numTri) < nDiv )
	numTri = numTriByIndx(++indx)

println "$numTri es el primer triangulo en tener mas de $nDiv"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"

