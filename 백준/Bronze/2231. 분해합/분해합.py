n=int(input())
copy=n
cnt=0
flag=0
# while(copy>0): #n 자리수 구하기
#   copy//=10
#   cnt+=1
# start=10**(cnt-1) #생성자 자리 수 구하기 
for i in range(1,n+1):
  ck=i
  ckcopy=ck
  while(ckcopy>0): #n 자리수 구하기
    ck+=ckcopy%10
    ckcopy//=10
  if(ck==n):
    print(i)
    flag=1
    break
if flag==0:
  print(0)
