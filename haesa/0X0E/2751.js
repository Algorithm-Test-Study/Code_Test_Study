const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const answer = input.map(Number);
answer.sort((a, b) => a - b);
console.log(answer.join('\n'));
