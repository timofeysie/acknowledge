# TypeScript Study List

Union Types — The ability to combine two or more other types, representing values that may be any one of those types.

```ts
function welcomePeople(x: string[] | string) {
  if (Array.isArray(x)) {
    // Here: 'x' is 'string[]'
    console.log("Hello, " + x.join(" and "));
  } else {
    // Here: 'x' is 'string'
    console.log("Welcome lone traveler " + x);
  }
}
```

This is from [TypeScript Best Practices](https://medium.com/@sobitdaniel/typescript-best-practices-610e8facb8df) by Daniel Sobit.
