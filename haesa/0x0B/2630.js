const fs = require('fs');
const [N, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const n = Number(N);
const paper = input.map((x) => x.trim().split(' ').map(Number));
const answer = [0, 0];

const check = (r, c, n) => {
  for (let i = r; i < r + n; i++)
    for (let j = c; j < c + n; j++)
      if (paper[r][c] !== paper[i][j]) return false;

  return true;
};

const solution = (r, c, n) => {
  if (n === 1) {
    answer[paper[r][c]] += 1;
    return;
  }

  if (check(r, c, n)) {
    answer[paper[r][c]] += 1;
    return;
  }

  const gap = n / 2;
  for (let i = 0; i < n; i += gap)
    for (let j = 0; j < n; j += gap) solution(r + i, c + j, gap);
};

solution(0, 0, n);
console.log(answer.join('\n'));
