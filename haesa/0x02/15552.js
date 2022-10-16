const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input[0]);
input.splice(0, 1);

let answer = '';
for (let i = 0; i < n; i++) {
  const [a, b] = input[i].split(' ');
  answer += `${Number(a) + Number(b)} `;
}
console.log(answer);
