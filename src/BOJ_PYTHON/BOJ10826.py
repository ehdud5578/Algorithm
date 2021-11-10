n = int(input())
num1 = 0
num2 = 1
if n > 1:
    for i in range(n - 1):
        temp = num2
        num2 += num1
        num1 = temp
if n == 0:
    print(num1)
else:
    print(num2)
