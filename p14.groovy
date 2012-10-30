/*
*    Daniel Jimenez Ortega
*
*    La conjetura de collatz dice que: dado cualquier numero natural n,
*    es posible llegar a 1 aplicando las siguientes reglas
*		n -> n/2	si n es par
*		n -> 3n + 1	si n es impar
*
*    Cual es el numero n menor a 1 millon que produce la secuenca mas larga
*    aplicando las reglas de la conjetura de collatz?
*/

import groovy.time.*

Map<Integer, List> collatzes = [ 1:[1], 2:[2, 1]]

//def indent = ""
def collatz
collatz = { numero ->//println "${indent}ALMACENADOS $collatzes"
    List serie = []
    if (numero < 2) return [1]
    while (numero > 1) {//println "${indent}analizando $numero  serie $serie"
        if ( collatzes.containsKey(numero) ) {
            serie = collatzes[numero]//; println "${indent}ya esta en la lista $serie"
            return serie
        } else {
            serie += numero
            Integer aux = numero
            if ( (Integer)numero % 2 == 0){
                numero /= 2
//                indent += "\t"
                serie += collatz(numero)
//                indent -= "\t"
//                println "${indent}$aux: $serie"
            }
            else{
                numero = 3*numero + 1
//                indent += "\t"
                serie += collatz(numero)
//                indent -= "\t"
  //              println "${indent}$numero: $serie"
            }
            
            collatzes[aux] = serie
            return serie
        }
    }
}


Integer [] lCollatz = new Integer [1000000]
def lengCollatz
lengCollatz = { numero->
	Integer leng = 0
	Integer aux = numero
	while (numero > 1) {//println "PRUEBAS $numero ${lCollatz[numero as Integer]}"
		if ( lCollatz[numero as Integer] ) {
			return leng + lCollatz[numero as Integer]
		}
		numero = ( ((Integer)numero) % 2 == 0)? numero / 2: (3*numero + 1)
		leng++
		leng += lengCollatz(numero)
	}
	lCollatz[aux] = leng
}

def resolver = { limite->
    Integer max = 0
    Integer maxNum
    List maxSerie
    for (i = 2; i < limite; i++) {
        List temp = collatz(i);
//        Integer res = lengCollatz(i)
//        println "PRUEBAS $i ${res}"
//        if (res > max)
//        	maxNum = i
        if (temp.size() > max) {
            maxNum = i
            max = temp.size()
            maxSerie = temp
        }
    }
//    println "longitud $max\n$maxSerie"
    return maxNum
}


Date inicio = new Date()
def num = 1
//println "collatz ${collatz(num)}"
println "la cadena mas larga se obtiene con ${resolver(1000000)}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
