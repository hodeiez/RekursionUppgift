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

    //part 2 // 1,2,3,4---1 + 2+ 3---1 + 2 + 4
    val result2=theList.sorted().forEach{it}
        println(result2)

    //checked this solution for the second puzzle, but, couldn't solve it. have to figure it out
    //MIGUEL VARGAS
    fun addUpto(total: Int) = theList.filter { theList.contains(total - it) }

    fun threeAddUpTo(total: Int) = theList.filter { addUpto(total - it).isNotEmpty() }

// part 1
    println(addUpto(2020).let { it[0] * it[1] })
// part2
    println(threeAddUpTo(2020).let { it[0] * it[1] * it[2] })
}
