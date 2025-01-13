# CSS-in-JS

The rootStyles syntax below is using CSS-in-JS styling with special selectors. Here's the relevant part with explanations:

```js
rootStyles={{
    background: isLightMode ? "#27272A" : "#232534",
    fontSize: "14px",
    color: isLightMode ? "#FFFFFF" : "#FFFFFF",
    // Targets elements with the "active" class
    [".active"]: {
        color: "#2196f3",
        // Targets icon elements within active items
        [`.${menuClasses.icon}`]: {
            color: "#2196f3",
        },
    },
    // Targets button elements using the menuClasses.button class
    [`.${menuClasses.button}`]: {
        "&:hover": {
            backgroundColor: isLightMode ? "#27272A" : "#232534",
            color: "#2196f3",
            [`.${menuClasses.icon}`]: {
                backgroundColor: isLightMode ? "#27272A" : "#232534",
                color: "#2196f3",
            },
        },
    },
}}
```

The square bracket notation [".active"] is a way to write CSS selectors as object keys. It's equivalent to writing .active in regular CSS.

The reason for using square bracket notation [".active"] instead of just .active is due to JavaScript object literal syntax limitations.

```js
const obj = {
  normal: "works fine",
  ["with.dot"]: "needs brackets",
  ["spaces here"]: "needs brackets",
  ["@special-chars"]: "needs brackets"
}
```
