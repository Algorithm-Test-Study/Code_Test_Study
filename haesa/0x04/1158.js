const fs = require('fs');
const [n, k] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split(' ')
  .map(Number);

const result = [];
const arr = [];
for (let i = 1; i <= n; i++) arr.push(i);

let pos = 0;
while (arr.length) {
  pos = (pos + k - 1) % arr.length;
  result.push(arr.splice(pos, 1));
}
console.log('<' + result.join(', ') + '>');
