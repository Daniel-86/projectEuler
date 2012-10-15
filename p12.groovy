/*
     todo numero perfecto es igual a la suma de sus divisores (excluyendo el numero mismo)
     todo numero perfecto es un numero triangular (no se conoce un numero perfecto impar, todos son pares)
     ************el primer numero en tener mas de N divisores siempre es un numero perfecto
     el primer numero en tener mas de N divisores siempre es un numero par
     la secuencia de los numeros triangulares sigue el patron (impar, impar, par, par, impar, impar, par, par, ...)
*/

/*def trianguloNumero(indice, anterior = 0){
    if(anterior != 0)
        return anterior + indice
    else
        return (1..indice).sum()
}*/

BigInteger trianguloNumero(indice){
    return indice * (indice + 1) / 2
}


List primosAnteriores(numero, listaPrimos = [1]){
    if(numero == 1)
        return [1]
//   def primosAnt = listaPrimos.grep{ it < numero}
    def primosAnt = listaPrimos
    //println "primos almacenados $primosAnt"
    def inicio = primosAnt.max() + 1
    def incremento = 2
    //if(inicio < 4){
     //   inicio ++
    //    incremento = 1
  //  }
//    for(def i=inicio; i<numero; i+=incremento){
    for(def i=primosAnt.max() + 1; i<numero; i++){
        def esPrimoA = true
        for(it in primosAnt){
            if(it != 1 &&  i%it == 0){
                esPrimoA = false
                break
            }
        }
        if(esPrimoA)
            primosAnt += i
    }
    return primosAnt
}

/*def divisores(numero){

    def primos = primosAnteriores(numero)
    def primosDivisores = primos.grep{ it != 1 && numero % it == 0 }
    def divisores = primosDivisores
    primosDivisores.each{//println "iterando el primo $it"
                            for(i=it; i<numero; i+=it){//println "\tvalor de la iteracion $i"
                                if(numero % i == 0 && !divisores.contains(i))
                                    divisores += i
                            }
                        }
    divisores += 1
    divisores += numero
    return divisores
}*/

def primos = [1]
def divisoresC = {numero ->
    primos = primosAnteriores(numero, primos)
    //def primosDivisores = primos.grep{ it != 1 && numero % it == 0 }
    def primosDivisores = []
    for (it in primos){
        if (it > numero/2)
            break
        if (it != 1 && numero % it == 0)
            primosDivisores += it
    }
    def divisores = primosDivisores
    primosDivisores.each{//println "iterando el primo $it"
                            for(i=it; i<numero; i+=it){//println "\tvalor de la iteracion $i"
                                if(numero % i == 0 && !divisores.contains(i))
                                    divisores += i
                            }
                        }
    divisores += 1
    divisores += numero
    return divisores
}


def resolver(div, closure){
    def numero = 3
    def numeroTriangulo = trianguloNumero(numero)
    //def primos = [1]
    def divisor = closure(numeroTriangulo)//; println "checando el ${numero}th : $numeroTriangulo\tdivisores iniciales ${divisor.sort()}"
    while(divisor.size()<div){
        if(numero % 2 == 0)
            numero += 3
        else
            numero++
        numeroTriangulo = trianguloNumero(numero)
        //if(numeroTriangulo > 28
              //  && (BigInteger)numeroTriangulo % 2 !=0
            //    && (BigInteger)numeroTriangulo % 3 != 0)
          //  continue
        divisor = closure(numeroTriangulo)//;  println "checando el ${numero}th : $numeroTriangulo\tdivisores iniciales ${divisor.sort()}"
        //println "$numeroTriangulo tiene ${divisor.size()} divisores ${divisor.sort()}"
    }
    //println "\ndivisores ${divisor.sort()}\n\tnumero divisores ${divisor.size()}"
    return numeroTriangulo
}

//def numDiv = 16
def numTri = 7392
//println "primer numero triangulo en tener mas de $numDiv divisores es ${resolver(numDiv,divisoresC)}"
def resul = divisoresC(numTri)
println "El numero trianglu $numTri tiene ${resul.size()} divisores ${resul.sort()}"

def triangulares = []
50.times{triangulares += trianguloNumero(it+1)}
println "triangulares par ${triangulares.grep{it %2 == 0}}"