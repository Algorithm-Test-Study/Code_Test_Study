const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());

let answer = '';
for (let i = input; i > 0; i--) {
  answer += ' '.repeat(input - i);
  answer += '*'.repeat(2 * i - 1);
  answer += '\n';
}
console.log(answer);
