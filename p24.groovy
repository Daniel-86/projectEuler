/*
*	Daniel Jimenez Ortega
*
*	Cual es la millonesima permutacion (en orden lexicografico) de los digito 0 al 9
*/

import groovy.time.*


Date inicio = new Date()
List digitos =  (0..9)
List permuta = digitos.permutations().collect{ it.join() }.sort()

println permuta.get(1000000 - 1)
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
