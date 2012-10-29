/*
*	Daniel Jimenez Ortega
*
*	Encuentra la suma de todos los numeros amigos menores a 10000
*/

import groovy.time.*
import Primo


Map amigosRango ( ini, fin) {
	Map amigos = [:]
	(ini..fin).each{
    		if (Primo.esPrimo(it))
    			return
    		Integer num1 = Primo.getDivsProp(it).sum()
    		Integer num2 = Primo.getDivsProp(num1).sum()
    		if (num1 != it && it == num2){
    			if ( !(amigos.containsKey(it) && amigos[it] == num1
    				|| amigos.containsKey(num1) && amigos[num1] == it) )
	    			amigos[it] = num1
    		}


    	}
    	return amigos
}

def resolver = {
    Integer suma = 0
    Map amigos = amigosRango(1, 10000)
    
    amigos.each{ llave, valor->
                    suma += llave
                    suma += valor
    }
    return suma
}


Date inicio = new Date()

println "suma de los amigos ${resolver()}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"

