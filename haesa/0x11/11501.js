const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .split('\n')
  .map((a) => a.trim());
const T = Number(input[0]);
const answer = [];

for (let i = 0; i < T; i++) {
  const N = Number(input[2 * i + 1]);
  const arr = input[2 * i + 2].split(' ').map(Number);
  let k = N - 1;
  let max = arr[k];
  let sum = 0;

  while (k >= 0) {
    if (max < arr[k]) {
      max = arr[k];
    } else {
      sum += max - arr[k];
    }
    k--;
  }
  answer.push(sum);
}

console.log(answer.join('\n'));
