const [t, ...input] = require('fs')
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

let n, m;

const dx = [0, 0, 1, -1];
const dy = [1, -1, 0, 0];

function isRange(x, y) {
  return x >= 0 && x < n && y >= 0 && y < m;
}

function bfs(i, j) {
  const queue = [[i, j]];
  map[i][j] = 0;
  while (queue.length) {
    const [x, y] = queue.shift();
    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (!isRange(nx, ny) || map[nx][ny] === 0) continue;
      queue.push([nx, ny]);
      map[nx][ny] = 0;
    }
  }
}

let map;
function mapping(n, m, k) {
  map = new Array(n);
  for (let i = 0; i < n; i++) map[i] = Array.from({ length: m }, () => 0);

  for (let i = 0; i < k; i++) {
    const [x, y] = input.shift().split(' ').map(Number);
    map[y][x] = 1;
  }
}

function solution() {
  for (let a = 0; a < t; a++) {
    const [column, row, k] = input.shift().split(' ').map(Number);
    n = row;
    m = column;
    mapping(n, m, k);

    let num = 0;
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < m; j++) {
        if (map[i][j] === 0) continue;
        bfs(i, j);
        num++;
      }
    }
    console.log(num);
  }
}
solution();
