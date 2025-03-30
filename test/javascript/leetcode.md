# LeetCode challenges

## [55. Jump Game](https://leetcode.com/problems/jump-game/description/)

This particular problem has a psychological connection as pointed out in [this article](https://www.psychologytoday.com/us/blog/in-practice/202503/what-a-coding-puzzle-can-teach-us-about-reaching-our-goals?msockid=1801411dfd7f629a39cc5443fc5663e1).

It would be interesting if the greedy algorithm described here could also feed back into the psychological connection.

Difficulty: Medium

### Description

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

#### Example

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

#### Constraints

1 <= nums.length <= 104
0 <= nums[i] <= 105

## Approach: Backward Greedy Algorithm

The idea is to work backwards from the last index, keeping track of the earliest position from which we can reach the end.

```typescript
function canJump(nums: number[]): boolean {
    // Start from the second to last position
    let lastGoodPosition = nums.length - 1;
    
    // Iterate backwards through the array
    for (let i = nums.length - 2; i >= 0; i--) {
        // If we can reach the last good position from current position
        if (i + nums[i] >= lastGoodPosition) {
            // Update the last good position to current position
            lastGoodPosition = i;
        }
    }
    
    // If we can reach from the start (index 0)
    return lastGoodPosition === 0;
}
```

## Why This Works

1. **Backward Traversal**: 
   - Start from the end and work backwards
   - Only need to find one valid path to return true
   - More efficient than checking all possible paths

2. **Greedy Choice**:
   - At each position, we only need to know if we can reach the last known good position
   - If we can reach it, current position becomes new last good position

3. **Time Complexity**: O(n)
   - Single pass through the array
   - Constant time operations at each step

4. **Space Complexity**: O(1)
   - Only using a single variable for tracking

## Example Walkthrough

For nums = [2,3,1,1,4]:

See [this file](./examples/javascript/vanilla-js/jump-game.js) for the above implementation and associated test cases.
