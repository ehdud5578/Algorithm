import sys

nk = list(sys.stdin.readline().split())
n = int(nk[0])
k = int(nk[1])
josephus = [i for i in range(1, n + 1)]
answer = "<"
idx = 0
while len(josephus) > 0:
    nextidx = (idx + k-1) % len(josephus)
    answer += str(josephus.pop(nextidx)) + ", "
    idx = nextidx
answer = answer.rstrip(", ")
answer += ">"
print(answer)