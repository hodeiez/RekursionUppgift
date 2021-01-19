package AoC

import java.io.File

/**
 * Created by Hodei Eceiza
 * Date: 1/18/2021
 * Time: 22:50
 * Project: kotlinTest
 * Copyright: MIT
 */
fun main() {
    //done in an awful way hard coded the pattern repetition and used a nasty for loop
    val input = File("src/AoC/day3.txt")
    val theList = input.readLines().map { it }

    val mList = mutableListOf<Char>()

    fun findTrees(down: Int, right: Int) {
        var rightAwful = right
        for (i in down until theList.size step down) {
            mList.add(theList[i].toCharArray()[rightAwful])
            rightAwful += right
            if (rightAwful >= theList[i].length) rightAwful -= theList[i].length
        }
    }
    findTrees(2, 1)
//78
    //247
    //68
    //69
    //78
    val number:Long=90396072.toLong()*33
    println(number)
    println(mList.filter { it == '#' }.count().toLong())
    fun slopeCheck(jump: Int, toRight: Int) {

    }



    }