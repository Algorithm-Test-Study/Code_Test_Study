const [k, ...input] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const money = [];

for (let i = 0; i < k; i++) {
  if (input[i] === 0) money.pop();
  else money.push(input[i]);
}
console.log(money.reduce((acc, cur) => acc + cur, 0));
