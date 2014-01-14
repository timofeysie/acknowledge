println "Groovy adds a number of methods to java.lang.Object, "
println "most of which deal with types that serve as collections or aggregates, "
println "such as Lists or DOM Nodes."
println "Since the return keyword is optional in Groovy, closures in this context "
println "act as \"predicates\" and return the boolean result of whatever "
println "expression you given in your closure. "
println "These predicates allow you to apply perform operations on aggregate "
println "objects in a very concise manner."

def numbers = [ 5, 7, 9, 12 ]
assert numbers.any { it % 2 == 0 }                        //returns true since 12 is even
assert numbers.every { it > 4 }                           //returns true since all #s are > 4
assert numbers.findAll { it in 6..10 } == [7,9]           //returns all #s > 5 and < 11
assert numbers.collect { ++it } == [6, 8, 10, 13]         //returns a new list with each # incremented
numbers.eachWithIndex{ num, idx -> println "$idx: $num" } //prints each index and number

println ""
assert numbers.any { it % 2 == 0 }                        //returns true since 12 is even
assert numbers.every { it > 4 }                           //returns true since all #s are > 4
assert numbers.findAll { it in 6..10 } == [7,9]           //returns all #s > 5 and < 11
assert numbers.collect { ++it } == [6, 8, 10, 13]         //returns a new list with each # incremented
numbers.eachWithIndex{ num, idx -> println "$idx: $num" } //prints each index and number
