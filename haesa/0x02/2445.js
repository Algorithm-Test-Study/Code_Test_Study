const fs = require('fs');
const input = Number(fs.readFileSync('/dev/stdin').toString());

let answer = '';
for (let i = 1; i <= input; i++) {
  answer += '*'.repeat(i);
  answer += ' '.repeat((input - i) * 2);
  answer += '*'.repeat(i);
  answer += '\n';
}
for (let i = input - 1; i > 0; i--) {
  answer += '*'.repeat(i);
  answer += ' '.repeat((input - i) * 2);
  answer += '*'.repeat(i);
  answer += '\n';
}
console.log(answer);
