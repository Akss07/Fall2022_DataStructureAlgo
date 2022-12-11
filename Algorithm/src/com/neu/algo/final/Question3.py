# question 3 - remove the minimum number of parentheses to make valid String

# Time Complexity : o(N) where N is length of the string
# Space Complexity : o(N)

def minRemoveToMakeValid(s: str) -> str:
    stack = []
    indicesToRemove = set()
    newStr = ""

    for i in range(len(s)):
        if s[i] == ')':
            if len(stack) != 0:
                stack.pop()
            else:
                indicesToRemove.add(i)
        elif s[i] == '(':
            stack.append(i)
        else:
            continue

    indicesToRemove = indicesToRemove.union(set(stack))

    for i in range(len(s)):
        if i not in indicesToRemove:
            newStr += s[i]

    return newStr


if __name__ == '__main__':
    s = "lee(t(c)o)de)"
    print(minRemoveToMakeValid(s))