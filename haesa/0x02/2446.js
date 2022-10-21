const fs = require('fs');
const input = Number(fs.readFileSync('/dev/stdin').toString());

let answer = '';
for (let i = 0; i < input; i++) {
  answer += ' '.repeat(i);
  answer += '*'.repeat(2 * (input - i) - 1);
  answer += '\n';
}
for (let i = 2; i <= input; i++) {
  answer += ' '.repeat(input - i);
  answer += '*'.repeat(2 * i - 1);
  answer += '\n';
}
console.log(answer);
