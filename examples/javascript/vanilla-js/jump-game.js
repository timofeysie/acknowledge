/**
 * @description Given an integer array nums, you are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * @param nums 
 * @returns true if you can reach the last index, or false otherwise.
 * 
 * Start from the second to last position
 * Iterate backwards through the array
 * If we can reach the last good position from current position
 * Update the last good position to current position
 */
function canJump(nums) {
    let lastGoodPosition = nums.length - 1;
    
    for (let i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= lastGoodPosition) {
            lastGoodPosition = i;
        }
    }
    
    return lastGoodPosition === 0;
}

module.exports = { canJump };
