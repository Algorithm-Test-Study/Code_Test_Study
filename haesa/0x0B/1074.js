const fs = require('fs');
const [n, r, c] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split(' ')
  .map(Number);

function z(n, r, c) {
  if (n === 0) return 0;
  const half = 1 << (n - 1);
  if (r < half && c < half) return z(n - 1, r, c);
  if (r < half && c >= half) return half * half + z(n - 1, r, c - half);
  if (r >= half && c < half) return 2 * half * half + z(n - 1, r - half, c);
  return 3 * half * half + z(n - 1, r - half, c - half);
}
console.log(z(n, r, c));
