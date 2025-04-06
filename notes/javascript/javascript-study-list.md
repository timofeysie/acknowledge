# JavaScript Study List

## Helpful links

- [React 18](https://stackblitz.com/edit/react-nbahye)
- [Counter solution](https://stackblitz.com/edit/react-foabu6?file=src%2FApp.js,src%2Fstyle.css,README.md)
- [Functional fun](https://plnkr.co/edit/8UHAOd?p=preview&preview)

## Event loop

*Can you explain the JavaScript event loop and how it handles asynchronous operations?*

*What are microtasks and macrotasks in the context of the event loop?*

A crucial concept for understanding how JavaScript handles asynchronous tasks.

### (Call) Stack: synchronous code

Function calls form a stack of frames. When a function is called, a new frame is created and pushed onto the stack. When the function returns, the top frame is popped out. This stack manages the execution order of functions.

### Heap: Objects

Objects are allocated in a heap, which is a large region of memory. It's where dynamically allocated memory lives.

### Microtask Queue: Promises and Mutation Observer

The Event Loop checks the Microtask Queue First.
Promises and Mutation Observers, and process.nextTick. These microtasks take precedence over regular tasks, ensuring their execution as soon as the call stack is clear.

### Task Queue: I/O operations, timer callbacks, and other user-defined callbacks

Tasks in the Task Queue are executed after the Microtask Queue is empty. This queue forms the backbone of JavaScript's event-driven architecture

### (Callback) Queue: async code

JavaScript uses a message queue to handle asynchronous tasks. Each message has an associated function. During the event loop, the runtime processes messages from the queue, starting with the oldest one. Functions are called until the stack is empty.

### Event Loop

The event loop constantly monitors the callback queue and the call stack. If the call stack is empty, it places the next function from the callback queue onto the stack. This allows JavaScript to handle concurrency and execute blocking functions asynchronously.

```js
console.log("First"); 
setTimeout(function timeout() { 
    console.log("Fourth Callback"); 
}, 0);
Promise.resolve('Promise')
  .then(() => console.log('Third Promise'));
console.log("Second");
```

In summary, the event loop ensures that JavaScript can handle multiple tasks efficiently, even though it's single-threaded.

See [this great visualization](https://media.licdn.com/dms/image/v2/D4D12AQHAa2zbhYhlWw/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1686229107951?e=1747267200&v=beta&t=bMwt3ZSqHURmhfSfC5D-U-1aq3LEjeqOuYQ_713iV1Q) from an article by Deepam K. [on LinkedIn](https://www.linkedin.com/pulse/event-loop-visualized-unveiling-mysterious-enigma-deepam-kapur/).

#### The Call Stack

The call stack is a stack of frames that represent the current execution context. It's used to manage the execution of functions.

```js
function third() { console.log('third'); }
function second() { console.log('second calls third'); third() }
function first() { console.log('first calls second'); second() }
console.log('begin')
first();
```

#### Mutation Observer

A Mutation Observer introduced in ES6 is used to watch for changes in the DOM. It's a microtask that takes precedence over regular tasks.  In code, a real-world example might look like this:

```js
const observer = new MutationObserver((mutations) => {
  mutations.forEach((mutation) => {
    console.log(mutation);
  });
});
```

They can be used for things like tracking changes in the DOM, or tracking changes in the state of a component.  For example, if you want to track changes in the state of a component, you can use a Mutation Observer to watch for changes in the DOM.

```js
observer.observe(document.body, {
  childList: true,
  subtree: true
});
```

This will watch for changes in the DOM, and log the changes to the console.

#### process.nextTick

process.nextTick is a microtask that takes precedence over regular tasks. It's used to schedule tasks to be executed after the current operation completes.

```js
process.nextTick(() => {
  console.log("Next Tick");
});
```

process.nextTick can be used to schedule tasks to be executed after the current operation completes.

## Variables & Scope

### var, let, and const

*What's the difference between var, let, and const in JavaScript?*

*When would you use each one?*

*Can you explain the concept of block scope vs. function scope?*

### var

|Scope|Function-scoped|
|---|---|
|Hoisting|hoisted to the top of their scope and initialized with undefined|

- can re-declare var variables within the same scope without errors
- avoided due to its function-scoping and hoisting behavior

### let

|Scope|Block-scoped|
|---|---|
|Hoisting|let variables are hoisted but not initialized. Accessing them before declaration results in a ReferenceError.|

- cannot re-declare let variables within the same scope.
- When to use: Use let when you need a variable that can be reassigned and is limited to the block scope.

### const

|Scope|Block-scoped, similar to let.|
|---|---|
|Hoisting|const variables are hoisted but not initialized. Accessing them before declaration results in a ReferenceError.|

---

- cannot re-declare const variables within the same scope.
- Assignment: const variables must be initialized at the time of declaration and cannot be reassigned.
- When to use: Use const for variables that should not be reassigned after their initial assignment. This is ideal for constants and values that should remain unchanged.
- requires an initial value at the time of declaration and cannot be reassigned. However, if the variable is an object or array, the properties or elements can be modified.

#### Hoisting vs. declaration

```Hoisting```: Like let, const declarations are hoisted to the top of their block scope, but they remain in the "Temporal Dead Zone" (TDZ) until the actual declaration line is reached.

```Declaration Requirements```: When you write the actual declaration, you must provide an initial value. You cannot declare a const without initializing it.

Example

```js
console.log(myConst); // ReferenceError: Cannot access 'myConst' before initialization
const myConst = 5;    // Must provide value here
```

### var, let, and const comparison

| Feature | var | let | const |
|---------|-----|-----|-------|
| Scope | Function-scoped | Block-scoped | Block-scoped |
| Hoisting | Hoisted and initialized as undefined | Hoisted but not initialized (TDZ) | Hoisted but not initialized (TDZ) |
| Reassignment | Can be reassigned | Can be reassigned | Cannot be reassigned |
| Redeclaration | Can be redeclared | Cannot be redeclared | Cannot be redeclared |
| Initial Value | Optional | Optional | Required |
| Mutability | Mutable | Mutable | Reference is immutable, but properties can be modified |

> Note: TDZ = Temporal Dead Zone (cannot access variable before declaration)

Best Practices:

- Use `const` by default
- Use `let` when you need to reassign values
- Avoid `var` due to its function-scoping and hoisting behavior

### Why var is avoided

#### 1. The Problem with Function Scope

var is function-scoped, not block-scoped.

Variables declared with var are accessible throughout the entire function, regardless of where they're declared.

This can lead to unexpected behavior and bugs.

```js
function example() {
  if (true) {
    var x = 10; // Accessible throughout the entire function
  }
  console.log(x); // 10 - still accessible outside the if block
}
```

When declared at the top level, var creates a property on the global object. This can lead to unintended global namespace pollution.

var in loops creates a single variable that persists after the loop
This causes issues with closures in loops

```js
for (var i = 0; i < 3; i++) {
  setTimeout(function() {
    console.log(i); // Logs 3, 3, 3
  }, 100);
}
```

#### 2. The Problem with Hoisting

var declarations are hoisted to the top of their scope and initialized with undefined.

This can lead to confusing behavior where variables appear to exist before they're declared.

```js
function hoistingExample() {
  console.log(x); // undefined (not an error!)
  var x = 5;
  console.log(x); // 5
}

// The above is interpreted as:
function hoistingExample() {
  var x; // Hoisted declaration
  console.log(x); // undefined
  x = 5;
  console.log(x); // 5
}

// Compare with let:
function letExample() {
  console.log(y); // ReferenceError: Cannot access 'y' before initialization
  let y = 5;
}
```

## Data Types

*What are the different data types in JavaScript?*

*How do you check the type of a variable?*

*How does JavaScript handle type coercion? Can you give an example of implicit type conversion?*

### 1. Seven Primitive types

```String``` - It represents a series of characters and is written with quotes. A string can be represented using a single or a 

```Number``` - Number.MAX/MIN_SAFE_INTEGER) produces +/-9007199254740991 (2^53 - 1, thats 16 digits btw)

```BigInt``` - whole numbers larger than 2^53 - 1

```Boolean```

```Undefined``` - var declared but not assigned, it has the value/type is also undefined.

```Null``` - non-existent or a invalid value.

```Symbol``` - (ES6) used to store an anonymous and unique value.

### Example

```js
var symbol1 = Symbol('symbol');
typeof of primitive types :
typeof "John Doe" // Returns "string"
typeof 3.14 // Returns "number"
typeof true // Returns "boolean"
typeof 234567890123456789012345678901234567890n // Returns bigint
typeof undefined // Returns "undefined"
typeof null // Returns "object" (kind of a bug in JavaScript)
typeof Symbol('symbol') // Returns Symbol
```

### BigInt``` - whole numbers larger than 2^53 - 1

A BigInt is created in two ways:

1. By appending 'n' to the end of an integer literal
2. By calling the BigInt() function

```javascript
// Using 'n' suffix
const bigNumber = 9007199254740991n;

// Using BigInt() function
const alsoBig = BigInt(9007199254740991);

// Example showing regular Number limit
const maxSafeInteger = Number.MAX_SAFE_INTEGER;  // 9007199254740991
console.log(maxSafeInteger + 1 === maxSafeInteger + 2);  // true (incorrect!)

// Same calculation with BigInt
const bigInteger = BigInt(maxSafeInteger);
console.log(bigInteger + 1n === bigInteger + 2n);  // false (correct!)

// Common use cases:
// 1. Working with very large integers
const largeNumber = 1234567890123456789012345678901234567890n;

// 2. Precise integer calculations beyond Number.MAX_SAFE_INTEGER
const preciseLarge = BigInt(Number.MAX_SAFE_INTEGER) + 1n;  // Works correctly

// Note: Cannot mix BigInt with regular numbers
// This will throw an error:
// console.log(1n + 1);  // TypeError
// Correct way:
console.log(1n + BigInt(1));  // 2n
```

Key points:

1. 'n' suffix creates a BigInt literal
2. BigInt() function converts numbers to BigInt
3. Cannot mix BigInt with regular numbers in operations
4. Use when working with integers larger than 2^53 - 1

#### Interview Question: Primitive vs Non-Primitive Types

"What will be logged in each console.log and why?"

```javascript
let a = "hello";
let b = a;
a = "world";
console.log(b);

let obj1 = { name: "John" };
let obj2 = obj1;
obj1.name = "Jane";
console.log(obj2.name);
```

**Answer:**

1. For primitive types (first example):
   - When `b = a` is executed, the value is copied
   - Changes to `a` don't affect `b` because primitives are passed by value
   - Therefore `b` remains "hello"

2. For non-primitive types (second example):
   - When `obj2 = obj1` is executed, the reference is copied
   - Both variables point to the same object in memory because Non-primitive types are mutable and passed by reference
   - Therefore `obj2.name` shows "Jane"

This demonstrates a key difference:

- Primitive types are immutable and passed by value
- Non-primitive types are mutable and passed by reference

### Floating point

Double-precision 54-bit format.

#### Precision

```js
0.1 + 0.2 !== 0.3  // true
console.log(0.1 + 0.2)  // 0.30000000000000004
```

#### Interview Question: Floating Point Precision

"Why does 0.1 + 0.2 not equal 0.3 in JavaScript? How would you handle this in real-world applications?"

**Answer:**

This is not a JavaScript bug, but rather how floating-point math works in computers:

- Numbers in JavaScript use the IEEE 754 double-precision format
- Binary can't exactly represent some decimal fractions, just like 1/3 can't be exactly represented in decimal
- 0.1 and 0.2 in binary are actually infinite repeating fractions

Best Practice: Never use floating-point numbers for financial calculations. Instead:

- Use a library like Decimal.js for precise calculations
- Work with integers (cents instead of dollars)
- Round to a fixed number of decimal places when displaying

#### Range

Smallest: ±5e-324 (Number.MIN_VALUE)
Largest: ±1.8e+308 (Number.MAX_VALUE)

```js
console.log(Number.MIN_VALUE);  // 5e-324
console.log(Number.MAX_VALUE);  // 1.7976931348623157e+308
```

#### Safe Integers

```js
Number.MAX_SAFE_INTEGER  // 2^53 - 1
Number.MIN_SAFE_INTEGER  // -(2^53 - 1)
```

#### Common Gotchas

##### 1. **Rounding Errors**

```javascript
(0.1 + 0.2 === 0.3)  // false

// Solutions:

// 1. Use toFixed()
(0.1 + 0.2).toFixed(1) === "0.3"  // true

// 2. Use small epsilon value
Math.abs((0.1 + 0.2) - 0.3) < Number.EPSILON  // true

// 3. Multiply by power of 10 to work with integers
(0.1 * 10 + 0.2 * 10) / 10 === 0.3  // true
```

##### 2. **Integer Precision**

```js
// Safe
console.log(999999999999999);  // 999999999999999

// Unsafe - loses precision
console.log(9999999999999999);  // 10000000000000000
```

#### 3. **Decimal Places**

```js

3. **Decimal Places**
```javascript
// Can be unexpected
console.log(0.1 + 0.2);  // 0.30000000000000004
console.log(0.3 - 0.1);  // 0.19999999999999998
```

#### Best practices

##### 1. **For Financial Calculations**

```javascript
// Don't use floating point
const price = 10.99;
const quantity = 3;
// Bad
const total = price * quantity;  // 32.97000000000001

// Better: Use cents/smallest unit
const priceInCents = 1099;
const betterTotal = (priceInCents * quantity) / 100;  // 32.97
```

##### 2. **For Comparison**

```javascript
// Don't compare floats directly

// Bad
if (0.1 + 0.2 === 0.3) { /* ... */ }

// Better
function areFloatsEqual(a, b) {
    return Math.abs(a - b) < Number.EPSILON;
}
```

#### For Large Numbers

##### 3. **For Large Numbers**

```javascript
// Use BigInt for large integers
const largeNumber = 9007199254740991n;
```

### 2. Non-primitive types

1. Object
2. Array
3. Function
4. Date
5. RegExp
6. Map
7. Set
8. WeakMap
9. WeakSet
10. Typed Arrays
11. Promise
12. Error

### Object

An Object is used to store a collection of data.

#### Interview Question: Object References

"What will be logged and why?"

```javascript
const person = { name: 'John' };
const people = [person];
person.name = 'Jane';
console.log(people[0].name); // "Jane"

const newPerson = { ...person };
person.name = 'Bob';
console.log(newPerson.name); // "Jane"
```

**Answer:**

1. First example shows reference behavior:

   - The array contains a reference to the same object
   - Modifying the original object affects what we see through the array
   - Therefore `people[0].name` shows "Jane"

2. Second example shows shallow copying:
   - Spread operator creates a new object with copied values
   - Changes to original no longer affect the copy
   - Therefore `newPerson.name` remains "Jane"

Key concept: Objects are passed by reference, but spread operator creates a shallow copy

#### Interview Question: Arrays

"What's the output and why?"

```javascript
const arr1 = [1, 2, [3, 4]];
const arr2 = [...arr1];
arr1[2][0] = 'x';
console.log(arr2[2][0]); // "x"
```

**Answer:**

- Spread operator performs shallow copy
- Nested arrays are still referenced, not copied
- Modifying nested array in original affects the copy
- For deep copying, use `JSON.parse(JSON.stringify())` or structured clone

## Function Basics

*What's the difference between a function declaration and a function expression?*

```Function declarations``` are hoisted completely (both declaration and definition) to the top of their scope, meaning they can be called before they are defined in the code.

```js
// Function Declaration - works due to hoisting
sayHello("John"); // "Hello, John"

function sayHello(name) {
    return "Hello, " + name;
}
```

```Function expressions``` are not hoisted. They must be defined before they can be used, and they are treated like any other variable assignment.

```js
// Function Expression - throws ReferenceError
greet("John"); // ReferenceError: Cannot access 'greet' before initialization

const greet = function(name) {
    return "Hello, " + name;
};
```

*Can you explain arrow functions and how they differ from regular functions, especially in terms of this context?*

### Regular Function

- The value of ```this``` depends on how the function is called.
- Has its own arguments object.
- Can be used as a constructor with the new keyword.

### Arrow Function

- The value of this is lexically bound, meaning it uses this from the surrounding code where the arrow function is defined.
- does not have its own this, arguments, super, or new.target bindings.
- inherits this from the enclosing scope at the time they are defined. This makes them particularly useful for maintaining the correct this context in callbacks and event handlers.
- Does not have its own arguments object. You can use rest parameters (...args) instead.
- Cannot be used as a constructor and will throw an error if used with new.

#### Example 1: Event Handler Context

```js
// Problem with regular function
const button = {
    text: 'Click me',
    handlers: [],
    addHandler: function() {
        this.handlers.push(function() {
            console.log(this.text); // undefined - 'this' refers to window/global
        });
    }
};

// Solution with arrow function
const buttonFixed = {
    text: 'Click me',
    handlers: [],
    addHandler: function() {
        this.handlers.push(() => {
            console.log(this.text); // 'Click me' - 'this' is inherited from parent scope
        });
    }
};
```

#### Example 2: Constructor and Methods

```js
// Regular function can be constructor
function Car(make) {
    this.make = make;
    this.speed = 0;
    
    // Regular function loses 'this' context after 1 second
    this.startRegular = function() {
        setTimeout(function() {
            this.speed = 60; // 'this' is undefined
            console.log(this.make + ' is going ' + this.speed); // Error
        }, 1000);
    };
    
    // Arrow function maintains correct 'this' context
    this.startArrow = function() {
        setTimeout(() => {
            this.speed = 60; // 'this' refers to Car instance
            console.log(this.make + ' is going ' + this.speed); // Works correctly
        }, 1000);
    };
}

const myCar = new Car('Toyota');
myCar.startArrow(); // "Toyota is going 60"
myCar.startRegular(); // TypeError: Cannot read property 'make' of undefined
```

## Closures

*Can you explain what a closure is in JavaScript? How have you used closures in your code?*

*What are some common use cases for closures?*

A Closure is a function that remembers the environment in which it was created. This means that a closure has access to variables from its own scope, the scope of the outer function, and the global scope. Closures are created whenever a function is created, at function creation time.

Here's a simple example of a closure:

```JavaScript
function outerFunction(outerVariable) {
    return function innerFunction(innerVariable) {
        console.log('Outer Variable: ' + outerVariable);
        console.log('Inner Variable: ' + innerVariable);
    }
}

const newFunction = outerFunction('outside');
newFunction('inside');
```

In this example, innerFunction is a closure that has access to the outerVariable even after outerFunction has finished executing.

```Encapsulation```: To create private variables and functions that cannot be accessed from outside the function.

```Callbacks```: To maintain state in asynchronous operations.

```Currying```: To create functions with preset arguments.

### Common use cases for closures

```Data Privacy```: Encapsulating data to create private variables.

```Event Handlers```: Maintaining state in event listeners.

```Functional Programming```: Implementing higher-order functions and currying.

See the [counter dilemma](../examples/javascript/closures.js)

### Currying

Currying is a functional programming technique.
In it a function with multiple arguments is transformed into a sequence of unary functions.
Unary functions take single arguments.

```js
function curry(fn) {
  return function curried(...args) {
    if (args.length >= fn.length) {
      return fn.apply(this, args);
    } else {
      return function (...args2) {
        return curried.apply(this, args.concat(args2));
      };
    }
  };
}
```

The ```curry(fn)``` returns a new function called ```curried```.

When ```curried``` is called with some arguments:

- If there are enough arguments, it executes the original function
- If there aren't enough arguments, it returns a new function

The recursive part: When this new function is called, it calls ```curried``` again with the combined arguments.

The ```apply``` line calls the original function ```fn```.
This Preserves the current ```this``` context, passes all collected arguments ```(args)``` to the function.

This is necessary because the arguments were collected using the rest parameter ```(...args)```, which creates an array. To call the original function with these arguments, you need to "spread" them back out as individual arguments, which is exactly what ```apply``` does.

It use used like this:

```js
function add(a, b, c) {
  return a + b + c;
}

// Curried custom version above
const curriedAdd = curry(add);
// using Lodash
const curriedAdd = _.curry(add);

// Different ways to call the curried function
console.log(curriedAdd(1, 2, 3));     // 6 - All at once
console.log(curriedAdd(1)(2)(3));     // 6 - One argument at a time
console.log(curriedAdd(1, 2)(3));     // 6 - Mixed approach
```

The curry function takes a function as its argument and returns a curried version of that function.

Then you can use the curried function in various ways.

### Currying in TypeScript

Here is a version of the first curry function in TypeScript:

```js
function curry<Args extends any[], Return>(
  fn: (...args: Args) => Return
): CurriedFunction<Args, Return> {
  return function curried(...args: any[]): any {
    if (args.length >= fn.length) {
      return fn.apply(this, args);
    } else {
      return function(...args2: any[]) {
        return curried.apply(this, args.concat(args2));
      };
    }
  } as any;
}

// Helper types for the curried function
type CurriedFunction<Args extends any[], Return> = 
  Args extends [infer First, ...infer Rest]
    ? (arg: First) => CurriedFunction<Rest, Return>
    : Return;
```

#### Real-World Scenarios

1. Configuration and Setup API requests with different base URLs and headers.

```js
const makeApiRequest = curry(function(baseURL, headers, endpoint, data) {
  return fetch(`${baseURL}${endpoint}`, {
    method: 'POST',
    headers: headers,
    body: JSON.stringify(data)
  }).then(response => response.json());
});

// Create specialized API requesters for different environments
const devApiRequest = makeApiRequest('https://dev-api.example.com', { 
  'Content-Type': 'application/json',
  'X-Environment': 'development'
});

const prodApiRequest = makeApiRequest('https://api.example.com', { 
  'Content-Type': 'application/json',
  'X-Environment': 'production'
});

// Use the specialized functions
devApiRequest('/users', { name: 'John' })
  .then(response => console.log(response));

prodApiRequest('/users', { name: 'John' })
  .then(response => console.log(response));
```

### Module Pattern

Creating modules that expose public methods while keeping private variables and methods hidden.

Closures can help you write more modular and maintainable code.

## call and apply

The ```apply()``` method is similar to the ```call()``` method, with the only difference being that the ```apply()``` method takes arguments as an array (or array-like object), while arguments get passed individually to the ```call()``` method.

## Objects

*How do you create an object in JavaScript? What are some ways to add or modify properties of an object?*

### Modern JavaScript and destructuring

*Can you explain how object destructuring works? Provide an example.*

```js
// Destructuring the object
const { name, age, job } = person;
// Destructuring with renaming
const { name: personName, age: personAge, job: personJob } = person;
// Destructuring with default values
const { name, age, job = 'Employed' } = person;
 // Nested destructuring
const { name, address: { city, country } } = person;
```

Destructuring, the spread and rest operators along with the fat arrow and other great new features were introduced in ES6 (ES2015).

See my discussion about [modern JavaScript and destructuring, the spread and rest operators here](../examples/javascript/snippets/modern.js).

## Arrays

*How do you manipulate arrays in JavaScript? What are some common array methods you use frequently (e.g., map, filter, reduce)?*

*How would you remove duplicates from an array?*

A Set is a collection of unique values. You can convert an array to a Set and then back to an array to remove duplicates:

```js
const array = [1, 2, 2, 3, 4, 4, 5];
const uniqueArray = [...new Set(array)];
```

## Promises and Async/Await

*Can you explain how promises work in JavaScript? What are the states of a promise?*

*How does async/await improve working with promises? Can you provide an example of how you'd use async/await?*

Async/await is a syntactic sugar built on top of promises, making asynchronous code easier to read and write. Here's how it improves working with promises:

### Benefits of Async/Await

```Readability```: Async/await allows you to write asynchronous code that looks synchronous, making it easier to understand and maintain.
Error Handling: You can use try/catch blocks to handle errors, similar to synchronous code.
Chaining: Avoids the need for chaining .then() and .catch() methods, reducing callback hell.

#### When to Use

- Use async/await when you want cleaner, more readable code, especially for complex asynchronous operations.
- Use promises directly if you need more control over the promise chain or when working with multiple promises concurrently (e.g., Promise.all).

### Callback Functions

What is a callback function in JavaScript? How do you avoid callback hell?
Use async/await try/catch to avoid chaining then/catch blocks

To avoid callback hell, you can use several techniques:

Named Functions: Break down nested callbacks into named functions.
Promises: Use promises to handle asynchronous operations more cleanly.
Async/Await: Use async/await for even more readable asynchronous code.

### Fetch examples

Create a fetch statement for use in a React component to fetch this data: https://jsonplaceholder.typicode.com/todos

#### Using async/await with useEffect (Recommended)

```js
import { useState, useEffect } from 'react';

function MyComponent() {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchTodos = async () => {
      try {
        const response = await fetch('https://jsonplaceholder.typicode.com/todos');
        if (!response.ok) throw new Error('Network response was not ok');
        const data = await response.json();
        setTodos(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchTodos();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <ul>
      {todos.map(todo => (
        <li key={todo.id}>{todo.title}</li>
      ))}
    </ul>
  );
}
```

#### Using a Promise

There is also a promised based approach:

```js
  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/todos')
      .then(response => response.json())
      .then(data => setTodos(data))
      .catch(error => console.error('Error:', error));
  }, []);
```

Another version from [SOVANNARO](https://dev.to/sovannaro/20-advanced-javascript-tricks-for-experienced-developers-44f8):

```js
async function fetchData() {
  try {
    const response = await fetch('https://api.example.com/data');
    const data = await response.json();
  } catch (error) {
    console.error('Error fetching data:', error);
  }
}
```

#### With debounce

This example includes [query, pathname, currentUser, filter] in its dependency array.
The specific query is tied to a search input.
The timeout (debouncing) is used to prevent making an API call on every single keystroke as the user types their search query.

```js
function EventsPage({ message, filter = "" }) {
  const [events, setEvents] = useState({ results: [] });
  const [hasLoaded, setHasLoaded] = useState(false);
  const { pathname } = useLocation();
  const [query, setQuery] = useState("");
  const currentUser = useCurrentUser();
  useEffect(() => {
    let isMounted = true; // Flag to track mounted state
    const fetchEvents = async () => {
      try {
        const { data } = await axiosReq.get(`/events/?${filter}search=${query}`);
        if (isMounted) {
          setEvents({
            results: Array.isArray(data.results) ? data.results : [],
            next: data.next,
          });
          setHasLoaded(true);
        }
      } catch (err) {
        console.error(err); // Handle error
      }
    };
    setHasLoaded(false);
    const timer = setTimeout(() => {
      fetchEvents();
    }, 1000);
    // Cleanup function to set isMounted to false when component unmounts
    return () => {
      clearTimeout(timer);
      isMounted = false;
    };
  }, [query, pathname, currentUser, filter]);
...
```

## Higher-order functions

Question: *Can you explain the concept of a higher-order function and provide an example?*

Answer: A HoF Takes one or more functions as arguments, or Returns a function as its result.

Higher-order functions are a key feature in functional programming.

```Array.prototype.map method``` is a higher-order function.

```js
const numbers = [1, 2, 3, 4, 5];
numbers.map(function(num) {
    return num * 2;
});
```

Another example from [SOVANNARO](https://dev.to/sovannaro/20-advanced-javascript-tricks-for-experienced-developers-44f8):

```js
function higherOrder(fn) {
  return function (...args) {
    console.log('Before function call');
    const result = fn(...args);
    console.log('After function call');
    return result;
  };
}
```

### Functional programming paradigm

My [functional fun](https://plnkr.co/edit/8UHAOd?p=preview&preview) Plunker from 2016 explored the functional programming paradigm before array methods were introduced to JavaScript.  In those days, we attached functions to object prototypes to provide this functionality.  Functions as arguments were called projections.

```js
Array.prototype.map = function(projection) {
    var results = [];
    this.forEach(
      function(item) {
        results.push(projection(item));
    });
    return results;
;
```

The usage then looked like this:

```js
var flatten = movieLists.map(function(list) {
  return list.videos.map(function(video) {
    return video.title;
  });
}).
concatAll();
```

## Array prototype functions

```Map``` - accepts the projection function to be applied to each item in the source array, and returns the projected array.

```Filter``` - we apply a test to each item in the array and collect the items that pass into a new array.

```ConcatAll``` - Trees pose a challenge because we need to flatten them into arrays in order to apply filter() and map() operations on them. In this section we'll define a concatAll() function that we can combine with map() and filter() to query trees.

```Reduce``` - Sometimes we need to perform an operation on more than one item in the array at the same time. For example, let's say we need to find the largest integer in an array. We can't use a filter() operation, because it only examines one item at a time. To find the largest integer we need to compare items in the array to each other.

```Zipping``` - Sometimes we need to combine two arrays by progressively taking an item from each and combining the pair. If you visualize a zipper, where each side is an array, and each tooth is an item, you'll have a good idea of how the zip operation works.

As a learning exercise I tried to name the variables to make the functional paradigm concepts more clear:

```js
data_to = ['a', 'b', 'c'];
using_operation_x = (x) => {return 'Plan '+x;}
a_projector = data_to.map(using_operation_x);
```

Or this:

```js
data_to = [1,2,3,4,5];
using_operation_grater_than_2 = (x) => { return x > 2};
a_filter = data_to.filter(using_operation_grater_than_2);
```

I the React world they are known by different names:

1. Projections (using_operation_x) are now commonly called transform functions, mappers, or selectors.
2. Projectors (a_projector) are now referred to as derived state, transformed data, or selected state.
3. Higher-order functions have expanded into patterns like HOCs, custom hooks, and selector functions (in Redux).

Here would be some modern React examples.

```js
function UserDashboard({ users }) {
  // Transform function (projection)
  const formatUser = useCallback((user) => ({
    ...user,
    fullName: `${user.firstName} ${user.lastName}`,
    isAdmin: user.roles.includes('admin')
  }), []);
  
  // Memoized transformed data (projector)
  const formattedUsers = useMemo(() => 
    users.map(formatUser), 
    [users, formatUser]
  );
  
  return (
    <div>
      <UserList users={formattedUsers} />
    </div>
  );
}
```

## Higher-Order Components

HOCs are the React component equivalent of your functional programming approach

```js
// Higher-order component (similar to your map implementation)
function withUserFormatting(WrappedComponent) {
  return function WithFormattedUsers(props) {
    const { users, ...otherProps } = props;
    
    // This is your "projection" applied to each user
    const formattedUsers = users.map(user => ({
      ...user,
      fullName: `${user.firstName} ${user.lastName}`
    }));
    
    // Return component with transformed data
    return <WrappedComponent users={formattedUsers} {...otherProps} />;
  };
}

// Usage
const EnhancedUserList = withUserFormatting(UserList);
```

Custom hooks are another way React implements higher-order functions.

```js
// Custom hook implementing your projection pattern
function useFormattedUsers(users) {
  // Transform function (your "using_operation_x")
  const formatUser = useCallback((user) => ({
    ...user,
    fullName: `${user.firstName} ${user.lastName}`
  }), []);
  
  // Memoized result (your "a_projector")
  const formattedUsers = useMemo(() => 
    users.map(formatUser),
    [users, formatUser]
  );
  
  return formattedUsers;
}

// Usage in component
function UserList({ users }) {
  const formattedUsers = useFormattedUsers(users);
  
  return (
    <ul>
      {formattedUsers.map(user => (
        <li key={user.id}>{user.fullName}</li>
      ))}
    </ul>
  );
}
```

### Higher-Order Functions in React vs RxJS in Angular

I learned more about early functional programming via RxJS in Angular observables.  Here is a comparison of the two.

React:

- Embraces functional components and hooks
- Higher-order components (HOCs) wrap components to add functionality
- Functions like map, filter, and reduce for data transformation

Angular (RxJS):

- Uses functional programming concepts through Observable streams
- Operators like map, filter, and reduce transform data streams
- Composition of operators creates data processing pipelines

## Event Handling

*How does event handling work in JavaScript?*

Answer:
JavaScript uses an event-driven programming model where functions (event handlers) are executed in response to events. Events can be triggered by user actions or programmatically.

```js
// Adding event listeners
document.getElementById('myButton').addEventListener('click', function(event) {
  console.log('Button clicked!');
  console.log('Event object:', event);
});

// Alternative inline approach
function handleClick() {
  alert('Button clicked!');
}
```

*What's the difference between event capturing and bubbling?*

Event propagation in the DOM happens in three phases:
Capturing phase: Events travel from the window down to the target element
Target phase: Event reaches the target element
Bubbling phase: Events bubble up from the target back to the window

```js
// Bubbling (default, third parameter is false or omitted)
element.addEventListener('click', function() {
  console.log('Bubbling phase handler');
}, false);

// Capturing (third parameter is true)
element.addEventListener('click', function() {
  console.log('Capturing phase handler');
}, true);
```

Bubbling is more commonly used, but capturing can be useful for intercepting events before they reach their targets.

*How do you prevent default behavior and stop event propagation?*

To control event behavior, preventDefault() stops the browser's default action for the event, while stopPropagation() prevents the event from continuing its path through the DOM.

```js
document.querySelector('a').addEventListener('click', function(event) {
  // Prevent default behavior (e.g., following a link)
  event.preventDefault();
  // Stop event propagation (bubbling)
  event.stopPropagation();
  // Stop immediate propagation (prevents other handlers on same element)
  event.stopImmediatePropagation();
  console.log('Link click intercepted');
});
```

In React, these are not used as much as they are in vanilla JavaScript.  Instead, React has its own event system.  The React event system is more consistent and easier to use.  It also handles event delegation and batching of events. React event handlers are prefixed with ```on``` and are camelCase.  The event object is passed as an argument to the handler function.  And example of a React event handler is below.

```js
function handleClick(event) {
  console.log('Button clicked!');
  console.log('Event object:', event);
}
...
<button onClick={handleClick}>Click me</button>
```

## Classes

*How do classes work in JavaScript?*

Classes provide a syntax for creating constructor functions and prototypes. They were introduced in ES6 as syntactic sugar over JavaScript's prototype-based inheritance.

*How do they relate to prototypes?*

Classes are built on top of JavaScript's prototype system. When you define methods in a class, they are added to the prototype of the constructor function.

*Can you explain how to use extends and super in JavaScript classes?*

*extends* creates a subclass that inherits from a parent class, while *super* calls the parent class's constructor or methods.

## ES6

### Modern JavaScript Features

*What are some of the key features introduced in ES6?*

1. let and const
2. Arrow functions
3. Promises
4. Modules
5. Destructuring
6. Spread operator
7. Template literals
8. Classes
9. Default parameters
10. Map and Set

```js
// Destructuring
const { firstName, lastName } = person;
const [first, ...rest] = array;
// Spread operator
const newArray = [...oldArray, newItem];
const newObject = { ...oldObject, newProp: value };

// Default parameters
function greet(name = 'Guest') {
  return `Hello, ${name}!`;
}

// Promises
const promise = new Promise((resolve, reject) => {
  const random = await axios.get('https://api.example.com/data');
  if (random > 0.5) {
    resolve('Success');
  } else {
    reject('Failure');
  }
});
```

*How do they improve JavaScript coding practices?*

- Better readability: Arrow functions and template literals make code more concise and readable
- Improved scoping: Block-scoped variables with let and const prevent common bugs
- Enhanced organization: Modules provide better code organization and encapsulation
- Cleaner asynchronous code: Promises (and later async/await) simplify asynchronous programming
- More expressive syntax: Destructuring and spread operators reduce boilerplate code

```js
// Before ES6
var self = this;
function getData(callback) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var data = JSON.parse(xhr.responseText);
      callback(null, data);
    } else if (xhr.readyState === 4) {
      callback(new Error('Request failed'));
    }
  };
  xhr.open('GET', 'https://api.example.com/data', true);
  xhr.send();
}

// After ES6
const getData = () => {
  return fetch('https://api.example.com/data')
    .then(response => {
      if (!response.ok) throw new Error('Request failed');
      return response.json();
    });
};
```

*Can you explain the difference between let, const, and var introduced in ES6?*

### Module systems

*How do you work with modules in JavaScript?*

With the export, default and import keywords.

```js
// Import default export
import multiply from './math.js';
// Import named exports
import { PI, add } from './math.js';
// Import all exports as a namespace
import * as math from './math.js';
// Rename imports
import { add as sum } from './math.js';
// Dynamic import (returns a Promise)
const mathModule = import('./math.js').then(math => {
  console.log(math.add(2, 3));
});
```

*What's the difference between import/export and older module systems like CommonJS?*

#### Modules

- can export its own variables, functions, or classes, and other modules can import and use them.

Use ```import/export``` (ES6 Modules)

#### CommonJS

```js
require/module.exports = { add, etc };
```

## React Questions

*Can you explain the difference between functional and class components in React? When would you use one over the other?*

Functional components do not have their own state or lifecycle methods (prior to React 16.8).

Class components can manage their own state and have access to lifecycle methods.

with hooks, many developers prefer functional components for their simplicity and readability.

*How does React's virtual DOM work? Why is it beneficial for performance?*

- This virtual DOM is a lightweight copy of the real DOM.
- minimizes the number of manipulations, leading to faster updates.
- batches multiple updates
- By efficiently determining the minimal set of changes required to update the real DOM it reduces the time and resources needed for rendering.
- maintain a smooth and responsive user interface

### The process

- When the state of a component changes, the virtual DOM updates instead of the real DOM. This process is much faster because it is just a JavaScript object.
- "diffing" compares the new virtual DOM with the previous version and identifies the changes
- "reconciliation" updates only the parts of the real DOM that have changed

*Can you discuss the use of hooks in React? How have you used them in your projects?*

*How do you manage state in a React application? Can you give an example of how you've used Redux in a project?*

*How do you handle global state versus component-specific state?*

*How have you implemented routing in React using React Router? Can you walk us through a complex routing scenario you've handled?*

### Dynamic Imports in React

*What are the different types of dynamic imports in React?*

Dynamic imports in React allow you to load JavaScript modules on-demand rather than loading everything upfront. This technique, also known as code splitting, improves initial load performance by reducing bundle size.

Dynamic imports are a powerful tool for optimizing React applications, allowing you to load only what's needed when it's needed, resulting in faster initial load times and better user experience.  Usage includes:

1. Lazy & Suspense
2. Route-Based Code Splitting
3. Conditional Loading
4. Named Exports
5. Error Handling
6. Prefetching
7. Webpack Magic Comments

Basic Syntax

```js
import('./SomeComponent').then(module => {
  const Component = module.default;
  // Use Component
});
```

#### With React.lazy and Suspense

The most common way to use dynamic imports in React is with React.lazy and Suspense:

```js
import React, { Suspense, lazy } from 'react';

// Dynamic import wrapped in React.lazy
const LazyComponent = lazy(() => import('./LazyComponent'));

function App() {
  return (
    <div>
      <Suspense fallback={<div>Loading...</div>}>
        <LazyComponent />
      </Suspense>
    </div>
  );
}
```

#### Route-Based Code Splitting

A common pattern is to split code by routes:

```js
import React, { Suspense, lazy } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

const Home = lazy(() => import('./routes/Home'));
const About = lazy(() => import('./routes/About'));
const Dashboard = lazy(() => import('./routes/Dashboard'));

function App() {
  return (
    <Router>
      <Suspense fallback={<div>Loading...</div>}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </Suspense>
    </Router>
  );
}
```

#### Conditional Loading

You can load components conditionally based on user interaction:

```js
function ProfilePage({ isAdmin }) {
  const [showAdminPanel, setShowAdminPanel] = useState(false);
  const [AdminPanel, setAdminPanel] = useState(null);

  const loadAdminPanel = async () => {
    if (isAdmin) {
      const module = await import('./AdminPanel');
      setAdminPanel(() => module.default);
      setShowAdminPanel(true);
    }
  };

  return (
    <div>
      <h1>User Profile</h1>
      {isAdmin && !showAdminPanel && (
        <button onClick={loadAdminPanel}>Load Admin Panel</button>
      )}
      {showAdminPanel && AdminPanel && <AdminPanel />}
    </div>
  );
}
```

#### Named Exports

You can also import specific named exports:

```js\const loadUtils = async () => {
  const { formatDate, calculateTotal } = await import('./utils');
  
  // Use the imported functions
  console.log(formatDate(new Date()));
  console.log(calculateTotal([10, 20, 30]));
};
```

#### Error Handling

Handle loading failures with error boundaries:

```js
import { ErrorBoundary } from 'react-error-boundary';

function MyFallbackComponent({ error, resetErrorBoundary }) {
  return (
    <div>
      <h2>Something went wrong!</h2>
      <p>{error.message}</p>
      <button onClick={resetErrorBoundary}>Try again</button>
    </div>
  );
}

function App() {
  return (
    <ErrorBoundary FallbackComponent={MyFallbackComponent}>
      <Suspense fallback={<div>Loading...</div>}>
        <LazyComponent />
      </Suspense>
    </ErrorBoundary>
  );
}
```

#### Prefetching

You can prefetch components before they're needed:

```js
function ProductList({ products }) {
  // Prefetch the product detail component when hovering over the list
  const prefetchProductDetail = () => {
    import('./ProductDetail');
  };

  return (
    <div onMouseEnter={prefetchProductDetail}>
      {products.map(product => (
        <ProductItem key={product.id} product={product} />
      ))}
    </div>
  );
}
```

#### Webpack Magic Comments

You can use webpack magic comments to customize chunk naming and loading behavior:

```js
// Name your chunk
const Settings = lazy(() => import(/* webpackChunkName: "settings" */ './Settings'));

// Mark a chunk as prefetchable
const Help = lazy(() => 
  import(/* webpackPrefetch: true */ './Help')
);

// Mark a chunk as preloadable
const UserProfile = lazy(() => 
  import(/* webpackPreload: true */ './UserProfile')
);
```

*How do you manage dynamic routes or nested routing in React?*

*What techniques do you use to optimize the performance of a React application?*

- ```Code Splitting```: Use dynamic import() to split your code into smaller bundles, which can be loaded on demand.
- ```Lazy Loading```: Load components only when they are needed using React.lazy and Suspense. (I used react-infinite-scroll-component to replace traditional pagination with lazy loading instead of pagination to make the application more performant and seem more snappy/engaging

```Memoization```: ( caching result of expensive fn calls & reusing when same inputs occur again)
Use React.memo to prevent unnecessary re-renders of functional components and useMemo or useCallback hooks for memoizing values and functions.

```useMemo``` only runs when one of its dependencies update.  improves performance. used for values such as objects or arrays. Primitives that require a minimal computation don't need to be memoized since they are easily comparable,

```useCallback``` is used for functions [Optimize Performance with useMemo and useCallback](https://dev.to/vyan/top-10-reactjs-tips-and-tricks-everyone-should-know-2m18)

- ```Virtualization```: Use libraries like react-window or react-virtualized to *efficiently render large lists by only rendering visible items.
- ```Avoid Inline Functions```: Define functions outside of the render method to avoid creating new instances on every render.
- ```Use Production Build```: Ensure you are using the production build of React, which is optimized for performance.
- ```Optimize Images```: Compress and resize images to reduce load times.
- ```Use a CDN```: Serve static assets from a Content Delivery Network (CDN) to reduce latency.
- ```Minimize Re-renders```: Use shouldComponentUpdate or React.PureComponent to control when components should re-render.
- ```Optimize State Management```: Use local state where possible and avoid unnecessary global state updates.

### Memoization

Here are some examples of Memoization in use.

These three hooks have slightly different uses which is good to be clear on.

- *useEffect* is for side effects and runs after renders.
- *useMemo* memoizes values to optimize expensive calculations.
- *useCallback* memoizes functions to prevent unnecessary re-renders.
- *useLayoutEffect* runs before the browser updates the screen

### useEffect

The useEffect hook invokes side effects from within functional components.

It runs after every render (by default), and can optionally clean up for itself before it runs again.

This hook takes the place of class lifecycle functions like componentDidMount.

Used to to synchronize with external systems, often in the form of API calls.

Overuse of this effect is a bit of a problem amongst developers.  I wrote an article title [You don't need effects to transform data](https://timothycurchod.com/writings/you-dont-need-effects) which goes into this effect which covers when NOT to use it.  This article also covers custom hooks which are a great pattern for refactoring code.

The useLayoutEffect hook is not considered memoization, but worth a mention here.  It runs *before* the browser updates the screen and avoids flashing of old data.

## useMemo

This hook memoizes the result of a function.

It only recomputes the memoized value when one of the dependencies has changed.

This is useful for optimizing expensive calculations.

```js
import { useMemo } from 'react';

const MyComponent = ({ items }) => {
  const expensiveCalculation = (items) => {
    // Perform some expensive calculation
    return items.reduce((acc, item) => acc + item.value, 0);
  };

  const totalValue = useMemo(() => expensiveCalculation(items), [items]);

  return <div>Total Value: {totalValue}</div>;
};
```

### memo

A React.PureComponent is a way to control when components should re-render.  A functional component alternative uses React.memo to wrap the component.

```js
import React, { useState, memo } from 'react';

const UserProfile = memo(function UserProfile({ name, email, avatar }) {
  return (
    <div className="user-profile">
      ...
    </div>
  );
});
```

*Have you used testing frameworks like Jest or Mocha? How do you approach writing tests for React components?*

## TypeScript

### Union Types

Union types are used when a value can be more than a single type.

Union type: ```type animal = cat | dog;```

Intersection type: ```type intersectionAnimal = cat & dog;```

## CSS

### Units

```em``` Relative to the font-size of the element (2em means 2 times the size of the current font)

```ch``` Relative to the width of the "0" (zero)

```rem``` Relative to font-size of the root element

```vw``` Relative to 1% of the width of the viewport

```vh``` Relative to 1% of the height of the viewport

```vmin``` Relative to 1% of viewport's smaller dimension

```vmax``` Relative to 1% of viewport's larger dimension % Relative to the parent element

### System design questions

API Gateway vs Load Balancer and Horizontal vs Vertical Scaling, Forward proxy vs reverse proxy as well as 50 system design problems in [this article](https://dev.to/somadevtoo/top-15-system-design-resources-for-programming-interviews-1m15)

## Advanced Topics

### Proxy Objects

Proxies enable you to create objects with custom behavior for fundamental operations (e.g., property lookup, assignment).

```js
const handler = {
  get: (obj, prop) => {
    if (prop in obj) {
      return obj[prop];
    } else {
      return 'Property not found';
    }
  }
};

const proxy = new Proxy({ name: 'Alice' }, handler);
console.log(proxy.name); // Output: Alice
console.log(proxy.age);  // Output: Property not found
```

### Memoization without hooks

Memoization is a technique to optimize expensive function calls by caching their results.
Here is an example that does not use a React hook.

```js
function memoize(fn) {
  const cache = {};
  return function (...args) {
    const key = JSON.stringify(args);
    if (cache[key]) {
      return cache[key];
    } else {
      const result = fn(...args);
      cache[key] = result;
      return result;
    }
  };
}
```

### Web Workers

Web Workers enable you to run scripts in background threads, keeping the user interface responsive.

```js
const worker = new Worker('worker.js');
worker.postMessage('Hello, Worker!');
worker.onmessage = function (event) {
  console.log('Message from worker:', event.data);
};
```

### WebSockets

WebSockets enable you to create a two-way communication channel between the client and server.

```js
const socket = new WebSocket('ws://example.com/socket');
socket.onopen = function () {
  console.log('Connected to server');
};
```

### Service Workers

Service Workers act as network proxies, allowing you to create effective offline experiences and improve performance.

```js
if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/service-worker.js').then(function (registration) {
    console.log('Service Worker registered with scope:', registration.scope);
  });
}
```

### WebRTC

WebRTC enables real-time communication between browsers.

```js
const pc = new RTCPeerConnection();
pc.onicecandidate = function (event) {
  console.log('ICE candidate:', event.candidate);
};
```

### Intersection Observer API

The Intersection Observer API provides a way to asynchronously observe changes in the intersection of a target element with an ancestor element or the top-level document's viewport.

```js
export default function App() {
  const targetRef = useRef(null);
  useEffect(() => {
    const observer = new IntersectionObserver(entries => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          console.log('Element is in view:', entry.target);
        }
      });
    });
    // Make sure the ref is attached to an element
    if (targetRef.current) {
      observer.observe(targetRef.current);
    }
    // Clean up the observer when component unmounts
    return () => {
      if (targetRef.current) {
        observer.unobserve(targetRef.current);
      }
    };
  }, []);
  return (
    <div>
      <h1>Hello StackBlitz!</h1>
      <p id="target" ref={targetRef} style={{fontSize: "10vh"}}>:)</p>
    </div>
  );
}
```

### Custom Elements and Shadow DOM

Custom elements and the Shadow DOM allow you to create reusable components with encapsulated styles and behavior.

```js
class MyElement extends HTMLElement {
  constructor() {
    super();
    const shadow = this.attachShadow({ mode: 'open' });
    shadow.innerHTML = `<style>:host { color: blue; }</style><p>Hello, World!</p>`;
  }
}

