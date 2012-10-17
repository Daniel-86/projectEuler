def primos = [2, 3]
def primosAnteriores = { numero->
    if(numero < 2)
        return []
    def primosAnt = primos.grep { it <= numero }
    //println "inicio $primosAnt"
    def inicio = primosAnt.max() ?: 2
    (inicio % 2) ?: inicio++
    boolean actPrimos = inicio >= primos.max()
    //println "$actPrimos : $inicio > ${primos.max()}"
    def incremento
    ( inicio == 2)? (incremento = 1): (incremento = 2)
    for(i=inicio; i<=numero; i+=incremento){
        boolean esPrimo = true
        for (primo in primosAnt){
            if (i % primo == 0){
                esPrimo = false
                break
            }
        }
        if (esPrimo)
            primosAnt += i
        if (actPrimos && esPrimo){
            primos += i
//            println "primos actualizados $primos"
        }
    }
    return primosAnt
}
primosAnteriores(15)
primosAnteriores(25)
primosAnteriores(35)
primosAnteriores(6)




List<BigInteger> primosDivisores(numero, listaPrimos){
    List<BigInteger> primosDivisores = listaPrimos.grep {numero % it == 0} as BigInteger[]
    primosDivisores -= (1 as BigInteger)
    return primosDivisores
}



def generaFactores = {numero->
//    def primosAnt = primosAnteriores((BigInteger)Math.sqrt(numero))
    def primosAnt = primosAnteriores(numero/2)
    //println "los primos son $primosAnt"
    List<BigInteger> primosDivisores = primosDivisores(numero,primosAnt)
    //println "los primos divisores son $primosDivisores"
    List<BigInteger> veces = primosDivisores.collect{
                                                BigInteger temp = numero
                                                BigInteger contador = 0
                                                while(temp % it == 0){
                                                    temp = temp/it
                                                    contador ++
                                                }
                                                return contador
                                             } as BigInteger[]
    //println "# de veces cada primo $veces"
    Map<BigInteger,BigInteger> factores = [:]
    primosDivisores.size().times{
                                factores[primosDivisores[it]] = veces[it]
                            }
    return factores
}


def numDivisores = { numero->
    Map<BigInteger, BigInteger> factores = generaFactores(numero)
    def cantidad = 1
    factores.each{llave, valor->
                    cantidad *= (valor+1)
                  }
    return cantidad
}


def getDivisores = {numero->
    def primosAnt = primosAnteriores(numero/2)
//    println "los primos son $primosAnt"
    List<BigInteger> primosDivisores = primosDivisores(numero,primosAnt)
  //  println "los primos divisores son $primosDivisores"
    List elementos = []
    primosDivisores.each {
                            BigInteger temp = numero
                            BigInteger contador = 0
                            List tempList = [1]
                            while (temp % it == 0){
                                temp /= it
                                contador++
                                tempList += it ** contador
                            }
                            elementos += [tempList]
                    }
    //println "base $elementos"
    def divisores = elementos.combinations().collect{ combinacion->
                                    def divisor = 1
                                    combinacion.each { divisor *=it }
                                    return divisor
                                }
    return divisores
}


def getDivisoresP = {numero->
    def divP = getDivisores(numero)
    divP -= numero
    return divP
}



def resolver = {
    BigInteger suma = 0
    List visitados = []
    Map amigos = [:]
    (1..10000).each{
                    if(it in primos){
      //                  println "\t$it es primo"
                        return
                    }
                    def numero = getDivisoresP(it).sum()//; println "$it\tnumero $numero"
                    if(!numero)
                        return
                    
                    visitados += it
                    def numero2 = getDivisoresP(numero).sum()
                   // if( numero == 2620){
                     //   println "\t$it"
                       // println "\t$numero  ${getDivisoresP(numero)}\n\t$numero2  ${getDivisoresP(it)}"
                    //}
/*                    if (numero in visitados && numero2 in visitados && numero == it){
                        return
                    }*/
                    //if  (numero2 in visitados)
                      //  return
                    visitados += numero2
                    if(numero2 == it && numero != it){println "\t\t amigos $it  $numero"
                        amigos[it] = numero
                    }
//                    println "$it ${getDivisoresP(it)} ${getDivisoresP(it).sum()}"
            }
    amigos.each{ llave, valor->
//                    suma += llave
                    suma += valor
            }
    return suma
//    return amigos
}

//generaFactores(45)
//numDivisores(120)
//println "1184 ${getDivisores(1184)}"
//println "1178 ${getDivisores(1178)}"
println "suma de los amigos ${resolver()}"

//println "${[[1,2,4],[1,5],[1,3]].combinations()}"


/*
List primos = [2, 3]
def getPrimos = { Integer numero->
    if(numero < 2)
        return []
    List primosAnt = primos.grep { it <= numero }
    Integer inicio = primosAnt.max() ?: 2
    (inicio % 2) ?: inicio++
    boolean actPrimos = inicio >= primos.max()
    Integer incremento
    ( inicio == 2)? (incremento = 1): (incremento = 2)
    for(i=inicio; i<=numero; i+=incremento){
        boolean esPrimo = true
        for (primo in primosAnt){
            if (i % primo == 0){
                esPrimo = false
                break
            }
        }
        if (esPrimo)
            primosAnt += i
        if (actPrimos && esPrimo){
            primos += i
        }
    }
    return primosAnt
}


def getPrimosDivisores = { Integer numero, List listaPrimos ->
    List primosDivisores = listaPrimos.grep {numero % it == 0} as Integer[]
    primosDivisores -= 1
    return primosDivisores
}


def getFactores = { Integer numero->
    List primosAnt = getPrimos( numero/2  as Integer)
    List primosDivisores = getPrimosDivisores(numero,primosAnt)
    List veces = primosDivisores.collect{
                                                Integer temp = numero
                                                Integer contador = 0
                                                while(temp % it == 0){
                                                    temp = temp/it
                                                    contador ++
                                                }
                                                return contador
                                             } as Integer[]
    Map factores = [:]
    primosDivisores.size().times{
                                factores[primosDivisores[it]] = veces[it]
                            }
    return factores
}




def MCM = { List nums->
    List factores = []
    nums.each { num->
        Map temp = getFactores(num)
        (temp)? (factores += temp): (factores += [(num):1])
    }
    Map maxs = [:]
    factores.each { factors->
        factors.each { primo, exp->
            if (maxs.containsKey(primo as Integer)) {
                if (maxs[primo] < exp)
                    maxs[primo] = exp
            } else {
                maxs[primo] = exp
            }
        }
    }
    Integer mcm = 1
    maxs.each { Integer primo, Integer exp ->
        mcm *= primo ** exp
    }
    
    return mcm
}


println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"

*/
