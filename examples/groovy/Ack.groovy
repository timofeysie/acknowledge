println "the standard school swap case in one line"
// given those two variables
def a1 = 1, b1 = 2
// swap variables with a list
(a1, b1) = [b1, a1]
assert a1 == 2
assert b1 == 1

// Foo was here.
println ""
println "24.  It's possible to omit parenthesis when using named arguments. "
println "This makes for nicer DSLs"
// compare fund: "SuperInvestment", withBench: "NIKEI"
// monster.move from: [3,4], to: [4,5]

println ""
println "25.  method calls"
println "When calling a method you can pass in named parameters"
println "for calling methods which take a Map or for constructing JavaBeans."
def bean = new Expando(name:"James", location:"London", id:123)
println "Hey "+bean.name+" from "+bean.location
assert bean.id == 123


