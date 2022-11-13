const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const [n, c] = input[0].trim().split(' ').map(Number);
const answer = input[1].split(' ').map(Number);
const set = new Set(answer);
const order = [...set];
const frequency = [];

order.forEach((e) => (frequency[e] = 0));
answer.forEach((e) => (frequency[e] += 1));

answer.sort((a, b) => {
  if (frequency[a] !== frequency[b]) {
    return frequency[b] - frequency[a];
  }

  return order.indexOf(a) - order.indexOf(b);
});

console.log(answer.join(' '));
