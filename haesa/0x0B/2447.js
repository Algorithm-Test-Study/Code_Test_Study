const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim();
const n = Number(input);

const answer = Array.from({ length: n }, () =>
  Array.from({ length: n }, () => ' ')
);

const solution = (r, c, n) => {
  if (n === 1) {
    answer[r][c] = '*';
    return;
  }

  const gap = n / 3;

  for (let i = 0; i < n; i += gap) {
    for (let j = 0; j < n; j += gap) {
      if (i === gap && j === gap) continue;
      solution(r + i, c + j, gap);
    }
  }
};

solution(0, 0, n);
console.log(answer.map((x) => x.join('')).join('\n'));
