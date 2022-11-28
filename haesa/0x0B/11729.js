const fs = require('fs');
const input = fs.readFileSync('./input.txt/').toString();

const N = Number(input);
const answer = [];
let count = 0;

function Hanoi(num, from, other, to) {
  if (num === 0) {
    return;
  }

  Hanoi(num - 1, from, to, other);
  answer.push([from, to]);
  count += 1;
  Hanoi(num - 1, other, from, to);
}

Hanoi(N, '1', '2', '3');
console.log(count);
console.log(answer.map((element) => element.join(' ')).join('\n'));
