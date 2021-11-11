import sys

stack1 = list(sys.stdin.readline().strip())
stack2 = []
cmdCount = int(sys.stdin.readline())
for _ in range(cmdCount):
    command = list(sys.stdin.readline().split())
    if command[0] == "P":
        stack1.append(command[1])
    elif command[0] == "L":
        if len(stack1) > 0:
            stack2.append(stack1.pop())
    elif command[0] == "D":
        if len(stack2) > 0:
            stack1.append(stack2.pop())
    elif command[0] == "B":
        if len(stack1) > 0:
            stack1.pop()
sys.stdout.write("".join(stack1 + stack2[::-1]))
# import sys
#
#
# def plus(s, x):
#     point = command_dic["pointer"]
#     s = s[:point] + x + s[point:]
#     command_dic["pointer"] += 1
#     return s
#
#
# def left(s):
#     point = command_dic["pointer"]
#     if point != 0:
#         command_dic["pointer"] -= 1
#     return s
#
#
# def right(s):
#     point = command_dic["pointer"]
#     if point < len(s):
#         command_dic["pointer"] += 1
#     return s
#
#
# def delete(s):
#     point = command_dic["pointer"]
#     if point != 0:
#         s = s[0:point - 1] + s[point:]
#         command_dic["pointer"]-=1
#     return s
#
#
# command_dic = {
#     "P": plus,
#     "L": left,
#     "D": right,
#     "B": delete,
#     "pointer": 0
# }
# editor = sys.stdin.readline().strip()
# command_dic["pointer"] = len(editor)
# commandCount = int(sys.stdin.readline())
# for _ in range(commandCount):
#     command = list(sys.stdin.readline().split())
#     if len(command) == 2:
#         editor = command_dic[command[0]](editor, command[1])
#     else:
#         editor = command_dic[command[0]](editor)
# print(editor)
