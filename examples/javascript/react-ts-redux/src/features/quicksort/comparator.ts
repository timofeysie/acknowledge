export type CompareFunction<T> = (a: T, b: T) => number;

export const createComparator = <T>(compareFunction?: CompareFunction<T>) => {
  const defaultCompareFunction: CompareFunction<T> = (a, b) => {
    if (a === b) return 0;
    return a < b ? -1 : 1;
  };

  const compare = compareFunction || defaultCompareFunction;

  return {
    compare,
    equal: (a: T, b: T) => compare(a, b) === 0,
    lessThan: (a: T, b: T) => compare(a, b) < 0,
    greaterThan: (a: T, b: T) => compare(a, b) > 0,
    lessThanOrEqual: (a: T, b: T) => compare(a, b) <= 0,
    greaterThanOrEqual: (a: T, b: T) => compare(a, b) >= 0,
    reverse: () => createComparator<T>((a, b) => compare(b, a))
  };
};
