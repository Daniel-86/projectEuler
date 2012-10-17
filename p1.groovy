/*
*    Daniel Jimenez Ortega
*    Suma de todos los multiplos de 3 y 5 menores a 1000
*/

import groovy.time.*

Date inicio = new Date()
println "suma ${(3..<1000).findAll { it % 3 == 0 || it % 5 == 0}.sum()}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}"
