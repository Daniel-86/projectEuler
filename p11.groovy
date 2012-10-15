def matrizDeArchivo(ruta){
    def archivo = new File(ruta)
    List matriz = []
    archivo.eachLine{
        def fila = []
        def datosFila = it.split(' ')
        datosFila.each{fila += Integer.parseInt(it)}
        matriz += [fila]
    }        
}

//println "la matriz es \n${matrizDeArchivo('/home/rbnseven/Escritorio/p11Matriz.txt')}"

def maxProdH(matriz, nAdj = 4){
    def nFilas = matriz.size()
    def nCol = matriz[0].size()
    def max = 0
    def bloqueMax = []
    def maxFil, maxCol
    matriz.each{
        for(i=0; i<nCol-nAdj; i++){
            def bloque = it[i..(i+nAdj-1)]
            def prod = 1
            bloque.each{num->
                prod *= num
            }
            if(prod>max){
                max = prod
                bloqueMax = bloque
                maxCol = i
            }
         }
    }
//    println "bloque Max $bloqueMax, columna $maxCol"
    return max
}

def maxProdV(matriz, nAdj=4){
    return maxProdH(GroovyCollections.transpose(matriz), nAdj)
}

def maxProdDiag(matriz, nAdj=4){
    def nFilas = matriz.size()
    def nCol = matriz[0].size()
    def max = 0
    def bloqueMax = []
    def maxFil, maxCol
    for(fila=0; fila<nFilas - nAdj; fila++){
        for(col=0; col<nCol - nAdj; col++){
            def bloque = []
            4.times{//println "${it+fila}"
                bloque += matriz[it+fila][it+col]
            }
            def prod = 1
            bloque.each{prod *=it}
            if(prod>max){
                max=prod
                bloqueMax = bloque
                maxCol = col
                maxFil = fila
            }
        }
    }
//    println "bloque Max $bloqueMax, columna $maxCol, fila $maxFil"
    return max
}

def maxProdDiagUp(matriz, nAdj=4){
    def nFilas = matriz.size()
    def nCol = matriz[0].size()
    def max = 0
    def bloqueMax = []
    def maxFil, maxCol
    for(fila=nAdj-1; fila<nFilas; fila++){
        for(col=0; col<nCol - nAdj; col++){
            def bloque = []
            4.times{//println "${it+fila}"
                bloque += matriz[fila -it][it+col]
            }
            def prod = 1
            bloque.each{prod *=it}
            if(prod>max){
                max=prod
                bloqueMax = bloque
                maxCol = col
                maxFil = fila
            }
        }
    }
//    println "bloque Max $bloqueMax, columna $maxCol, fila $maxFil"
    return max
}

def matriz = matrizDeArchivo('/home/rbnseven/Escritorio/p11Matriz.txt')
def valores = []
valores += maxProdH(matriz)
valores += maxProdV(matriz)
valores += maxProdDiag(matriz)
valores += maxProdDiagUp(matriz)
//println "el producto maximo horizontal es ${maxProdH(matriz)}"
//println "el producto maximo vertical es ${maxProdV(matriz)}"
//println "el producto maximo vertical es ${maxProdDiag( matriz)}"
//println "el producto maximo vertical es ${maxProdDiagUp( matriz)}"

println "El producto maximo es ${valores.max()}"