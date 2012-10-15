class Primo{
    private def esPrimo = true
    private def primosAnt = []
    private def numero
    
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
    
    static def primosAnteriores(numero, listaPrimos = [1]){
        if(numero == 1)
            return [1]
//        def primosAnt = listaPrimos.grep{ it < numero}
        def primosAnt = listaPrimos
        BigInteger suma = 0
        for(def i=primosAnt.max() + 1; i<numero; i++){
            def esPrimoA = true
            for(it in primosAnt){
                if(it != 1 &&  i%it == 0){
                    esPrimoA = false
                    break
                }
            }
            if(esPrimoA){
                primosAnt += i//; println "calc: $i"
                suma += i}
        }
        return suma
    }
    
    static boolean esPrimo(numero, primosAnt = [1]){
        if(numero == 1)
            return true
        def esPrimo = true
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
    
    def getPrimosAnteriores(){
        return primosAnt
    }
    
    static def getNextPrimo(numero, primosAnt = [1], esPrim = true){//println "recibe $numero, $primosAnt, $esPrim"
        if(primosAnt.size()==1 && numero>2){//println "calcula anteriores en NextPrimo"
            primosAnt = primosAnteriores(numero)
            esPrim = esPrimo(numero, primosAnt)
        }
        if(esPrim)
            primosAnt += numero
        //println "anteriores en NextPrimo: $primosAnt"
        def i = numero + 1
        for(; !esPrimo(i,primosAnt); i++);
        return i
    }
    
    static def getNPrimo(indice){
        def primoN = 1
        def primosAnt = [1]
        def esPrim
        for(def contador = 1; contador <= indice; contador++){
//            esPrim = esPrimo(primoN, primosAnt)
            primoN = getNextPrimo(primoN, primosAnt,true)
            primosAnt = primosAnteriores(primoN, primosAnt)
            //println "anteriores en NPrimo: $primosAnt"
        }
        return primoN
    }
}


def getPrimosL(listaNumeros){
    def listaPrimos = []
    listaNumeros.each{
        def esPrimo = true
        for(i=2; i<it; i++)
            if(it%i == 0){
                esPrimo = false
                break
            }
        if(esPrimo== true)
            listaPrimos += it
     }
     return listaPrimos
}


def numero = 2000000
/*def prime = new Primo(numero)
println "probando  $prime"
println "sus primos anteriores son: ${prime.getPrimosAnteriores()}"*/
//println "el siguiente primo de $numero es: ${Primo.getNextPrimo(numero)}"
//(println "La suma de los primos anteriores a $numero es ${Primo.primosAnteriores(numero).sum() - 1}"
println "La suma de los primos anteriores a $numero es ${Primo.primosAnteriores(numero)}"