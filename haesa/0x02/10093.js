const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
const answer = [];
for (let i = input[0] + 1; i < input[1]; i++) answer.push(i);
console.log(`${answer.length}\n${answer.join(' ')}`);
