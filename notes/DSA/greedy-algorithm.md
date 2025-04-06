# Greedy Algorithm

A greedy algorithm is a type of algorithm that makes locally optimal choices in the hope of finding a global optimum.

It is a simple and intuitive approach that often leads to an efficient solution.

## Key Characteristics

1. **Makes locally optimal choices**: At each step, it picks the best available option without considering future consequences.

2. **No backtracking**: Once a choice is made, it's final. The algorithm doesn't revisit or modify previous decisions.

3. **Simple and efficient**: Generally easier to implement and runs faster than other approaches like dynamic programming.

4. **May not always find the optimal solution**: While it works well for many problems, it doesn't guarantee the best possible solution for all cases.

## Common Applications

1. **Scheduling Problems**
   - Job sequencing
   - Activity selection
   - Meeting room allocation

2. **Graph Algorithms**
   - Dijkstra's shortest path
   - Prim's minimum spanning tree
   - Kruskal's minimum spanning tree

3. **Data Compression**
   - Huffman coding

4. **Selection Problems**
   - Fractional knapsack problem
   - Coin change problem

## Example: Jump Game

The [Jump Game problem](../javascript/leetcode.md) is a classic example of where a greedy approach works effectively. Instead of trying all possible jump combinations (which would be inefficient), we work backwards from the goal, making locally optimal choices about which positions can reach our target.

The steps of the algorithm are as follows:

1. Start from the last index of the array.
2. Check if the current position can reach the last index.
3. If it can, update the last index to the current position.
4. Repeat the process until we reach the first index.

This is better than a brute force approach of trying all possible jump combinations.
A brute force approach would result in a time complexity of O(n^2) and a space complexity of O(n).

The greedy approach results in a time complexity of O(n) and a space complexity of O(1).


## When to Use

Greedy algorithms are best suited for problems where:

- Local optimal choices lead to a global optimal solution
- The problem has "optimal substructure"
- A simple, efficient solution is preferred over a complex, potentially more optimal one
