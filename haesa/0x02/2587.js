const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const avg = input.reduce((acc, cur) => acc + cur) / input.length;
const median = input.sort((a, b) => a - b)[2];
console.log(`${avg} ${median}`);
