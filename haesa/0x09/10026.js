const [n, ...input] = require('fs')
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');
const map = input.map((x) => x.trim().split(''));
const visit = new Array(n);
for (let i = 0; i < n; i++) visit[i] = Array.from({ length: n }, () => 0);

const dx = [0, 0, 1, -1];
const dy = [1, -1, 0, 0];

function isRange(x, y) {
  return x >= 0 && x < n && y >= 0 && y < n;
}

function isVisit(x, y) {
  return visit[x][y];
}

function bfs(i, j) {
  const queue = [[i, j]];
  visit[i][j] = 1;
  while (queue.length) {
    const [x, y] = queue.shift();
    for (let k = 0; k < 4; k++) {
      const nx = x + dx[k];
      const ny = y + dy[k];
      if (!isRange(nx, ny) || isVisit(nx, ny) || map[x][y] !== map[nx][ny])
        continue;
      queue.push([nx, ny]);
      visit[nx][ny] = 1;
    }
  }
}

const answer = [0, 0];
function solution() {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (visit[i][j]) continue;
      bfs(i, j);
      answer[0]++;
    }
  }

  for (let i = 0; i < n; i++)
    for (let j = 0; j < n; j++) {
      if (map[i][j] === 'R') map[i][j] = 'G';
      visit[i][j] = 0;
    }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (visit[i][j]) continue;
      bfs(i, j);
      answer[1]++;
    }
  }
  console.log(answer.join(' '));
}
solution();
