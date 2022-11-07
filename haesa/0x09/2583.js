const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const [n, m, k] = input.shift().split(' ').map(Number);
const square = input.map((x) => x.split(' ').map(Number));
const visit = new Array(n).fill(0).map((x) => new Array(m).fill(0));
const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];
const answer = [];
let count = 0;

function validRange(i, j) {
  return i >= 0 && i < n && j >= 0 && j < m;
}

function getArea(i, j) {
  const queue = [[i, j]];
  let area = 1;
  visit[i][j] = 1;
  while (queue.length) {
    const [curY, curX] = queue.shift();
    for (let k = 0; k < 4; k++) {
      const ny = curY + dy[k];
      const nx = curX + dx[k];
      if (!validRange(ny, nx) || visit[ny][nx]) continue;
      queue.push([ny, nx]);
      visit[ny][nx] = 1;
      area++;
    }
  }
  return area;
}

for (let i = 0; i < square.length; i++) {
  const [x1, y1, x2, y2] = square[i];
  for (let j = 0; j < y2 - y1; j++)
    for (let k = 0; k < x2 - x1; k++) visit[n - y2 + j][x1 + k] = 1;
}

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (visit[i][j] == 1) continue;
    answer.push(getArea(i, j));
    count++;
  }
}
console.log(count);
console.log(answer.sort((a, b) => a - b).join(' '));
