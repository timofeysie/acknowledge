import { CompareFunction, createComparator } from "../../utils/comparator";

export type BinaryTreeNode<T> = {
  value: T | null;
  left: BinaryTreeNode<T> | null;
  right: BinaryTreeNode<T> | null;
  parent: BinaryTreeNode<T> | null;
  meta: Map<string, any>;
  nodeComparator: CompareFunction<T>;
};

export const createNode = <T>(
  value: T | null = null,
  compareFunction?: CompareFunction<T>
): BinaryTreeNode<T> => ({
  value,
  left: null,
  right: null,
  parent: null,
  meta: new Map(),
  nodeComparator: compareFunction || createComparator<T>().compare,
});

export const setLeft = <T>(
  node: BinaryTreeNode<T>,
  leftNode: BinaryTreeNode<T> | null
): void => {
  node.left = leftNode;
  if (leftNode) leftNode.parent = node;
};

export const setRight = <T>(
  node: BinaryTreeNode<T>,
  rightNode: BinaryTreeNode<T> | null
): void => {
  node.right = rightNode;
  if (rightNode) rightNode.parent = node;
};

export const setValue = <T>(node: BinaryTreeNode<T>, value: T): void => {
  node.value = value;
};

export const traverseInOrder = <T>(
  node: BinaryTreeNode<T> | null,
  callback: (node: BinaryTreeNode<T>) => void
): void => {
  if (node) {
    traverseInOrder(node.left, callback);
    callback(node);
    traverseInOrder(node.right, callback);
  }
};
