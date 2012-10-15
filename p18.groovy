/*
*    se resuelve recorriendo de abajo hacia arriba, calculando la suma parcial maxima y almacenandola en cada nodo
*/

def archivo = new File("/home/rbnseven/Escritorio/projectEuler/p18Triangulo.txt")
List filas = archivo.collect {it.trim().tokenize()}
(filas.size()-2..0).each { filaIndx->
            filas[filaIndx].eachWithIndex { elemento, eIndx->
                        def sumaI = filas[filaIndx+1][eIndx].toInteger() + elemento.toInteger()
                        def sumaD = filas[filaIndx+1][eIndx+1].toInteger() + elemento.toInteger()
                        filas[filaIndx][eIndx] = [sumaI, sumaD].max()
                        //println "\t$sumaI $sumaD   ${[sumaI, sumaD].max()}"
                }
            //println "filas[$filaIndx] ${filas[filaIndx]}"
       }
println "maximo total es ${filas[0][0]}"
