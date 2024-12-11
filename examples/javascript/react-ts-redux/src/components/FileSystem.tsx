import React, { useState, useCallback } from 'react';
import { BinaryTreeNode, createNode, setLeft, setRight, traverseInOrder } from '../features/tree/binaryTree';
import styles from './FileSystem.module.css';

interface FileSystemProps {
  // Add props if needed
}

const FileSystem: React.FC<FileSystemProps> = () => {
  const [inputValue, setInputValue] = useState<string>('');
  const [root, setRoot] = useState<BinaryTreeNode<string> | null>(null);
  const [items, setItems] = useState<string[]>([]);

  const insertNode = useCallback((value: string) => {
    const newNode = createNode(value);
    
    if (!root) {
      setRoot(newNode);
      return;
    }

    let current = root;
    while (current) {
      if (current.value && value < current.value) {
        if (!current.left) {
          setLeft(current, newNode);
          break;
        }
        current = current.left;
      } else {
        if (!current.right) {
          setRight(current, newNode);
          break;
        }
        current = current.right;
      }
    }
  }, [root]);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(e.target.value);
  };

  const handleAddItem = () => {
    if (inputValue.trim()) {
      insertNode(inputValue);
      
      const newItems: string[] = [];
      traverseInOrder(root, (node) => {
        if (node.value) {
          newItems.push(node.value);
        }
      });
      
      setItems(newItems);
      setInputValue('');
    }
  };

  return (
    <div className={styles.fileSystem}>
      <h2>File System Demo</h2>
      <div className={styles.inputContainer}>
        <input
          type="text"
          value={inputValue}
          onChange={handleInputChange}
          placeholder="Enter file or folder name"
          className={styles.input}
        />
        <button onClick={handleAddItem} className={styles.button}>
          Add Item
        </button>
      </div>

      <div className={styles.fileList}>
        <h3>Current Items (Sorted):</h3>
        <ul className={styles.list}>
          {items.map((item, index) => (
            <li key={index} className={styles.listItem}>
              {item}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default FileSystem;
