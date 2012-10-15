Map<Integer, List> collatzes = [ 1:[1], 2:[2, 1]]

def indent = ""
def collatz
collatz = {BigInteger numero ->//println "${indent}ALMACENADOS $collatzes"
    List<BigInteger> serie = []
    if(numero < 2) return [1]
    while (numero > 1){//println "${indent}analizando $numero  serie $serie"
        if (collatzes.containsKey(numero as Integer)){
            serie = collatzes[numero as Integer]; println "${indent}ya esta en la lista $serie"
            return serie
        }
        else{
            serie += numero
            Integer aux = numero
            if((BigInteger)numero % 2 == 0){
                numero /= 2
                indent += "\t"
                serie += collatz(numero)
                indent -= "\t"
//                println "${indent}$aux: $serie"
            }
            else{
                numero = 3*numero + 1
                indent += "\t"
                serie += collatz(numero)
                indent -= "\t"
  //              println "${indent}$numero: $serie"
            }
            
            collatzes[aux] = serie
            return serie
        }
   }
}

def resolver = {limite->
    BigInteger max = 0
    BigInteger maxNum
    List maxSerie
    for(i=3; i<limite; i++){
        def temp = collatz(i); 
        if(temp.size()>max){
            maxNum = i
            max = temp.size()
            maxSerie = temp
        }
    }
    println "longitud $max\n$maxSerie"
    return maxNum
}

def num = 1
//println "collatz ${collatz(num)}"
println "la cadena mas larga se obtiene con ${resolver(100000)}"