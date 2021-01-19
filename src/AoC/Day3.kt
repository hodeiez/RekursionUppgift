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
    val theList=input.readLines().map{it}

    val mList= mutableListOf<Char>()
    var j=0
    for(i in theList){
        mList.add(i.toCharArray()[j])
        j+=3
        if(j>=i.length) j -= i.length
   }
   println( mList.filter{ it == '#' }.count())
    fun slopeCheck(jump:Int,toRight:Int){

    }

}