customElements.define('my-element', MyElement);
```

An example of a best practice for using React with custom elements would look like this:

```js
// Create a wrapper component for the custom element
function CustomElementWrapper({ name = '', ...props }) {
  const elementRef = useRef(null);

  useEffect(() => {
    /* Ensure custom element is defined.  Using window here is actually
     unnecessary since customElements is already available in the global scope.
    */
    if (!window.customElements.get(name)) {
      console.warn(`Custom element "${name}" is not defined`);
      return;
    }

    // Forward props to the custom element
    const element = elementRef.current;
    Object.entries(props).forEach(([key, value]) => {
      if (typeof value === 'function') {
        // Handle event listeners
        element.addEventListener(key.toLowerCase(), value);
      } else {
        // Handle properties and attributes
        element[key] = value;
      }
    });

    // Cleanup event listeners
    return () => {
      Object.entries(props).forEach(([key, value]) => {
        if (typeof value === 'function') {
          element.removeEventListener(key.toLowerCase(), value);
        }
      });
    };
  }, [name, props]);

  return React.createElement(name, { ref: elementRef });
}

// Usage example
function App() {
  const handleCustomEvent = (event) => {
    console.log('Custom event:', event.detail);
  };

  return (
    <CustomElementWrapper 
      name="my-element"
      onCustomEvent={handleCustomEvent}
      someProperty="value"
    />
  );
}
```

customElements is a global browser API that's part of the Web Components standard and is available directly in the global scope of modern browsers.
The customElements registry is accessible as a property of the global window object, so you don't need to import it. It's similar to other browser APIs like document, localStorage, or fetch that are globally available.
