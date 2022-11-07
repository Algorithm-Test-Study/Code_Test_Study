const fs = require('fs');
const [num1, num2, num3] = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);

let answer = 0;

if (num1 === num3) answer = 10000 + num1 * 1000;
else if (num1 === num2 || num2 === num3) answer = 1000 + num2 * 100;
else answer = num3 * 100;

console.log(answer);
