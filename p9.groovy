def encuentraNumeros(suma = 1000){
    def a, b, c
    boolean salir = false
    for(a=1; a<1000; a++){
        for(b=1; b<1000; b++){
            if(b == a)
                continue
            c = suma - a -b
            if(c**2 == (a**2 + b**2)){
                salir = true
                break
            }
        }
        if(salir)
            break
    }
    println "a:$a  b:$b  c:$c\tproducto:${a*b*c}"
}

encuentraNumeros()