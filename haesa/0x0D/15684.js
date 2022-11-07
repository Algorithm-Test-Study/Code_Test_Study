const fs = require('fs');
const [NMH, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const [n, m, h] = NMH.trim().split(' ').map(Number);
const rowLine = input.map((x) => x.trim().split(' ').map(Number));
const coords = [];
const ladder = Array.from({ length: 32 }, () =>
  Array.from({ length: 12 }, () => false)
);

const check = () => {
  for (let k = 1; k <= n; k++) {
    let cur = k;
    for (let i = 1; i <= h; i++) {
      if (ladder[i][cur - 1]) cur -= 1;
      else if (ladder[i][cur]) cur += 1;
    }
    if (cur !== k) return false;
  }
  return true;
};

for (const [r, c] of rowLine) {
  ladder[r][c] = true;
}

for (let i = 1; i <= h; i++)
  for (let j = 1; j < n; j++) {
    if (ladder[i][j - 1] || ladder[i][j] || ladder[i][j + 1]) {
      continue;
    }
    coords.push([i, j]);
  }

if (check()) {
  console.log(0);
  return 0;
}

let answer = 0x7f7f7f7f;
const sz = coords.length;
for (let i = 0; i < sz; i++) {
  const [x, y] = coords[i];
  ladder[x][y] = true;

  if (check()) answer = Math.min(answer, 1);

  for (let j = i + 1; j < sz; j++) {
    const [x, y] = coords[j];
    ladder[x][y] = true;

    if (check()) {
      answer = Math.min(answer, 2);
    }

    for (let k = j + 1; k < sz; k++) {
      const [x, y] = coords[k];
      ladder[x][y] = true;

      if (check()) {
        answer = Math.min(answer, 3);
      }

      ladder[x][y] = false;
    }
    ladder[x][y] = false;
  }
  ladder[x][y] = false;
}

if (answer == 0x7f7f7f7f) {
  answer = -1;
}

console.log(answer);
