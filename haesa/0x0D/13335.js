const fs = require('fs');
const [input1, input2] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');
const [n, w, l] = input1.split(' ').map(Number);
const arr = input2.split(' ').map(Number);
const queue = [];
let sum = 0;
let answer = 0;

for (let i = 0; i < n; i++) {
  while (true) {
    if (queue.length == w) {
      const item = queue.shift();
      sum -= item;
    }
    if (sum + arr[i] <= l) break;
    queue.push(0);
    answer += 1;
  }
  queue.push(arr[i]);
  sum += arr[i];
  answer += 1;
}
answer += w;
console.log(answer);
