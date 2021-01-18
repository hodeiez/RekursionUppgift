package AoC

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 1/18/2021
 * Time: 22:50
 * Project: kotlinTest
 * Copyright: MIT
 */
fun main(){
    //done in an awful way hard coded the pattern repetition and used a nasty for loop
    val input= File("src/AoC/day3.txt")
    val theList=input.readLines().map{it.repeat(50)}
    var j=0
    val mList= mutableListOf<Char>()

   for(i in theList){
       mList.add(i.toCharArray()[j])
       j+=3
   }
   println( mList.filter{ it == '#' }.count())


}