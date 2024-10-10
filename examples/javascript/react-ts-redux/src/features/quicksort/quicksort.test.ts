import { quickSort } from './quicksort';

describe('quickSort', () => {
  it('should sort numbers in ascending order', () => {
    const numbers = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5];
    const sortedNumbers = quickSort(numbers, {
      compareCallback: (a, b) => a - b,
    });
    expect(sortedNumbers).toEqual([1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]);
  });

  it('should sort strings by length', () => {
    const words = ["apple", "banana", "cherry", "date", "elderberry"];
    const sortedWords = quickSort(words, {
      compareCallback: (a, b) => a.length - b.length,
    });
    expect(sortedWords).toEqual(["date", "apple", "banana", "cherry", "elderberry"]);
  });

  it('should call visitingCallback for each element', () => {
    const numbers = [3, 1, 4];
    const visitingCallback = jest.fn();
    quickSort(numbers, {
      compareCallback: (a, b) => a - b,
      visitingCallback,
    });
    expect(visitingCallback).toHaveBeenCalledTimes(numbers.length);
    numbers.forEach(num => {
      expect(visitingCallback).toHaveBeenCalledWith(num);
    });
  });

  it('should handle an empty array', () => {
    const emptyArray: number[] = [];
    const sortedArray = quickSort(emptyArray, {
      compareCallback: (a, b) => a - b,
    });
    expect(sortedArray).toEqual([]);
  });

  it('should handle an array with one element', () => {
    const singleElementArray = [42];
    const sortedArray = quickSort(singleElementArray, {
      compareCallback: (a, b) => a - b,
    });
    expect(sortedArray).toEqual([42]);
  });

  it('should sort an already sorted array', () => {
    const sortedArray = [1, 2, 3, 4, 5];
    const result = quickSort(sortedArray, {
      compareCallback: (a, b) => a - b,
    });
    expect(result).toEqual([1, 2, 3, 4, 5]);
  });

  it('should sort a reverse-sorted array', () => {
    const reverseSortedArray = [5, 4, 3, 2, 1];
    const result = quickSort(reverseSortedArray, {
      compareCallback: (a, b) => a - b,
    });
    expect(result).toEqual([1, 2, 3, 4, 5]);
  });
});