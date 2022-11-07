const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());

let answer = '';
for (let i = input; i > 0; i--) {
  answer += '*'.repeat(i);
  answer += '\n';
}
console.log(answer);
