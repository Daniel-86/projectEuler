/*
*	Daniel Jimenez Ortega
*
*	Cual es la suma maxima de los numeros encontrados en el recorrido del vertice superior a la
*	base de un triangulo de numeros.
*
*
*	Se resuelve recorriendo de abajo hacia arriba, calculando la suma parcial maxima para cada nodo
*	(la suma maxima de ese nodo a la base). Solo es cuestion de elegir, en cada nivel, el nodo
*	que tenga la suma parcial maxima.
*/

import groovy.time.*


Date inicio = new Date()
File archivo = new File("./p18Triangulo.txt")
List filas = archivo.collect { it.trim().tokenize() }

(filas.size()-2..0).each { filaIndx->
            filas[filaIndx].eachWithIndex { elemento, eIndx->
            		// Hijo izquierdo
                        Integer sumaI = filas[filaIndx+1][eIndx].toInteger() + elemento.toInteger()
                        // Hijo derecho
                        Integer sumaD = filas[filaIndx+1][eIndx+1].toInteger() + elemento.toInteger()
                        filas[filaIndx][eIndx] = [sumaI, sumaD].max()
            }
}

println "maximo total es ${filas[0][0]}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
