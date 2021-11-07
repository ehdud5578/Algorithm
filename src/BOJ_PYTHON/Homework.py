def makeAccount(accountNum, name, money):
    global account
    account[accountNum] = [name, money]


# 미리 입력되어 있는 계좌 정보를 불러옴
file = open("account.txt", "r")
account = {}
while True:
    str1 = file.readline()
    if str1 == "":
        break
    else:
        temp = str1.split()
        account[temp[0]] = [temp[1], temp[2]]
file.close()

while True:
    command = input("1. 계좌번호 생성 | 2. 계좌목록 | 3. 예금 | 4.출금 | 5.종료")
    if command == '5':
        break
    elif command == '1':
        print("계좌 번호 생성 페이지 입니다.")
        accNum = input("계좌번호를 입력해주세요")
        accName = input("이름을 입력해주세요")
        money = 0
        makeAccount(accNum, accName, money)
    elif command == '2':
        print("계좌 목록입니다.")
        print(account)
    elif command == '3':
        print("입금")
        userAccount = input("입금하실 계좌번호를 입력하세요")
        if userAccount in account:
            money_deposit = int(input("입금하실 금액을 입력하세요"))
            money_before = int(account.get(userAccount)[1])
            account.get(userAccount)[1] = str(money_before + money_deposit)
        else:
            print("없는 계좌입니다. ")
    elif command == '4':
        print("출금")
        userAccount = input("출금하실 계좌번호를 입력하세요")
        if userAccount in account:
            money_withdraw = int(input("출금하실 금액을 입력하세요"))
            money_before = int(account.get(userAccount)[1])
            if money_before >= money_withdraw:
                account.get(userAccount)[1] = str(money_before - money_withdraw)
            else:
                print("계좌의 잔액이 부족합니다.")
        else:
            print("없는 계좌입니다.")
    else:
        print("1 ~ 5 만 입력 가능합니다.")

# 파일에 계좌 정보를 기록함.
file = open("account.txt", "w")
for i, j in account.items():
    file.write(i + " ")
    for k in j:
        file.write(k + " ")
    file.write("\n")
file.close()
