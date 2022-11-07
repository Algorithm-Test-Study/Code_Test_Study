const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);
const odd = input.filter((x) => x % 2 !== 0);
if (odd.length) {
  console.log(odd.reduce((acc, cur) => acc + cur));
  console.log(Math.min(...odd));
} else console.log(-1);
