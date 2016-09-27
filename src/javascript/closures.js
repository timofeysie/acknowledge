// A Counter Dilemma

var counter1 = 0; 
function add1() { 
    var counter2 = 0; 
    counter1 += 1; 
    counter2 += 1; 
    console.log('add1.counter1',counter1);
    console.log('add1.counter2',counter2);
} 
add1(); 
add1(); 
add1(); // counter1 is 3, counter2 is 1. 

/* 
Closures solution

closures make it possible for a function to have "private" variables. 
The counter is protected by the scope of the anonymous function, 
and can only be changed using the add function, 
a function having access to the parent scope, 
even after the parent function has closed. */
var add2 = (function () { 
    var counter = 0; 
    return function () {
        counter += 1;
        console.log('add2.counter',counter);
        return counter;
    } 
})(); 
add2();
add2(); 
add2(); // the counter is now 3
