package AoC

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 1/20/2021
 * Time: 09:58
 * Project: kotlinTest
 * Copyright: MIT
 */

//ONE LINE SOLUTIONS
fun validCode(min:Int, max:Int, letter: String, code:String)=code.toCharArray().filter{it.toString()==letter}.count().takeIf{ it in min..max }.let{it?.minus(it)?.plus(1)}?:0

fun validCodePart2(min:Int, max:Int, letter: String, code:String)= code.toCharArray().takeIf{(it[min-1].toString()==letter || it[max-1].toString()==letter)&& it[min-1]!=it[max-1]}.let{it?.size?.minus(it.size)?.plus(1)}?:0

//READABLE SOLUTIONS
/*
fun validCode(min:Int, max:Int, letter: String, code:String):Int{
    var count=0
    if(code.toCharArray().filter{it.toString()==letter}.count().takeIf{ it in min..max }!=null)
        count++
    return count
}

 */
/*
fun validCodePart2(min:Int, max:Int, letter: String, code:String):Int{
    var count=0
    if(code.toCharArray().takeIf{(it[min-1].toString()==letter || it[max-1].toString()==letter)&& it[min-1]!=it[max-1]}!=null)
        count++
    return count
}

 */

fun main(){

    val input= File("src/AoC/day2.txt").readLines().map{it.split("-"," ",": ")}

    //puzzle1
   println( input.map { listOf(validCode(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum())

    //puzzle2
    println( input.map { listOf(validCodePart2(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum())
     //input.map { listOf(validCodePart2(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum()

}