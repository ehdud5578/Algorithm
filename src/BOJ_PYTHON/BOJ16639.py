import copy

n = int(input())
nstring = input()
numlist = []
maxresult = 0
for x in range(n):
    if x % 2 == 0:
        numlist.append(int(nstring[x]))
    else:
        numlist.append(nstring[x])


def dfs(A):
    global maxresult
    for i in range(len(A)):
        if len(A) == 1:
            maxresult = max(maxresult, A[0])
            return
        if i % 2 == 1:
            B = []
            tempAresult = int(A[i - 1])
            cal = A[i]
            tempBresult = int(A[i + 1])
            if cal == '+':
                tempcal = tempAresult + tempBresult
            elif cal == '-':
                tempcal = tempAresult - tempBresult
            else:
                tempcal = tempAresult * tempBresult
            for x in range(len(A)):
                if x == i - 1 or x == i + 1:
                    continue
                if x == i:
                    B.append(tempcal)
                else:
                    B.append(A[x])
            dfs(B)


dfs(numlist)
print(maxresult)
