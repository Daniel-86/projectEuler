/*
     todo numero perfecto es igual a la suma de sus divisores (excluyendo el numero mismo)
     todo numero perfecto es un numero triangular (no se conoce un numero perfecto impar, todos son pares)
     ************el primer numero en tener mas de N divisores siempre es un numero perfecto
     el primer numero en tener mas de N divisores siempre es un numero par
     la secuencia de los numeros triangulares sigue el patron (impar, impar, par, par, impar, impar, par, par, ...)
     
     
def divisorGen(n):
    factors = list(factorGenerator(n))
    nfactors = len(factors)
    f = [0] * nfactors
    while True:
        yield reduce(lambda x, y: x*y, [factors[x][0]**f[x] for x in range(nfactors)], 1)
        i = 0
        while True:
            f[i] += 1
            if f[i] <= factors[i][1]:
                break
            f[i] = 0
            i += 1
            if i >= nfactors:
                return
     
     
n = a^x * b^y * c^z
(x + 1) * (y + 1) * (z + 1)
     
     
*/

BigInteger trianguloNumero(indice){
    return indice * (indice + 1) / 2
}


List<BigInteger> primosAnterioresMitad(numero, listaPrimos = [1]){
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
    for(def i=primosAnt.max() + 1; i<=Math.sqrt(numero); i++){
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



List<BigInteger> primos = [1]
def numeroDivisores = {numero->println "\t\t CALCULANDO PARA $numero"
    primos = primosAnterioresMitad(numero, primos)
    //println "primos anteriores $primos, son ${primos.size()}"
    List<BigInteger> primosDivisores = primos.grep{ numero % it == 0 }
    println "primos divisores $primosDivisores"
    List<BigInteger> divisores = primosDivisores.grep{it!=1} as BigInteger[]
    List<BigInteger> vecesPrimos = []
    divisores.each{ vecesPrimos += numero / it }
    println "divisores iniciales $vecesPrimos, son ${vecesPrimos.size()}"
    BigInteger maximoPrimo = primosDivisores.max()
    for (primoD in primosDivisores){
    //BigInteger primoD = primosDivisores[1]
        if(primoD == 1) continue
        println "\n"
        def contador = 1
        for(temp in vecesPrimos){ println "\n"
            BigInteger divisorTemp = temp
            BigInteger otroDiv = primosDivisores[contador++]
            println"\tusando el primo $primoD"
            while (divisorTemp > maximoPrimo){
                println"\t\t          analizando par\t$divisorTemp\t$otroDiv"
                if(!(otroDiv in divisores))
                        divisores += otroDiv
                if(!(divisorTemp in divisores)){
                    divisores += divisorTemp
                }
    //            println "divisores $divisores"
                if(divisorTemp % primoD != 0){println "\trompe porque $divisorTemp no es divisible entre $primoD"
                    break}
                divisorTemp /= primoD
                otroDiv = otroDiv * primoD
//                println"\t\t          analizando par\t$divisorTemp\t$otroDiv"

                
//                println "divisores $divisores"
                
            }
        }
    }
    divisores += 1
    divisores += numero
    println "\ndivisores encontrados ${divisores.sort()}"

    return divisores.size()
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

List<BigInteger> primosDivisores(numero, listaPrimos){
    List<BigInteger> primosDivisores = listaPrimos.grep {numero % it == 0} as BigInteger[]
    primosDivisores -= (1 as BigInteger)
    return primosDivisores
}


def divisoresC = {numero ->
    primos = primosAnterioresMitad(numero, primos)
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


def resolver(numDiv, closure){
    def indice = 3
    def numeroTriangulo = trianguloNumero(indice)
    while(closure(numeroTriangulo)<numDiv)
        numeroTriangulo = trianguloNumero(++indice)
    return numeroTriangulo
}

def generaFactores = {numero->
    primos = primosAnterioresMitad(numero, primos)
    //println "los primos son $primos"
    List<BigInteger> primosDivisores = primosDivisores(numero,primos)
  //  println "los primos divisores son $primosDivisores"
    List<BigInteger> veces = primosDivisores.collect{
                                                BigInteger temp = numero
                                                BigInteger contador = 0
                                                while(temp % it == 0){
                                                    temp = temp/it
                                                    contador ++
                                                }
                                                return contador
                                             } as BigInteger[]
//    println "# de veces cada primo $veces"
    Map<BigInteger,BigInteger> factores = [:]
    primosDivisores.size().times{
                                factores[primosDivisores[it]] = veces[it]
                            }
    return factores
}

//BigInteger dato = 73920
BigInteger dato = 7392
//println "$dato tiene ${numeroDivisores(dato)}"
/*BigInteger a = 1, b=2, c=3
List<BigInteger> listaPrueba = []
listaPrueba += a
listaPrueba += b
listaPrueba += c
BigInteger d = 1
println "${listaPrueba.contains(d)}"*/

class Factores {
    private Map<BigInteger, BigInteger> factores
    private BigInteger numero
    public Factores(numero){
        this.numero = numero
    }
}

def formatFactores(factores){
    String formateado = ""
    factores.each{ llave, valor->
                    formateado += "($llave ** $valor)"
                 }
    return formateado
}

def numDivisores = { numero->
    Map<BigInteger, BigInteger> factores = generaFactores(numero)
    def cantidad = 1
    factores.each{llave, valor->
                    cantidad *= (valor+1)
                  }
    return cantidad
//    def numeroFactores = factores.size()
  //  while(true){
        
   // }
}

def cantDiv = 500
//println "el numero $dato = ${formatFactores(generaFactores(dato))} y tiene ${numDivisores(dato)} divisores"
println "el primer numero triangulo en tener mas de $cantDiv divisores es ${resolver(cantDiv,numDivisores)}"