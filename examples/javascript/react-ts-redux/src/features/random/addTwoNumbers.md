# Add Two Numbers

The brute force approach seems like a good idea to me:

```js
function addTwoNumbersUsingStrings(l1: ListNode, l2: ListNode): ListNode {
    // Convert lists to strings and reverse
    const num1 = listToString(l1).split('').reverse().join('');
    const num2 = listToString(l2).split('').reverse().join('');
    // Add as numbers
    const sum = BigInt(num1) + BigInt(num2);
    // Convert back to list
    return stringToList(sum.toString());
}
```

Since the rules state that "The number of nodes in each linked list is in the range [1, 100]", it seems like Number Size Limitations, Memory Inefficiency, and Performance are not issues.

However, we are given a ListNode and asked to return a LinkedList, so I suppose there would be some issue with that.

## Data Structures

### Linked List

- A linear data structure where elements are stored in nodes
- Each node contains:
  - A value (val)
  - A pointer to the next node (next)
- Properties:
  - Non-contiguous memory allocation
  - Dynamic size
  - Sequential access

### Dummy Node Pattern

```js
   const dummy = new ListNode(0);
   let current = dummy;
   // ... operations ...
   return dummy.next;
```

- A common linked list technique
  - Simplifies edge cases by providing a sentinel node
  - Eliminates need for special handling of the head node

## Algorithms

### Two-Pointer Technique

```js
   while (l1 !== null || l2 !== null || carry > 0) {
       // Move through both lists simultaneously
       l1 = l1 ? l1.next : null;
       l2 = l2 ? l2.next : null;
   }
```

- Traverses two linked lists in parallel
  - Time Complexity: O(max(N, M)) where N and M are list lengths
  - Space Complexity: O(max(N, M)) for the result list

### Digit-by-Digit Addition

```js
   const val1 = l1 ? l1.val : 0;
   const val2 = l2 ? l2.val : 0;
   const sum = val1 + val2 + carry;
   carry = Math.floor(sum / 10);
   current.next = new ListNode(sum % 10);
```

- Similar to grade-school addition
- Key components:
  - Base-10 arithmetic
  - Modulo operation (%) for digit extraction
  - Integer division (Math.floor(sum / 10)) for carry calculation

## Mathematical Concepts

### Place Value System

- Numbers stored in reverse order (least significant digit first)
- Example: 342 stored as 2 → 4 → 3

### Carry Propagation

- When sum ≥ 10, carry the 1 to next position
- Carry must be processed even after both lists are exhausted

### Time and Space Complexity

- Time Complexity: O(max(N, M))
  - Single pass through the longer list
  - Each operation per node is O(1)
- Space Complexity: O(max(N, M))
  - Output list length is at most max(N, M) + 1
  - Only constant extra space used besides output

## This problem is a good example of

- Linked list manipulation
- Two-pointer traversal
- Mathematical operations in programming
- Edge case handling (different length lists, carry values)
