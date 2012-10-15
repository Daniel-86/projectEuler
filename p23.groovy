// 4179871
List perfectos = [6]
def primos = [2, 3]
def primosAnteriores = { numero->
    if(numero < 2)
        return []
    def primosAnt = primos.grep { it <= numero }
    def inicio = primosAnt.max() ?: 2
    (inicio % 2) ?: inicio++
    boolean actPrimos = inicio >= primos.max()
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
        }
    }
    return primosAnt
}



List<BigInteger> primosDivisores(numero, listaPrimos){
    List<BigInteger> primosDivisores = listaPrimos.grep {numero % it == 0} as BigInteger[]
    primosDivisores -= (1 as BigInteger)
    return primosDivisores
}




def getDivisores = {numero->
    def primosAnt = primosAnteriores(numero/2)
    List<BigInteger> primosDivisores = primosDivisores(numero,primosAnt)
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


def getAbundantes = {limite->
    def inicio = 12
    List abundantes = []
    List abundantesBase = []
    (inicio..limite).each{ numero->
                        List abunTemp = abundantesBase.grep{ abu-> abu < numero}
//                        println abunTemp
                        boolean salir = false
                        for (temp in perfectos)
                            if (numero % temp == 0){
                                abundantes += numero; //println "\tPERFECTOS $numero es multiplo de $temp"
                                salir = true
                                break
                            }
                        if (salir)
                            return
                        for (temp in abunTemp)
                            if (numero % temp == 0){
                                abundantes += numero; //println "\tpar $numero es multiplo de $temp"
                                salir = true
                                break
                            }
                        if (salir)
                            return
    //                    println "calcula con $numero"
                        def suma = getDivisoresP(numero).sum()
                        if(suma == numero)
                            perfectos += numero
                        if(suma > numero){//println "\t\tNUEVO $numero"
                            abundantes += numero
                            if( !( ((Integer)numero) in abundantesBase) ){
                                boolean agregar = true
                                for (ab in abundantesBase)
                                    if(numero > ab && numero % ab == 0)
                                        agregar = false
                                 if (agregar)
                                     abundantesBase += numero
                            }
                        }
                    }
    return abundantes
}


def dato = 20160
def resolver = {
    List abundantes = getAbundantes(20160)
    def suma = 0
    (25..48).each{ numero->
                    if(numero % 2 != 0){
                        suma += numero
                        return 
                    }
                    def temp = abundantes.grep{it<numero}.sort()
                    def agrega = true
                    for(i=0; i<temp.size() - 1; i++){
                        for(j=i+1; j<temp.size(); j++){
                            if (temp[i] + temp[j] >numero)
                                break
                            if (temp[i] + temp[j] == numero){
                                agrega = false
                                break
                            }
                        }
                        if(!agrega)
                            break
                    }
                    if(agrega)
                        suma += numero

                }
    (49..20160).each { numero->
                    if(numero % 2 != 0){
                        def impares = abundantes.grep{it<numero && it % 2 != 0}
                        def pares = abundantes.grep{it<numero && it % 2 == 0}
                        if(impares.size() == 0)
                            return
                        def agrega = true
                        for(impar in impares){
                            for(par in pares){
                                if(par + impar == numero){
                                    agrega = false
                                    break
                                }
                            }
                            if(!agrega)
                                break
                        }
                        if(agrega)
                            suma += numero
                    }
                }
     return suma
}



//generaFactores(45)
//numDivisores(120)
//println "1184 ${getDivisores(1184)}"
//println "1178 ${getDivisores(1178)}"
//println "abundantes hasta $dato ${getAbundantes(dato)}"
println "suma es ${resolver()}"
println "perfectos $perfectos"
//println "${[[1,2,4],[1,5],[1,3]].combinations()}"