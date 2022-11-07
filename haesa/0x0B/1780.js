const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const z = Number(n);
const paper = input.map((x) => x.trim().split(' ').map(Number));
const answer = [0, 0, 0];

function check(r, c, gap) {
  for (let i = r; i < r + gap; i++)
    for (let j = c; j < c + gap; j++)
      if (paper[r][c] !== paper[i][j]) return false;

  return true;
}

function solution(r, c, z) {
  if (check(r, c, z)) {
    answer[paper[r][c] + 1] += 1;
    return;
  }

  const gap = z / 3;
  for (let i = 0; i < z; i += gap)
    for (let j = 0; j < z; j += gap) solution(r + i, c + j, gap);
}

solution(0, 0, z);
console.log(answer.join('\n'));
