/*
*	Daniel Jimenez Ortega
*
*	Cual es el primer termino de la serie fibonacci en contener 1000 digitos
*/

import groovy.time.*


Date inicio = new Date()
def (fib1, fib2, total) = [ 1G, 2G, 3]

while (fib2.toString().size() < 1000)
    (fib1, fib2, total) = [fib2, fib1+fib2, total+1]
    
    
println total
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
