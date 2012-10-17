/*
*    Daniel Jimenez Ortega
*    Encontrar el numero palidromo (capicua) formado por el producto de 2 numeros de 3 digitos
*/

import groovy.time.*

String.metaClass.esPalindromo = {
    delegate == delegate.reverse()
}

Date inicio = new Date()
def maxPal = 0
def n1, n2
(1..999).each { i->
            (1..999).each { j->
                        if( (i*j).toString().esPalindromo() && i*j > maxPal){
                            maxPal = i*j
                            n1 = i
                            n2 = j
                         }
             }
}


println "Palindromo $maxPal, los digitos son:($n1, $n2)"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"