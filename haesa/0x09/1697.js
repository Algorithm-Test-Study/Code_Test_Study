const fs = require('fs');
const [n, k] = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ')
  .map(Number);
const visit = new Array(100001);
const queue = [[n, 0]];
visit[n] = 1;

function checkRange(pos) {
  return pos >= 0 && pos <= 100000;
}

function visited(pos) {
  return visit[pos];
}

while (true) {
  const [pos, sec] = queue.shift();
  if (pos == k) {
    console.log(sec);
    break;
  }
  if (checkRange(pos - 1) && !visited(pos - 1)) {
    queue.push([pos - 1, sec + 1]);
    visit[pos - 1] = 1;
  }
  if (checkRange(pos + 1) && !visited(pos + 1)) {
    queue.push([pos + 1, sec + 1]);
    visit[pos + 1] = 1;
  }
  if (checkRange(pos * 2) && !visited(pos * 2)) {
    queue.push([pos * 2, sec + 1]);
    visit[pos * 2] = 1;
  }
}
