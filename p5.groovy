/**
*    Daniel Jimenez Ortega
*    Encontrar el minimo comun multiplo para los numeros del 1 al 20
*/

import groovy.time.*


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

Date inicio = new Date()
rango = 1..20
println "MCM de 1..20 es: ${MCM(rango)}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
