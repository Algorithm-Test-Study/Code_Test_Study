const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const result = input
  .map((v) => v.trim().split(' '))
  .sort((a, b) => (a[0] - b[0] !== 0 ? a[0] - b[0] : a[1] - b[1]))
  .map((v) => v.join(' '));

console.log(result.join('\n'));
