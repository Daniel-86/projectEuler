/*	Daniel Jimenez Ortega
*
*	Cual es la suma de los digitos del numero 2¹⁰⁰⁰?
*/

import groovy.time.*


Date inicio = new Date()
Integer suma = 0
(2**1000).toString().each{suma += it.toInteger()}

println "La suma de los digitos de 2**1000 es $suma"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
