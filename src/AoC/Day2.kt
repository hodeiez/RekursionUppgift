package AoC

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 1/20/2021
 * Time: 09:58
 * Project: kotlinTest
 * Copyright: MIT
 */

/*
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
old testin stuff
 // val input= File("src/AoC/day2.txt").readLines().map{it.toCharArray().filter{it.isLetterOrDigit()}}
  //input.forEach { println(validCode(it[0].toString().toInt(),it[1].toString().toInt(),it[2],it.toMutableList().slice(3 until it.size).toString()))}
 */

fun validCode(min:Int, max:Int, letter: String, code:String):Int{
    var count=0
    if(code.toCharArray().filter{it.toString()==letter}.count().takeIf{ it in min..max }!=null)
        count++
    return count
}
fun validCodePart2(min:Int, max:Int, letter: String, code:String):Int{
    var count=0
    if(code.toCharArray().takeIf{(it[min-1].toString()==letter || it[max-1].toString()==letter)&& it[min-1]!=it[max-1]}!=null)
        count++
    return count
}

fun main(){

    val input= File("src/AoC/day2.txt").readLines().map{it.split("-"," ",": ")}

    //puzzle1
   println( input.map { listOf(validCode(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum())

    //puzzle2
    println( input.map { listOf(validCodePart2(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum())
     //input.map { listOf(validCodePart2(it[0].toInt(),it[1].toInt(),it[2],it[3])).sum()}.sum()

}