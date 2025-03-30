const { canJump } = require('./jump-game');

describe('Jump Game', () => {
    test('should return true for nums = [2,3,1,1,4]', () => {
        const nums = [2, 3, 1, 1, 4];
        expect(canJump(nums)).toBe(true);
    });

    test('should return false for nums = [3,2,1,0,4]', () => {
        const nums = [3, 2, 1, 0, 4];
        expect(canJump(nums)).toBe(false);
    });

    // Additional test cases
    test('should handle single element array', () => {
        const nums = [0];
        expect(canJump(nums)).toBe(true);
    });

    test('should handle array with all zeros except last', () => {
        const nums = [0, 0, 0, 0, 0];
        expect(canJump(nums)).toBe(false);
    });

    test('should handle array with exactly enough jumps', () => {
        const nums = [1, 1, 1, 1];
        expect(canJump(nums)).toBe(true);
    });
}); 