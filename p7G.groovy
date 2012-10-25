/*
*    Daniel Jimenez Ortega
*    Cual es el 10001 primo?
*/

import Primo
import groovy.time.*

Integer indice = 10001

inicio = new Date()
println "el ${indice}° primo es ${Primo.grimo(indice)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"
