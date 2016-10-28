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

/* Closures have the same process as mailing a package */
function packBox(item){
    // Code that puts item in the box
    console.log('Put ' +item+ ' in the box');
    function addressPackage(address){
        // Code that writes the address label
        console.log('Addressed the box to ' +address+' and ready to send the '+item+' gift');
    }
    return addressPackage;
}

var brotherGift= packBox('jersey')

brotherGift('123 Main Street, Anywhere USA 012345')
// Put jersey in the box
// Addressed the box to 123 Main Street, Anywhere USA 012345 and ready to send the jersey gift

// If we wanted to do this in one line, we would write: 
packBox(‘jersey’)(‘123 Main Street, Anywhere USA 01234’);

// If we wanted to pack all the gifts first and address them all later:
var brotherGift = packBox('jersey')
var motherGift = packBox('iTunesCard')

brotherGift('123 Main Street, Anywhere USA 01234')
//Put jersey in the box
// Addressed the box to 123 Main Street, Anywhere USA 01234 and ready to send the jersey gift
motherGift('123 High Street, Los Angeles USA 01234')
//Put iTunesCard in the box
// Addressed the box to 123 High Street, Los Angeles USA 01234 and ready to send the iTunesCard gift


// Based on the great example by Kevin Kononenko at 
// https://medium.freecodecamp.com/javascript-closures-explained-by-mailing-a-package-4f23e9885039#.eq3yk96do

