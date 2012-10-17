
class Primo {
	private static List primos = [2, 3]
	private Integer numero
	private boolean esPrimo
	
		
	static List getPrimos (numero) {
		List primosAnte = primos.grep { it <= numero }
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
	
	
	static List primos (numero) {
		List primosAnte = primos.grep { it <= numero }
		Integer maxAnte = primosAnte.max()

		if ( (maxAnte && maxAnte == numero) || !maxAnte )
			return primosAnte
		( primosAnte.max()+1..numero ).each { n->
			boolean esPrimo = true
			for (primo in primosAnte)
				if (n % primo == 0) {esPrimo = false; break}
			if (esPrimo) {
				primosAnte += n
				if ( !(n in primos) ) primos += n
			}
		}
		return primosAnte
    	}
}

//List primo = [1,3,5,8,9]
//Integer numero = -4
//println  ( (primo.min {(it - numero).abs()})..numero )
