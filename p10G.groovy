/*
*    Daniel Jimenez Ortega
*    Calcula la suma de los primos menores a 2 millones
*/

import groovy.time.*


Date inicio = new Date()
def esPrimo = new boolean[2000000]
Arrays.fill(esPrimo, true)
esPrimo[1] = false

for (i in 2..esPrimo.size()**0.5) {
	if (esPrimo[i]) {
		Integer j = i + i
		while (j < esPrimo.size()) {
			esPrimo[j] = false
			j += i
		}
	}
}

BigInteger suma = 0
esPrimo.eachWithIndex {el, indx-> if(el==true) suma += indx}
println "${suma}"
println "Ejectuado en ${TimeCategory.minus(new Date(), inicio)}"

