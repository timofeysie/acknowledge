import { describe, expect, test } from "@jest/globals";
import { ListNode, addTwoNumbers } from "./addTwo";

// Helper function to convert array to LinkedList
function arrayToList(arr: number[]): ListNode | null {
  if (arr.length === 0) return null;
  const dummy = new ListNode(0);
  let current = dummy;

  for (const num of arr) {
    current.next = new ListNode(num);
    current = current.next;
  }

  return dummy.next;
}

// Helper function to convert LinkedList to array
function listToArray(node: ListNode | null): number[] {
  const result: number[] = [];
  let current = node;

  while (current !== null) {
    result.push(current.val);
    current = current.next;
  }

  return result;
}

describe("addTwoNumbers", () => {
  test("Example 1: [2,4,3] + [5,6,4] = [7,0,8]", () => {
    const l1 = arrayToList([2, 4, 3]);
    const l2 = arrayToList([5, 6, 4]);
    const result = addTwoNumbers(l1, l2);
    expect(listToArray(result)).toEqual([7, 0, 8]);
  });

  test("Example 2: [0] + [0] = [0]", () => {
    const l1 = arrayToList([0]);
    const l2 = arrayToList([0]);
    const result = addTwoNumbers(l1, l2);
    expect(listToArray(result)).toEqual([0]);
  });

  test("Example 3: [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]", () => {
    const l1 = arrayToList([9, 9, 9, 9, 9, 9, 9]);
    const l2 = arrayToList([9, 9, 9, 9]);
    const result = addTwoNumbers(l1, l2);
    expect(listToArray(result)).toEqual([8, 9, 9, 9, 0, 0, 0, 1]);
  });
});
