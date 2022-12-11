from collections import defaultdict
from typing import List

# Time Complexity: O(NK logK), where N is the length of strs, and K is the maximum length of a string in strs.

# Space Complexity: O(NK), the total information content stored in res.


def groupAnagrams(strs: List[str]) -> List[List[str]]:
    res = defaultdict(list)

    for s in strs:
        sortedString = "".join(sorted(s))
        res[sortedString].append(s)

    return res.values()


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(groupAnagrams(strs))