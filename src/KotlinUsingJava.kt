import java.util.*
/**
 * Created by Hodei Eceiza
 * Date: 1/11/2021
 * Time: 09:23
 * Project: kotlinTest
 * Copyright: MIT
 */
fun createList():List<Arbetare>{
    val arbetare= mutableListOf<Arbetare>()
arbetare.add(Arbetare("Tomten",listOf("Glader","Butter")))
arbetare.add(Arbetare("Glader",listOf("Tröger","Trötter","Blyger")))
arbetare.add(Arbetare("Butter",listOf("Rådjuret","Nyckelpigan","Haren","Räven")))
arbetare.add(Arbetare("Trötter",listOf("Skumtomten")))
arbetare.add(Arbetare("Skumtomten",listOf("Dammråttan")))
arbetare.add(Arbetare("Räven",listOf("Gråsuggan","Myran")))
arbetare.add(Arbetare("Myran",listOf("Bladlusen")))
return arbetare
}
fun findSuperior(name:String):List<String>{
    val createdList=createList()
    val result = mutableListOf<String>()

    fun buildList(name:String):List<String>{
        if(name.isNotBlank()){
            result.add(name)
            println(result)
            buildList(createList().filter{e->e.child.contains(name)}.map(Arbetare::getName).last())
        }
        return result

    }

    return if(name==createList()[0].name){
        result.add(createList()[0].name)
        result }
    else{
        buildList( createList().filter{e->e.child.contains(name)}.map(Arbetare::getName).last())
    }
}
fun main() {
findSuperior("Räven").forEach(::println)

}