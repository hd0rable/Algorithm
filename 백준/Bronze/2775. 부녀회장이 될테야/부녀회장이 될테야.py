t=int(input())
for i in range(t):
  k=int(input())
  n=int(input())
  people = [i for i in range(1, n+1)] #0층

  for a in range(k):
    new=[]
    for b in range(1,n+1):
      new.append(sum(people[:b])) #아래층의 1~n호 까지의 합
    people=new.copy()
  print(people[-1]) #k층n호

