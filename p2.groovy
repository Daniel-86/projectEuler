def fibonacci(numero){
    assert numero > 0
    if(numero == 1)
        return 1
    if(numero == 2)
        return 2
    else
        return fibonacci(numero -2) + fibonacci(numero - 1)
}


def resolver(){
    def suma = 0
    def numero = 2
    for(; ; numero ++){
        def temp = fibonacci(numero)
        if(temp < 4000000){
            if(temp % 2 == 0)
                suma += temp
        }
        else
            break
    }
    return suma
}

println "resultado: ${resolver()}"