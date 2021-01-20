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



    fun findTrees(down: Int, right: Int):Long {
        var rightAwful = right
        val mList = mutableListOf<Char>()
        for (i in down until theList.size step down) {
            mList.add(theList[i].toCharArray()[rightAwful])
            rightAwful += right
            if (rightAwful >= theList[i].length) rightAwful -= theList[i].length
        }
        return mList.filter{it=='#'}.count().toLong()
    }
//puzzle 1
    println(findTrees(1, 3))
    //puzzle 2
    println(findTrees(1,3)*findTrees(1,1)*findTrees(1,5)*findTrees(1,7)*findTrees(2,1))
    }