# Object References

"What will be logged and why?"

```javascript
// 1 primitives are passed by value
let a = "hello";
let b = a;
a = "world";
console.log(b); // "hello"
// 2
const person = { name: 'John' };
const people = [person];
person.name = 'Jane';
console.log(people[0].name); // "Jane"
// 3 spread operator creates a shallow copy
const newPerson = { ...person };
person.name = 'Bob';
console.log(newPerson.name); // "Jane"
// 4 nested arrays are still referenced, not copied
const arr1 = [1, 2, [3, 4]];
const arr2 = [...arr1];
arr1[2][0] = 'x';
console.log(arr2[2][0]); // "x"
```

**Answers:**

1. For primitive types:
   - When `b = a` is executed, the value is copied
   - Changes to `a` don't affect `b` because primitives are passed by value

2. First example shows reference behavior:
   - The array contains a reference to the same object
   - Modifying the original object affects what we see through the array

3. Second example shows shallow copying:
   - Spread operator creates a new object with copied values
   - Changes to original no longer affect the copy
   - Therefore `newPerson.name` remains "Jane"

4. Third example shows shallow copying of arrays:

- Spread operator performs shallow copy
- Nested arrays are still referenced, not copied
- Modifying nested array in original affects the copy
- For deep copying, use `JSON.parse(JSON.stringify())` or structured clone

Key concept:

- Primitive types are immutable and passed by value
- Objects are passed by reference
- spread operator creates a shallow copy
- nested arrays are still referenced, not copied
