/*
*    Daniel Jimenez Ortega
*    Dado:
*		a² + b² = c², a + b + c = 1000
*    encontrar abc
*/

import groovy.time.*

def encuentraNumeros(suma = 1000){
    def a, b, c
    boolean salir = false
    for(a=1; a<1000; a++){
        for(b=1; b<1000; b++){
            if(b == a)
                continue
            c = suma - a -b
            if(c**2 == (a**2 + b**2)){
                salir = true
                break
            }
        }
        if(salir)
            break
    }
    println "a:$a  b:$b  c:$c\tproducto:${a*b*c}"
}

Date inicio = new Date()
encuentraNumeros()
println "Ejectuado en ${TimeCategory.minus(new Date(), inicio)}"
