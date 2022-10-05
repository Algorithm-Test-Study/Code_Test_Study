const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const n = Number(input[0]);
const stack = [];
const result = [];

for (let i = 1; i <= n; i++) {
  const [cmd, num] = input[i].trim().split(' ');
  if (cmd == 'push') stack.push(Number(num));
  else if (cmd == 'pop') result.push(stack.length ? stack.pop() : -1);
  else if (cmd == 'size') result.push(stack.length);
  else if (cmd == 'empty') result.push(stack.length ? 0 : 1);
  else if (cmd == 'top')
    result.push(stack.length ? stack[stack.length - 1] : -1);
}
console.log(...result);
