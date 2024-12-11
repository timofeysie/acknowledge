# Valid Anagram

This is number 2 on the list from Aman Manazir which is called the Pareto Problem Set.

The [leetCode question](https://leetcode.com/problems/valid-anagram/description/)

The [NeetCode-150 class-based solution](https://github.com/dipjul/NeetCode-150/blob/main/01.%20Arrays%20&%20Hashing/02.ValidAnagram.md)

A JavaScript version.

```js
var isAnagram = function(s, t) {
    // To count freq we make an array of size 26...
        const counter = new Array(26).fill(0);
        // Traverse all elements through a loop...
        for(let idx = 0; idx < s.length; idx++){
            counter[s.charCodeAt(idx)-97]++;
        }
        for(let idx = 0; idx < t.length; idx++){
            counter[t.charCodeAt(idx)-97]--;
        }
        // Above iteration provides us with count array having all values to zero then we can say we found an anagram.
        // Every element of count has to be equal to 0.
        // If it is greater than 0 it means s has a character whose occurrence is greater than its occurrence in t.
        // And if its less than 0 then, s has a character whose occurrence is smaller than its occurrence in t.
        for (let idx = 0; idx < 26; idx++) {
            if(counter[idx] != 0)
                return false;
        }
        return true;
};
```


Would there be something such as this in JaaScript?

```py
def isAnagram(self, s: str, t: str) -> bool:
        one = Counter(s)
        two = Counter(t)
        return one==two
```
