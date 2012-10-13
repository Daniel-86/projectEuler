//def suma = 0
//for(i in 3..<1000){
//    if(i%3==0 || i%5==0)
//        suma += i
//}
//println "la suma de los multiplos es $suma"

(3..1000).collect{ (it%3 == 0 || it%5 == 0)? it: 0 }.sum()
