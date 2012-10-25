/*
*    Daniel Jimenez Ortega
*    Cual es el 10001 primo?
*/

import groovy.time.*

class Primo{
    private boolean esPrimo = true
    private List primosAnt = []
    private Integer numero
    static List primos = []
    
    public Primo(numero){
        this.numero = numero
        primosAnt()
        esPrime()
    }
    
    private void primosAnt(listaPrimos = [1]){
        primosAnt = primosAnteriores(this.numero, listaPrimos)
    }
    
    private void esPrime(){
        esPrimo = esPrimo(this.numero, this.primosAnt)
    }
    
    static List primosAnteriores(numero, listaPrimos = [1]){
        if(numero == 1)
            return [1]
//        def primosAnt = listaPrimos.grep{ it < numero}
        List primosAnt = listaPrimos
        for(Integer i=primosAnt.max() + 1; i<numero; i++){
            boolean esPrimoA = true
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
    
    static boolean esPrimo(numero, primosAnt = [1]){
        if(numero == 1)
            return true
        boolean esPrimo = true
        if(primosAnt.size() == 1 && numero > 2)
            primosAnt = primosAnteriores(numero)
        for(it in primosAnt){
            if(it != 1 &&  numero%it == 0){
                esPrimo = false
                break;
            }
        }
        return esPrimo
    }
    
    String toString(){
        return "$numero es primo: $esPrimo"
    }
    
    List getPrimosAnteriores(){
        return primosAnt
    }
    
    static Integer getNextPrimo(numero, primosAnt = [1], esPrim = true){//println "recibe $numero, $primosAnt, $esPrim"
        if(primosAnt.size()==1 && numero>2){//println "calcula anteriores en NextPrimo"
            primosAnt = primosAnteriores(numero)
            esPrim = esPrimo(numero, primosAnt)
        }
        if(esPrim)
            primosAnt += numero
        //println "anteriores en NextPrimo: $primosAnt"
        Integer i = numero + 1
        for(; !esPrimo(i,primosAnt); i++);
        return i
    }
    
    static Integer getNPrimo(indice){
        Integer primoN = 1
        List primosAnt = [2]
        boolean esPrim
        for(def contador = 1; contador < indice; contador++){
//            esPrim = esPrimo(primoN, primosAnt)
            primoN = getNextPrimo(primoN, primosAnt,true)
            primosAnt = primosAnteriores(primoN, primosAnt)
            //println "anteriores en NPrimo: $primosAnt"
        }
        return primoN
    }
}










List primos = [2, 3]
def getPrimos = { Integer numero->
    if(numero < 2)
        return []
    List primosAnt = primos.grep { it <= numero }
    Integer inicio = primosAnt.max() ?: 2
    (inicio % 2) ?: inicio++
    boolean actPrimos = inicio >= primos.max()
    Integer incremento = 2
//    ( inicio == 2)? (incremento = 1): (incremento = 2)
    for(Integer i=inicio; i<=numero; i+=incremento){
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

def esPrimo = { Integer num->
    List primosAnte = getPrimos(num)
    primosAnte -= num
   // println "$num ${primosAnte}"
    boolean resultado = true
    for (primo in primosAnte)
        if ( num % primo == 0 ){
            resultado = false
            break
        }
    return resultado
//    return num in primosAnte
}

def getNextPrimo = { Integer num->
    while (!esPrimo(++num));
    return num
}

def getPrimoN = { Integer N->
    Integer primo = 1
//    N.times { primo = getNextPrimo (primo) }
    (1..N).each{
        primo = getNextPrimo (primo)
        if ( !(primo in primos) ){//println "agrega primo"
            primos += primo}
    }
    return primo
}








Date inicio = new Date()
Integer numero = 10001
//def numero = 300
/*def prime = new Primo(numero)
println "probando  $prime"
println "sus primos anteriores son: ${prime.getPrimosAnteriores()}"*/
//println "el siguiente primo de $numero es: ${Primo.getNextPrimo(numero)}"

//println "${getPrimoN(numero)}"
//println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}\n"

inicio = new Date()
println "el primo $numero es ${Primo.getNPrimo(numero)}"
//println "primos ${Primo.primosAnteriores(numero)}"
println "Ejecutado2 en ${TimeCategory.minus(new Date(), inicio)}\n"
//println primos
//println "${5.times{println it}}"
