def push_front(x, deq):
    tmp = [x]
    tmp.extend(deq)
    deq = tmp
    return deq


def push_back(x, deq):
    deq.append(x)
    return deq


def pop_front(deq):
    if deq:
        print(deq.pop(0))
    else:  # 빈 리스트 == False
        print(-1)


def pop_back(deq):
    if deq:
        print(deq.pop())
    else:
        print(-1)


def size(deq):
    print(len(deq))


def empty(deq):
    if not deq:
        print(1)
    else:
        print(0)


def front(deq):
    if deq:
        print(deq[0])
    else:
        print(-1)


def back(deq):
    if deq:
        print(deq[-1])
    else:
        print(-1)


statements_dict = {
    'push_front': push_front,
    'push_back': push_back,
    'pop_front': pop_front,
    'pop_back': pop_back,
    'size': size,
    'empty': empty,
    'front': front,
    'back': back
}
N = int(input())

deq = []

for _ in range(N):
    statement = input().split(" ")

    if len(statement) == 1:
        command = statement[0]
        statements_dict[command](deq)
    else:
        command, x = statement
        deq = statements_dict[command](x, deq)

# https://roseline124.github.io/algorithm/2019/03/18/Algorithm-190318.html
# 딕셔너리를 활용해 switch - case 를 구현할 수 있다.
# from collections import deque
# import sys
#
# commandcnt = int(sys.stdin.readline())
# dq = deque()
#
# for i in range(commandcnt):
#     command = list(sys.stdin.readline().split())
#     if command[0] == "push_front":
#         dq.appendleft(command[1])
#     elif command[0] == "push_back":
#         dq.append(command[1])
#     elif command[0] == "pop_front":
#         if len(dq) > 0:
#             print(dq.popleft())
#         else:
#             print(-1)
#     elif command[0] == "pop_back":
#         if len(dq) > 0:
#             print(dq.pop())
#         else:
#             print(-1)
#     elif command[0] == "size":
#         print(len(dq))
#     elif command[0] == "empty":
#         if len(dq) == 0:
#             print(1)
#         else:
#             print(0)
#     elif command[0] == "front":
#         if len(dq) > 0:
#             print(dq[0])
#         else:
#             print(-1)
#     elif command[0] == "back":
#         if len(dq) > 0:
#             print(dq[len(dq) - 1])
#         else:
#             print(-1)
