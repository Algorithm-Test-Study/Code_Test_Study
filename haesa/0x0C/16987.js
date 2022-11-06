const fs = require('fs');
const [N, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const n = Number(N);
const eggs = input.map((x) => x.trim().split(' ').map(Number));
let answer = 0;
let result = 0;

const solution = (k) => {
  if (k === n) {
    answer = Math.max(answer, result);
    return;
  }

  if (eggs[k][0] <= 0 || result === n - 1) {
    solution(k + 1);
    return;
  }

  for (let i = 0; i < n; i++) {
    if (k === i || eggs[i][0] <= 0) continue;

    eggs[k][0] -= eggs[i][1];
    eggs[i][0] -= eggs[k][1];

    if (eggs[k][0] <= 0) result += 1;
    if (eggs[i][0] <= 0) result += 1;

    solution(k + 1);

    if (eggs[k][0] <= 0) result -= 1;
    if (eggs[i][0] <= 0) result -= 1;

    eggs[k][0] += eggs[i][1];
    eggs[i][0] += eggs[k][1];
  }
};

solution(0);
console.log(answer);
