# Binary Trees

## "level-order"/"breadth-first" representation Array to Binary Tree Mapping

For an array [4,2,7,1,3,6,9], here's how it maps to a binary tree:

```txt
       4         // index 0
     /   \
    2     7      // indices 1,2
   / \   / \
  1   3 6   9    // indices 3,4,5,6
```

First element (index 0) is always the root: 4
For any node at index i:
Left child is at index 2i + 1
Right child is at index 2i + 2

```js
function arrayToTree(array: number[]): TreeNode | null {
    if (array.length === 0) return null;
    
    // Create root node
    const root = new TreeNode(array[0]);
    const queue = [root];
    let i = 1;
    
    // Process each node in queue
    while (queue.length > 0 && i < array.length) {
        const current = queue.shift()!;
        
        // Add left child
        if (i < array.length) {
            current.left = new TreeNode(array[i]);
            queue.push(current.left);
        }
        i++;
        
        // Add right child
        if (i < array.length) {
            current.right = new TreeNode(array[i]);
            queue.push(current.right);
        }
        i++;
    }
    
    return root;
}

// Usage example:
const tree = arrayToTree([4,2,7,1,3,6,9]);
```

