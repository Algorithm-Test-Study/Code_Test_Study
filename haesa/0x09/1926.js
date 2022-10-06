const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [n, m] = input[0].split(' ').map(Number);
const picture = new Array(n);
for (let i = 0; i < n; i++)
  picture[i] = input[i + 1].trim().split(' ').map(Number);

const visit = new Array(n);
for (let i = 0; i < n; i++) visit[i] = Array.from({ length: m }, () => 0);

const queue = [];
const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];
let num = 0;
let max = 0,
  area = 0;
for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (visit[i][j] || picture[i][j] === 0) continue;
    queue.push([i, j]);
    visit[i][j] = 1;
    num++;
    while (queue.length) {
      let cur = queue.shift();
      area++;
      for (let k = 0; k < 4; k++) {
        const nx = cur[0] + dx[k];
        const ny = cur[1] + dy[k];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (visit[nx][ny] || picture[nx][ny] !== 1) continue;
        queue.push([nx, ny]);
        visit[nx][ny] = 1;
      }
    }
    area > max && (max = area);
    area = 0;
  }
}
