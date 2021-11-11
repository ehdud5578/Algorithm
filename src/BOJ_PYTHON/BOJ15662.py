# N =0 S = 1
import sys
from collections import deque


def rotate(n, d, before):  # rorate 1 = 시계방향 -1 반시계 방향
    if n < T - 1 and before != n + 1:
        if (gear[n][2] == '0' and gear[n + 1][6] == '1') or (gear[n][2] == '1' and gear[n + 1][6] == '0'):
            rotate(n + 1, -1 * d, n)
    if n > 0 and before != n - 1:
        if (gear[n][6] == '0' and gear[n - 1][2] == '1') or (gear[n][6] == '1' and gear[n - 1][2] == '0'):
            rotate(n - 1, -1 * d, n)
    gear[n].rotate(d)


T = int(sys.stdin.readline().strip())
gear = []
for _ in range(T):
    oneGear = deque(sys.stdin.readline().strip())
    gear.append(oneGear)

command = int(sys.stdin.readline().strip())
for _ in range(command):
    GearNo, dir = map(int, input().split())
    rotate(GearNo - 1, dir, -1)
result = 0
for i in range(T):
    if gear[i][0] == '1':
        result += 1
print(result)
