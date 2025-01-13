# Currying

Currying is a functional programming technique where a function that takes multiple arguments is transformed into a sequence of functions, each taking a single argument. The curried function returns a new function for each argument until all arguments have been provided.

## Examples

### Basic Example

```js
// Regular function
function add(x, y) {
    return x + y;
}

// Curried version
const curriedAdd = x => y => x + y;

// Usage
const add5 = curriedAdd(5);  // Returns a function waiting for y
console.log(add5(3));        // Outputs: 8
console.log(curriedAdd(5)(3)); // Same thing in one line
```

## Practical Examples

### Configuration Functions

```js
// Create reusable API request function
const makeRequest = baseURL => endpoint => params => {
    return fetch(`${baseURL}${endpoint}?${new URLSearchParams(params)}`);
};

// Create specific API instances
const makeGoogleRequest = makeRequest('https://api.google.com');
const searchGoogle = makeGoogleRequest('/search');

// Use it
searchGoogle({ q: 'JavaScript currying' });
```

### Event Handling

```js
const handleEvent = eventType => element => callback => {
    element.addEventListener(eventType, callback);
};

// Create specialized event handlers
const handleClick = handleEvent('click');
const handleButtonClick = handleClick(button);

// Use it
handleButtonClick(e => console.log('Button clicked!'));
```

### 3. Partial Application

```js
const multiply = x => y => x * y;
const multiplyBy2 = multiply(2);
const multiplyBy3 = multiply(3);

console.log(multiplyBy2(4));  // 8
console.log(multiplyBy3(4));  // 12
```

## Benefits

- Function Reusability: Create specialized functions from more general ones
- Partial Application: Apply arguments one at a time
- Avoid Repetition: Create function templates with pre-filled arguments
- Better Composition: Easier to compose with other functions

## Helper Function for Currying

```js
// Curry any function with multiple arguments
function curry(fn) {
    return function curried(...args) {
        if (args.length >= fn.length) {
            return fn.apply(this, args);
        }
        return (...moreArgs) => curried.apply(this, args.concat(moreArgs));
    };
}

// Example usage
const sum = (a, b, c) => a + b + c;
const curriedSum = curry(sum);

console.log(curriedSum(1)(2)(3));     // 6
console.log(curriedSum(1, 2)(3));     // 6
console.log(curriedSum(1)(2, 3));     // 6
```

## Best Practices

- Keep it Simple: Only curry when it adds value
- Document Well: Curried functions can be confusing without good documentation
- Consider Performance: Deeply curried functions create multiple closures
- Use TypeScript: Type systems help catch errors with curried functions

## Common Use Cases

- Configuration Management
- Event Handling
- Partial Application
- Function Composition
- Data Transformation Pipelines

Currying is particularly useful in functional programming and when you need to create specialized functions from more general ones. However, it's important to use it judiciously as it can make code harder to understand if overused.
