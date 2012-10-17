/*
*    Daniel Jimenez Ortega
*    Suma de todos los elementos pares de la serie Fibonacci y que sean menores a 4 millonees.
*/

import groovy.time.*

def fibonacci(numero){
    assert numero > 0
    if(numero == 1)
        return 1
    if(numero == 2)
        return 2
    else
        return fibonacci(numero -2) + fibonacci(numero - 1)
}

Date inicio = new Date()
def resolver(){
    Integer suma = 0
    Integer fibN = 0
    
    for(N = 2; fibN < 4000000 ; N++){
        fibN = fibonacci(N)
        if (!(fibN % 2)) suma += fibN
    }
    return suma
}

println "resultado: ${resolver()}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"