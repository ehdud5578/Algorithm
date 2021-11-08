testcase = int(input())
for i in range(testcase):
    n = int(input())
    l = [list(map(int, input().split())) for _ in range(2)]
    if n >= 2:
        l[0][1] += l[1][0]
        l[1][1] += l[0][0]
        for k in range(2, n):
            l[0][k] = max(l[1][k - 1] + l[0][k], l[1][k - 2] + l[0][k])
            l[1][k] = max(l[0][k - 1] + l[1][k], l[0][k - 2] + l[1][k])
    print(max(l[0][n - 1], l[1][n - 1]))
