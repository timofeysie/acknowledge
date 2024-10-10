import { SortCallbacks, createSort } from "./sort";

export const quickSort = <T>(originalArray: T[], originalCallbacks?: SortCallbacks<T>): T[] => {
    const { comparator, callbacks } = createSort(originalCallbacks);
  
    const sort = (array: T[]): T[] => {
      if (array.length <= 1) {
        return array;
      }
  
      // Step 1: Pick an element, called a pivot, from the array.
      const [pivot, ...rest] = array;
  
      // Step 2: Partitioning
      const leftArray: T[] = [];
      const rightArray: T[] = [];
      const centerArray: T[] = [pivot];
  
      // Reorder the array so that all elements with values less than the pivot
      // come before the pivot, while all elements with values greater than
      // the pivot come after it. Equal values can go either way.
      for (const element of rest) {
        callbacks.visitingCallback(element);
        if (comparator.equal(element, pivot)) {
          centerArray.push(element);
        } else if (comparator.lessThan(element, pivot)) {
          leftArray.push(element);
        } else {
          rightArray.push(element);
        }
      }
  
      // Step 3: Recursively apply the above steps to the sub-arrays
      const leftArraySorted = sort(leftArray);   // Sub-array with smaller values
      const rightArraySorted = sort(rightArray); // Sub-array with greater values
  
      // Combine the sorted sub-arrays and the pivot
      return [...leftArraySorted, ...centerArray, ...rightArraySorted];
    };
  
    // Start the sorting process with a copy of the original array
    return sort([...originalArray]);
  };