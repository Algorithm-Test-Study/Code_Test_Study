const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());

let answer = '';
for (let i = 0; i < input; i++) {
  answer += ' '.repeat(i);
  answer += '*'.repeat(input - i);
  answer += '\n';
}
console.log(answer);
