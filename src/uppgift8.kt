/**
 * Created by Hodei Eceiza
 * Date: 1/20/2021
 * Time: 10:18
 * Project: kotlinTest
 * Copyright: MIT
 */

fun main(){
    val toUpperCases:(s:String)->String={it.toUpperCase()}
    val removeAllWhiteSpaces:(s:String)->String={it.filter{!it.isWhitespace()}}


    fun textDistortion(distort:(String)->String){
        println("text to distort")
        val s=readLine()!!.toString()
        println(distort(s))
    }
    println(toUpperCases("aaaaa"))
    println(removeAllWhiteSpaces("a a a  a a a a"))

    textDistortion(toUpperCases)
    textDistortion(removeAllWhiteSpaces)
}