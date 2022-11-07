const fs = require('fs');
const [N, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const n = Number(N);
const dragonCurve = input.map((x) => x.trim().split(' ').map(Number));
const board = Array.from({ length: 105 }, () =>
  Array.from({ length: 105 }, () => 0)
);
let answer = 0;

for (let i = 0; i < n; i++) {
  const v = [];
  let [x, y, d, g] = dragonCurve[i];

  v.push(d % 4);
  board[y][x] = 1;

  while (g--) {
    const vSize = v.length;
    for (let j = vSize - 1; j >= 0; j--) {
      v.push((v[j] + 1) % 4);
    }
  }

  for (let j = 0; j < v.length; j++) {
    let dir = v[j];
    if (dir === 0) x++;
    else if (dir === 1) y--;
    else if (dir === 2) x--;
    else if (dir === 3) y++;
    board[y][x] = 1;
  }
}

for (let i = 0; i < 100; i++) {
  for (let j = 0; j < 100; j++) {
    if (!board[i][j]) continue;
    if (board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
      answer++;
    }
  }
}

console.log(answer);
