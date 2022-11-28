const fs = require('fs');
const input = require('fs')
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const N = Number(input[0]);
const nums = input.slice(1).map((v) => v.split('').map(Number));

const quadTree = [];

function solution(n, x, y) {
  let total = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      total += nums[y + j][x + i];
    }
  }

  if (total === 0) quadTree.push(0);
  else if (total === n * n) quadTree.push(1);
  else {
    n /= 2;
    quadTree.push('(');
    solution(n, x, y);
    solution(n, x + n, y);
    solution(n, x, y + n);
    solution(n, x + n, y + n);
    quadTree.push(')');
  }
}

solution(N, 0, 0);
console.log(quadTree.join(''));
