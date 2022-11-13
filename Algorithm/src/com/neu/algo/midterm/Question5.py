from typing import List


def binarySearch(nums: List[int], target: int) -> int:
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2

        if nums[mid] == target:
            if mid == left or nums[mid - 1] < target:
                return mid
            else:
                right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1


def searchFrstPosition(array1: List[int], array2: List[int]) -> List[int]:
    if array1 is None:
        return None
    j = 0
    res = []
    while j < len(array2):
        target = array2[j]
        start = binarySearch(array1, target)
        res.append(start)
        j += 1
    print(res)
    return res


if __name__ == '__main__':
    array1 = [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 5, 5, 5, 8, 9, 10, 11]
    array2 = [1, 4, 5, 10, 11, 13]
    searchFrstPosition(array1, array2)
