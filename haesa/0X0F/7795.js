const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const T = Number(input.shift());
const answer = [];

function bs(element, b) {
  let left = 0;
  let right = b.length - 1;
  let lowerBoundIndex = 0;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (element > b[mid]) left = mid + 1;
    else right = mid - 1;
  }
  return left;
}

for (let i = 0; i < T; i++) {
  const [N, M] = input.shift().split(' ').map(Number);
  const a = input.shift().split(' ').map(Number);
  const b = input.shift().split(' ').map(Number);
  let result = 0;

  a.sort((a, b) => a - b);
  b.sort((a, b) => a - b);

  for (let j = 0; j < a.length; j++) result += bs(a[j], b);
  answer.push(result);
}

console.log(answer.join(' '));
