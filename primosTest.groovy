import Primo
import groovy.time.*

Integer num = 15

Date inicio = new Date()
println "primos ${Primo.primos(-51)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

inicio = new Date()
println "primos ${Primo.getPrimos(num)}"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}\n"

println "primos almacenados ${Primo.primos}"
