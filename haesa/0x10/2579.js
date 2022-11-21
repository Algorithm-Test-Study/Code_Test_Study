const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);
const answer = new Array(input).fill(0);

answer[0] = input[0];
answer[1] = input[0] + input[1];
answer[2] = Math.max(input[0] + input[2], input[1] + input[2]);

for (let i = 3; i < n; i++) {
  answer[i] = Math.max(
    input[i] + input[i - 1] + answer[i - 3],
    input[i] + answer[i - 2]
  );
}

console.log(answer[n - 1]);
