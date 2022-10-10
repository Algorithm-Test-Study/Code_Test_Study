const [t, ...input] = require('fs')
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const dx = [-2, -2, 2, 2, -1, 1, -1, 1];
const dy = [-1, 1, -1, 1, 2, 2, -2, -2];

let l;
let map;
function mapping() {
  map = new Array(l);
  for (let i = 0; i < l; i++) map[i] = Array.from({ length: l }, () => 0);
}

function isVisit(x, y) {
  return map[x][y];
}

function isRange(x, y) {
  return x >= 0 && x < l && y >= 0 && y < l;
}

function bfs([fromX, fromY], [toX, toY]) {
  const queue = [[fromX, fromY, 0]];
  map[fromX][fromY] = 1;

  while (true) {
    const [x, y, d] = queue.shift();
    if (x === toX && y === toY) return d;
    for (let k = 0; k < 8; k++) {
      const nx = x + dx[k];
      const ny = y + dy[k];
      if (!isRange(nx, ny) || isVisit(nx, ny)) continue;
      queue.push([nx, ny, d + 1]);
      map[nx][ny] = 1;
    }
  }
}

function solution() {
  for (let i = 0; i < t; i++) {
    l = Number(input.shift());
    mapping();
    from = input.shift().split(' ').map(Number);
    to = input.shift().split(' ').map(Number);
    console.log(bfs(from, to));
  }
}
solution();
