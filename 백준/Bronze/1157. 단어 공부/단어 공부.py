import sys
input = sys.stdin.readline

word = input().strip().upper()

alphabet = []
for i in range(len(word)):
    if word[i] not in alphabet:
        alphabet.append(word[i])

word_count = []
for j in range(len(alphabet)):
    word_count.append(word.count(alphabet[j]))

if word_count.count(max(word_count)) > 1:
    print("?")
else:  
    print(alphabet[word_count.index(max(word_count))])