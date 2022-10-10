const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, m] = input.shift().split(' ').map(Number);

const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

const map = [];
for (let i = 0; i < n; i++) map.push(input.shift().split(' ').map(Number));

function isRange(x, y) {
  return x >= 0 && x < n && y >= 0 && y < m;
}

function melt() {
  const queue = [];
  for (let i = 1; i < n - 1; i++) {
    for (let j = 1; j < m - 1; j++) {
      if (map[i][j] === 0) continue;
      let h = map[i][j];
      for (let k = 0; k < 4; k++) {
        const nx = i + dx[k];
        const ny = j + dy[k];
        if (map[nx][ny] === 0) h--;
      }
      if (h > 0) queue.push([i, j, h]);
      else queue.push([i, j, 0]);
    }
  }

  for (let i = 0; i < queue.length; i++) {
    const [x, y, h] = queue[i];
    map[x][y] = h;
  }
}

function bfs(i, j, visit) {
  const queue = [[i, j]];
  visit[i][j] = 1;
  while (queue.length) {
    const [x, y] = queue.shift();
    for (let k = 0; k < 4; k++) {
      const nx = x + dx[k];
      const ny = y + dy[k];
      if (!isRange(nx, ny) || map[nx][ny] === 0 || visit[nx][ny]) continue;
      queue.push([nx, ny]);
      visit[nx][ny] = 1;
    }
  }
}

function solution() {
  const visit = new Array(n);
  let year = 0;

  while (true) {
    let count = 0;
    for (let a = 0; a < n; a++) visit[a] = Array.from({ length: m }, () => 0);

    for (let i = 1; i < n - 1; i++)
      for (let j = 1; j < m - 1; j++) {
        if (map[i][j] === 0 || visit[i][j]) continue;
        bfs(i, j, visit);
        count++;
      }
    if (count > 1) return year;
    if (count === 0) return 0;

    melt();
    year++;
  }
}
console.log(solution());
