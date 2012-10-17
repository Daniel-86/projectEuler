/*
*    Daniel Jimenez Ortega
*    Para el intervalo 1..100, encontrar la diferencia del cuadrado de la suma y la suma de los cuadrados
*/

import groovy.time.*

Date inicio = new Date()
def rango = 1..100
Integer diferencia = rango.sum() ** 2 - rango.sum{it*it}
println "solucion $diferencia"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"