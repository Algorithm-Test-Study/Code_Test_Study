const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());

let answer = '';
for (let i = 1; i <= input; i++) {
  answer += ' '.repeat(input - i);
  answer += '*'.repeat(2 * i - 1);
  answer += '\n';
}
console.log(answer);
