import sys


def isVps(s):
    slist = []
    for ch in s:
        if ch == "(":
            slist.append("(")
        else:  # ) 일때
            if len(slist) > 0:
                slist.pop()
            else:
                return False
    if len(slist) == 0:
        return True
    else:
        return False


testcase = int(sys.stdin.readline().strip())
for _ in range(testcase):
    st = sys.stdin.readline().strip()
    if isVps(st):
        print("YES")
    else:
        print("NO")
