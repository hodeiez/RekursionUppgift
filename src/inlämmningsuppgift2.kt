/**
 * Created by Hodei Eceiza
 * Date: 1/9/2021
 * Time: 21:58
 * Project: kotlinTest
 * Copyright: MIT
 */
fun main() {

//a simple map of strings to save Tomtens organizational structure.
    val workers = mutableMapOf<String, List<String>>();
    workers["Tomten"] = listOf("Glader", "Butter")
    workers["Glader"] = listOf("Tröger", "Trötter", "Blyger")
    workers["Butter"] = listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven")
    workers["Trötter"] = listOf("Skumtomten")
    workers["Skumtomten"] = listOf("Dammråttan")
    workers["Räven"] = listOf("Gråsuggan", "Myran")
    workers["Myran"] = listOf("Bladlusen")

//Looking for superiors
    fun findWhoAreSuperior(name: String): List<String> {

        val result = mutableListOf<String>()

        //down here the recursive function
        fun buildList(name: String): List<String> {

            val boss= workers.filter { (_, v) -> v.contains(name) }.keys.joinToString {it}
            if (boss.isNullOrEmpty()) throw Exception("Didn't find anyone with that name")//throws an exception
            result.add(boss)
            if (boss != workers.keys.toList()[0]) {
                buildList(boss)
            }
            return result.reversed()
        }

        return if (name == workers.keys.toList()[0])//if its Tomten will return list with only Tomten (AKA the BOSS)
            listOf(workers.keys.toList()[0])
        else
            return buildList(name)

    }
//Looking for workers
    fun findWhoAreWorker(name: String):List<String>{

        val result=mutableListOf<String>()
       val list=workers.filter{(k,_)->name.contains(k)}.values.flatten().toList()

    //here the recursive function
       tailrec fun buildList(list:List<String>){
            if(list.isNotEmpty()){
            list.forEach{result.add(it)}

           buildList(workers.filter{(k,_)->workers.keys.filter{list.contains(it)}.toString().contains(k)}.values.flatten().toList())
                //not very readable this last one. I could transform val list into a function, and then pass the string "workers.keys.filter{v->list.contains(v)}.toString()"
                //through that function. but, its nice to have less lines. :)
            }
        }
        buildList(list)
        return result;
    }


    println("---------searching for happy bosses--------------")
    println("searching for Dammråttan")
    findWhoAreSuperior("Dammråttan").forEach(::println)
    println("\n")
   // println("searching for \"No one\" will throw an exception  ")
    // findWhoAreSuperior("No one").forEach(::println)
    println("searching for Tomten")
    findWhoAreSuperior("Tomten").forEach(::println)
    println("\n")
    println("---------searching for happy workers--------------")
    println("searching for Räven")
    findWhoAreWorker("Räven").forEach(::println)
    println("\n")
    println("searching for Tomten")
   findWhoAreWorker("Tomten").forEach(::println)
    println("\n")

    println("searching for No one")
    findWhoAreWorker("No one").forEach(::println)
    println("\n")


}


