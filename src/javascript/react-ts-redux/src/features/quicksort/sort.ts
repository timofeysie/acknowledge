import { CompareFunction, createComparator } from "./comparator";

type SortCallbacks<T> = {
  compareCallback?: CompareFunction<T>;
  visitingCallback?: (element: T) => void;
};

// Initialize sorting callbacks with default values if not provided
const initSortingCallbacks = <T>(originalCallbacks?: SortCallbacks<T>): Required<SortCallbacks<T>> => {
  const callbacks = originalCallbacks || {};
  const stubCallback = () => {};
  return {
    compareCallback: callbacks.compareCallback || ((a: T, b: T) => 0),
    visitingCallback: callbacks.visitingCallback || stubCallback
  };
};

const createSort = <T>(originalCallbacks?: SortCallbacks<T>) => {
  const callbacks = initSortingCallbacks(originalCallbacks);
  const comparator = createComparator(callbacks.compareCallback);

  return {
    callbacks,
    comparator,
    // Placeholder sort method to be implemented by specific sorting algorithms
    sort: () => {
      throw new Error('sort method must be implemented');
    }
  };
};

export type { SortCallbacks };
export { initSortingCallbacks, createSort };