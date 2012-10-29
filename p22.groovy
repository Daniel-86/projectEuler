/*
*	Daniel Jimenez Ortega
*
*	A partir de una archivo que contiene mas de 5000 nombres;
*	ordenarlos alfabeticamente,
*	calcular el valor alfabetico (suma del valor numerico de sus letras),
*	y multiplicarlo por su posicion dentro de la lista. Esto para obtener un puntaje.
*	Cual es la suma de los puntajes de los nombres en el archivo?
*/

import groovy.time.*
import Primo


Date inicio = new Date()
File archivo = new File("./names.txt")
List nombres = []
archivo.each{ nombres += it.split(",").flatten() }
nombres = nombres.collect{ it[1..-2] }.sort()	// Para quitar las comillas que aparecen en el archivo
def letras = ('A'..'Z')
Integer suma = 0
nombres.each {nombre->
            Integer score = 0
            // Calcula valor alfabetico
            nombre.each{ letra->
                        score += letras.findIndexOf {it == letra} + 1
                    }
            // Calcula posicion dentro de la lista
            Integer pos = nombres.findIndexOf {it == nombre} + 1
            suma += score * pos
        }


println "la suma es $suma"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
