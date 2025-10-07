import sys
n=int(sys.stdin.readline())
arr=[0]*10001

for i in range(n):
  num=int(sys.stdin.readline())
  arr[num]+=1

for i in range(10001):
    if arr[i] != 0:
        for j in range(arr[i]):# arr[num]에 num이 들어온 개수 만큼 출력 
            print(i)
