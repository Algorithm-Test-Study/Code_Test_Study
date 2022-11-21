const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const rope = input.map(Number).sort((a, b) => a - b);

let answer = 0;
while (rope.length > 0) {
  let min = rope[0];
  let L = rope.length;
  answer = min * L > answer ? min * L : answer;
  rope.shift();
}

console.log(answer);
