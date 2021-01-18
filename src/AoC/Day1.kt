package AoC

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 1/18/2021
 * Time: 13:08
 * Project: kotlinTest
 * Copyright: MIT
 */
fun main(){
    val myInput= File("src/AoC/day1.txt")
    val theList= myInput.readLines().map{it.toInt()}

    //part 1
val result=theList.filter{theList.contains(2020-it)}.let{(a,b)->a*b}
    println(result)

    //part 2
}