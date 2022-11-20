const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input[0]);
const numbers = input[1].split(' ').map(Number);
const answer = [numbers[0]];

for (let i = 1; i < n; i++) {
  answer[i] =
    numbers[i] > numbers[i] + answer[i - 1]
      ? numbers[i]
      : numbers[i] + answer[i - 1];
}

console.log(Math.max(...answer));
