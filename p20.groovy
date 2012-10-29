/*
*	Daniel Jimenez Ortega
*
*	Encuentra la suma de los digitos del numero 100!
*/

import groovy.time.*
import Factorial


def sumaDigitos = {numero->
    String cadena = numero.toString()
    Integer suma = 0
    cadena.each { suma+= it.toInteger() }
    return suma
}


Date inicio = new Date()
Integer numero = 100
BigInteger factrial = Factorial.get(numero)
println "La suma de los digitos de $numero! es ${sumaDigitos(factrial)}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
