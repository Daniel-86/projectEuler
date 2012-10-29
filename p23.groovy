/*
*	Daniel Jimenez Ortega
*
*	Encuentra la suma de todos los enteros positivos que no pueden ser escritos
*	como la suma de 2 numeros abundantes
*	
*		NOTAS
*	El numero abundante mas pequeño es 12.
*	El numero menor que se puede escribir como suma de 2 abundantes es 24.
*	Todos los numeros mayores a 20161 se pueden escribir como suma de 2 abundantes
*/


import groovy.time.*
import Primo


boolean esAbundante (num) {
	List divsProp = Primo.getDivsProp(num)
	return divsProp.sum() > num
}


List getAbundantesRango (ini, fin) {
	List abundantes = []
	
	(ini..fin).each { num->
		if (esAbundante(num)) abundantes += num
	}
	return abundantes
}


def resolver = { limite->
	List abundantes = getAbundantesRango(12, limite)
	List sumas = []
	abundantes.each { num1->
		for (num2 in abundantes) {
			Integer temp = num1 + num2
			if (temp > limite)
				break
			if ( !(temp in sumas) )
				sumas += num1 + num2
		}
	}
//	println "ABUNDANTES ${abundantes}\nSUMAS ${sumas}"
	Integer suma = 0
	(1..limite).each { num->
		if ( !(num in sumas) )
			suma += num
	}
	println "SUMA = ${suma}"
}



Date inicio = new Date()

resolver(20161)

println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
