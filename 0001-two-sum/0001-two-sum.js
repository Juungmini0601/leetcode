/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map = new Map()
    nums.forEach((num, index) => {
        map.set(num, index)
    });

    for(let [index, num] of nums.entries()) {
        const next = target - num;
        if(map.has(next) && map.get(next) !== index) {
            return [index, map.get(next)].sort()
        }
    }

    return []
};