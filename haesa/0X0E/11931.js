const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const answer = input.sort((a, b) => b - a);
console.log(answer.join(' '));
