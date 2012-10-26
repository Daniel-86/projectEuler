/*
*    Daniel Jimenez Ortega
*    Calcula la suma de los primos menores a 2 millones
*/

import groovy.time.*
import Primo

Date inicio = new Date()
println "suma ${Primo.sumaPrimos(2000000)}"
println "Ejectuado en ${TimeCategory.minus(new Date(), inicio)}"

