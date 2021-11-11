import sys

cnt = int(sys.stdin.readline().strip())
for _ in range(cnt):
    rev = sys.stdin.readline().strip().split()
    for s in rev:
        sys.stdout.write(s[::-1] +" ")