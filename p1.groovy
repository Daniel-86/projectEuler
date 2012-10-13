def suma = 0
for(i in 3..<1000){
    if(i%3==0 || i%5==0)
        suma += i
}
println "la suma de los multiplos es $suma"