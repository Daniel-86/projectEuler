def numXenLapso = { diaSemana, fechaIni, fechaFin->
//    Calendar inicio = Calendar.instance
    def inicio = new GregorianCalendar(1901, Calendar.JANUARY, 1)
    def fin = new GregorianCalendar(2000, Calendar.DECEMBER, 31)
//    def fin = new GregorianCalendar(1901, Calendar.MARCH, 1)
    def primero = inicio
    while (primero.get(Calendar.DAY_OF_WEEK) != diaSemana)
        primero = primero.next()
    def numDias = 0
    for(def i = primero; i < fin; i = i.next()){//println "${i.time.toString()}   ${i.get(Calendar.DAY_OF_WEEK)}"
        if(i.get(Calendar.DAY_OF_WEEK) == diaSemana && i.get(Calendar.DAY_OF_MONTH) == 1)
            numDias++
//        if (i.get(Calendar.YEAR) == 1904 && i.get(Calendar.MONTH) == Calendar.FEBRUARY)
  //          println "${i.time}"
    }
  /*  inicio.set(Calendar.YEAR, 1901)
    inicio.set(Calendar.MONTH, Calendar.JANUARY)
    inicio.set(Calendar.DATE, 1)
    Calendar fin = Calendar.instance
    fin.set(Calendar.YEAR, 2000)
    fin.set(Calendar.MONTH, Calendar.DECEMBER)
    fin.set(Calendar.DATE, 31)*/
    
//    println "primer dia de la semana ${inicio.firstDayOfWeek}"
    println "el numero de $diaSemana son $numDias"
}

numXenLapso(1,2,3)