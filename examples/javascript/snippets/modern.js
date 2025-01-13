/*
Destructuring, the spread and rest operators
introduced in ES6 (ES2015)

Destructuring is about unpacking values into named variables

The rest operator is often confused with the spread operator, 
which looks identical (...) but serves the opposite purpose - 
the spread operator spreads array elements out into individual elements
the rest operator collects them together into an array.

*/

// 1. Destructuring: Unpacking values from arrays or properties from objects into distinct variables
// Array destructuring
const [a, b] = [1, 2];
// Object destructuring
const { name, age } = person;

// Spread Operator (...): Expands elements (spreads them out)
// Array spreading
const arr1 = [1, 2];
const arr2 = [...arr1, 3, 4]; // [1, 2, 3, 4]
// Object spreading
const obj1 = { foo: 'bar' };
const obj2 = { ...obj1, baz: 'qux' };

// 3. Rest Operator (...): Collects multiple elements into an array
const [first, second, ...others] = [1, 2, 3, 4];
console.log('first', first);
console.log('others', others);
function sum(first, second, ...numbers) {
  console.log('first', first);
  console.log('second', second);
  return numbers.reduce((total, n) => total + n, 0);
}
const result = sum(10, 2, 3, 4);
console.log('result', result)
/* output:
first 1
others (2) [3, 4]
first 10
second 2
result 7
 */