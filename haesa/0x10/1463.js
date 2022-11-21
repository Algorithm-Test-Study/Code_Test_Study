const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());
const answer = new Array(input + 1).fill(0);

for (let i = 2; i < answer.length; i++) {
  answer[i] = answer[i - 1] + 1;

  if (i % 3 === 0) {
    answer[i] = Math.min(answer[i], answer[i / 3] + 1);
  }

  if (i % 2 === 0) {
    answer[i] = Math.min(answer[i], answer[i / 2] + 1);
  }
}

console.log(answer[input]);
