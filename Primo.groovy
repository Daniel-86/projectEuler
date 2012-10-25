/*
*    Daniel Jimenez Ortega
*    Para hacer calculos que involucran numeros primos
*/


class Primo {
	private static List primos = [2, 3]
	private Integer numero
	private boolean esPrimo
	
	
	
	static List getPrimos (numero, ...prim) {
		List primosAnte
		if (!prim)
			primosAnte = primos.grep { it <= numero }
		else
			primosAnte = prim.flatten()
//		println "\nRECIBIO ($numero) -- $primosAnte"
		Integer maxAnte = primosAnte.max()

		if ( (maxAnte && maxAnte == numero) || !maxAnte )
			return primosAnte
		( primosAnte.max()+1..numero ).each { n->
			boolean esPrimo = true
			for (primo in primosAnte){
				if (n % primo == 0) {esPrimo = false; break;}}
			if (esPrimo) {
				primosAnte += n
				if ( !(n in primos) ) primos += n
			}
		}
		return primosAnte
	}
	
	
    	static boolean esPrimo (numero, ...prim) {
		boolean esPrimo = true
		List primosAnte
		if (!prim)
			primosAnte = Primo.getPrimos(numero)
		else
			primosAnte = prim.flatten()
		primosAnte -= numero
		for (primo in primosAnte) {
			if (numero % primo == 0) {
				esPrimo = false
				break
			}
		}
		return esPrimo
	}
	
	
	static Integer getNextPrimo (numero, ...prim) {
		while ( !Primo.esPrimo(++numero, prim) );
		if ( !(numero in primos) )
			primos += numero
		return numero
	}
	
	
	static Integer getNPrimo (indice) {
		Integer actIndx = primos.size()
		if (actIndx >= indice)
			return primos[--indice]
		Integer act = primos.max()
		List primosAux = Primo.getPrimos(act)
		while (actIndx < indice) {
			act = Primo.getNextPrimo(act, primosAux)
			primosAux += act
			actIndx++
		}
		return act
	}
	
	

	
	
	
	
	
	static Integer gNP(numero, primosAnt = [1], esPrim = true){
		if(primosAnt.size()==1 && numero>2){
		    primosAnt = pA(numero)
		    esPrim = eP(numero, primosAnt)
		}
		if(esPrim)
		    primosAnt += numero

		Integer i = numero + 1
		for(; !eP(i,primosAnt); i++);
		return i
	}
	
	static boolean eP(numero, primosAnt = [1]){
        if(numero == 1)
            return true
        boolean esPrimo = true
        if(primosAnt.size() == 1 && numero > 2)
            primosAnt = pA(numero)
        for(it in primosAnt){
            if(it != 1 &&  numero%it == 0){
                esPrimo = false
                break;
            }
        }
        return esPrimo
    }
    
	static List pA(numero, listaPrimos = [1]){
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
	
	static Integer grimo(indice){
		Integer primoN = 1
		List primosAnt = [2]
		boolean esPrim
		for(def contador = 1; contador < indice; contador++){
//      	      esPrim = esPrimo(primoN, primosAnt)
        	    primoN = gNP(primoN, primosAnt,true)
        	    primosAnt = pA(primoN, primosAnt)
        	    //println "anteriores en NPrimo: $primosAnt"
        	}
	        return primoN
	}
}

//List primo = [1,3,5,8,9]
//Integer numero = -4
//println  ( (primo.min {(it - numero).abs()})..numero )
