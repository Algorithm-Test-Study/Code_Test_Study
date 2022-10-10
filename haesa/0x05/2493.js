const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const n = Number(input[0]);
const tower = input[1].split(' ').map(Number);
const stack = [];
const result = [];

for (let i = 0; i < n; i++) {
  while (stack.length && tower[stack[stack.length - 1]] < tower[i]) stack.pop();
  if (stack.length === 0) result.push(0);
  else result.push(stack[stack.length - 1] + 1);
  stack.push(i);
}
console.log(result.join(' '));
