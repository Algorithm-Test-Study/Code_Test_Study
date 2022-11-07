const fs = require('fs');
const input = Number(fs.readFileSync('/dev/stdin').toString());

let answer = '';
for (let i = 1; i <= input; i++) {
  answer += ' '.repeat(input - i);
  answer += '*'.repeat(2 * i - 1);
  answer += '\n';
}
for (let i = input - 1; i > 0; i--) {
  answer += ' '.repeat(input - i);
  answer += '*'.repeat(2 * i - 1);
  answer += '\n';
}
console.log(answer);
