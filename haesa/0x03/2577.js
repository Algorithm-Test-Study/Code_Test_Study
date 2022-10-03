const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const num = input.reduce((acc, cur) => acc * cur).toString();
const result = new Array(10).fill(0);

for (const i of num) result[i]++;

console.log(...result);
