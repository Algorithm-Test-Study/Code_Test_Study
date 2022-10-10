const [nm, ...input] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [n, m] = nm.split(' ').map(Number);
const picture = input.map((s) => s.split(' ').map(Number));

function isRange(x, y) {
  return x >= 0 && x < n && y >= 0 && y < m;
}

const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

function bfs(i, j) {
  let area = 0;
  picture[i][j] = 0;
  const queue = [[i, j]];
  while (queue.length) {
    let [x, y] = queue.shift();
    area++;
    for (let k = 0; k < 4; k++) {
      const nx = x + dx[k];
      const ny = y + dy[k];
      if (!isRange(nx, ny) || picture[nx][ny] === 0) continue;
      picture[nx][ny] = 0;
      queue.push([nx, ny]);
    }
  }
  return area;
}

let num = 0;
let max = 0;
let area = 0;

function solution() {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (picture[i][j] === 0) continue;
      num++;
      area = bfs(i, j);
      area > max && (max = area);
    }
  }
  console.log(num);
  console.log(max);
}
solution();
