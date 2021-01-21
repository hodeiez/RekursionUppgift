/**
 * Created by Hodei Eceiza
 * Date: 1/21/2021
 * Time: 10:51
 * Project: kotlinTest
 * Copyright: MIT
 */
fun main(){
val names= listOf<String>("kattis","hundis","fiskis","tigeris")
val legs=listOf<Int>(4,4,0,4)

    val animals=names.zip(legs){name,legs->Animal(name,legs)}
    animals.forEach{it.printAnimal()}
//10b
    val numbers=listOf(2,3,8,45,123,256,2345)
   println( numbers.zipWithNext{a,b->b-a})
}