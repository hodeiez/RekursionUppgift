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
    val result = mutableListOf<String>()

    fun buildList(name:String):List<String>{
        if(name.isNotBlank()){
            result.add(name)
          try{
              buildList(createList().filter{it.child.contains(name)}.map(Arbetare::getName).last())
        } catch(e :NoSuchElementException){
              return result.reversed()
          }
        }
        return result
    }
    return if(name==createList()[0].name){
        result.add(createList()[0].name)
        result }
    else{
        buildList( createList().filter{it.child.contains(name)}.map(Arbetare::getName).last())
    }
}
fun findWorkers(name:String):List<String>{
    val result=mutableListOf<String>()
    fun buildList(name:String):List<String>{
        if(name.isNotBlank()&& !result.contains(createList()[createList().size-1].name)){
          //change replace to regex!!!!
            name.replace("[","").replace("]","").split( ", ").forEach{result.add(it)}
            buildList(createList().filter{result.contains(it.name)}.map(Arbetare::getChild).flatten().toString())
        }
        else
            result.add( name.replace("[","").replace("]",""))
        return result
    }
    return if (name==createList()[createList().size-1].name)
    result
    else
        buildList(createList().filter{it.name==name}.map(Arbetare::getChild).flatten().toString())

}
fun main() {
//findSuperior("Räven").forEach(::println)
findWorkers("Räven").forEach(::println)
findWorkers("Skumtomten").forEach(::println)

}
