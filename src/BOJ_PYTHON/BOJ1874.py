import sys

N = int(sys.stdin.readline().strip())
stackList = []
answer = []
arrPoint = 0
for _ in range(N):
    arr = int(sys.stdin.readline().strip())
    if arrPoint < arr:
        for a in range(arrPoint + 1, arr+1):
            stackList.append(a)
            answer.append("+")
        arrPoint = arr
        stackList.pop()
        answer.append("-")
    else:
        top = stackList.pop()
        if top != arr:
            answer = ["NO"]
            break
        else:
            answer.append("-")
for i in answer:
    print(i)
