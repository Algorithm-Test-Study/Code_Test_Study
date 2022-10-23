const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input[0]);
let answer = '';

function checkValidPS(ps) {
  const stack = [];
  for (let i = 0; i < ps.length; i++) {
    if (ps[i] === '(') stack.push('(');
    else {
      if (stack.length === 0) return 'NO ';
      else stack.pop();
    }
  }
  return stack.length === 0 ? 'YES ' : 'NO ';
}
for (let i = 1; i <= n; i++) answer += checkValidPS(input[i].trim());
console.log(answer);
