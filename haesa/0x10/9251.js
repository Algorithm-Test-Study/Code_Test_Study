const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().split('\n');

const str1 = input[0].split('');
const str2 = input[1].split('');

const answer = Array.from(Array(2000), () => Array());

for (let i = 0; i <= str1.length; i++) {
  for (let j = 0; j <= str2.length; j++) {
    answer[i][j] = 0;
  }
}

for (let i = 1; i <= str1.length; i++) {
  for (let j = 1; j <= str2.length; j++) {
    if (str1[i - 1] === str2[j - 1]) {
      answer[i][j] = answer[i - 1][j - 1] + 1;
    } else {
      answer[i][j] = Math.max(answer[i][j - 1], answer[i - 1][j]);
    }
  }
}

console.log(answer[str1.length][str2.length]);
