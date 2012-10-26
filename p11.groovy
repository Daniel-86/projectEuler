/*
*    Daniel Jimenez Ortega
*    Cual es el producto maximo de 4 numeros adyacentes en una matriz?
*/

import groovy.time.*


/*
*	crea una matriz a partir de una archivo de texto
*/
def matrizDeArchivo (ruta) {
    File archivo = new File(ruta)
    List matriz = []
    
    archivo.eachLine {
        List datosFila = it.split(' ')
        matriz += [ datosFila.collect{Integer.parseInt(it)} ]
    }        
}


/*
*	calcula el producto maximo de nAdj numeros adyacentes,
*	dentro de la matriz especificada y horizontalmente
*/
Integer maxProdH (matriz, nAdj = 4) {
    Integer nCol = matriz[0].size()
    Integer max = 0
    
    matriz.each { fila->
        (0..nCol-nAdj).each { i->
            List bloque = fila[ i..(i + nAdj-1) ]
            Integer prod = bloque.inject(1) {prod, val-> prod * val}
            max = Math.max (max, prod)
         }
    }
    return max
}


/*
*	calcula el producto maximo de nAdj numeros adyacentes,
*	dentro de la matriz especificada y verticalmente
*/
def maxProdV (matriz, nAdj=4) {
    return maxProdH (GroovyCollections.transpose(matriz), nAdj)
}


/*
*	calcula el producto maximo de nAdj numeros adyacentes,
*	dentro de la matriz especificada y en diagonal hacia abajo
*/
def maxProdDiag (matriz, nAdj=4) {
    Integer nFilas = matriz.size()
    Integer nCol = matriz[0].size()
    Integer max = 0
    
    (0..nFilas-nAdj).each { fila->
    	(0..nCol-nAdj).each { col->
            List bloque = []
            4.times { bloque += matriz [it+fila] [it+col] }
            Integer prod = bloque.inject(1) {prod, val-> prod * val}
            max = Math.max (max, prod)
        }
    }
    return max
}


/*
*	calcula el producto maximo de nAdj numeros adyacentes,
*	dentro de la matriz especificada y en diagonal hacia arriba
*/
def maxProdDiagUp (matriz, nAdj=4) {
    Integer nFilas = matriz.size()
    Integer nCol = matriz[0].size()
    Integer max = 0
    
    (nAdj-1..<nFilas).each { fila->
    	(0..nCol-nAdj).each { col->
            List bloque = []
            4.times{ bloque += matriz [fila-it] [it+col] }
            Integer prod = bloque.inject(1) {prod, val-> prod * val}
            max = Math.max (max, prod)
        }
    }
    return max
}




Date inicio = new Date()
def matriz = matrizDeArchivo('./p11Matriz.txt')
def valores = []
valores += maxProdH(matriz)
valores += maxProdV(matriz)
valores += maxProdDiag(matriz)
valores += maxProdDiagUp(matriz)

println "El producto maximo es ${valores.max()}"
println "Ejectuado en ${TimeCategory.minus(new Date(), inicio)}"

