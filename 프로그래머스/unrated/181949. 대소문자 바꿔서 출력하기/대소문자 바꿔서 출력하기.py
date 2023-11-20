str = input()

res = ''
for s in str:
    if s.islower():
        res += s.upper()
    else:
        res += s.lower()
print(res)