/*
*    Daniel Jimenez Ortega
*    Cual es el 10001 primo
*/

import groovy.time.*

Date inicio = new Date()

/*
*    Arreglo indicando si el numero X es primo o no
*    en este caso el numero maximo que se puede checar es 199999
*    que es el tamano del arreglo
*/
def esPrimo = new boolean[200000]
Arrays.fill (esPrimo, true)
esPrimo[1] = false

/*
*    Aqui arma la criba
*    checa que el elemento actual este marcado como primo
*    y despues marca todos sus multiplos como no primos
*/
for (i in 2..esPrimo.size()**0.5) {
    if (esPrimo[i])
        for (j = i+i; j < esPrimo.size(); j += i)
            esPrimo[j] = false
}

/*
*    Itera la criba incrementando un contador cada vez
*    que encuentra un numero primo
*/
def (resp, n) = [0, 0]
for (i in 2..<esPrimo.size()) {
    if (esPrimo[i]) {
        n++
        if (n == 10001) {
            resp = i
            break
        }
    }
}

println "primo $resp"
println "Ejecutado en ${TimeCategory.minus (new Date(), inicio)}"
