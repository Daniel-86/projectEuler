List digitos =  (0..9)
List permuta = digitos.permutations().collect{ it.join() }.sort()
println permuta.get(1000000 - 1)
