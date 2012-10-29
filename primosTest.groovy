import Primo
import groovy.time.*

Integer num0 = 2000000
Integer num2 = 104743
Integer num3 = 157
Integer num4 = 76576500
Integer indice = 10001

Integer num = 284

Date inicio

inicio = new Date()
println "primos ${Primo.getPrimos(num)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "primos ${Primo.pA( Math.sqrt(num) )}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "primos ${Primo.getCriba(num)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "primos ${Primo.sumaPrimos(num)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "$num es primo?: ${Primo.esPrimo(num, [2,3,5,7,11,13,17,19])}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "siguiente primo de $num es ${Primo.getNextPrimo(num)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "siguiente primo de $num es ${Primo.gNP(num)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "el ${indice}° primo es ${Primo.getNPrimo(indice)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//inicio = new Date()
//println "el ${indice}° primo es ${Primo.grimo(indice)}"
//println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

inicio = new Date()
println "$num en factores ${Primo.getFactores(num)}"
println "tiene ${Primo.getNumDiv(num)} divisores"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

inicio = new Date()
println "$num -> divisores: ${Primo.getDivs(num)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

inicio = new Date()
println "$num -> divisores PROPIOS: ${Primo.getDivsProp(num)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

//println "primos almacenados ${Primo.primos}"
