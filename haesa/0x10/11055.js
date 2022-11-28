const fs = require('fs');
const q = fs.readFileSync('./input.txt').toString().split('\n');
const cases = Number(q[0]);
const inputs = q[1].split(' ').map((v) => Number(v));
const dp = [];

for (let i = 0; i < cases; i++) {
  let max = 0;
  let maxIndex = -1;

  for (let j = 0; j < i; j++) {
    if (inputs[i] > inputs[j] && dp[j] > max) {
      max = dp[j];
      maxIndex = j;
    }
  }
  if (maxIndex !== -1) {
    dp[i] = dp[maxIndex] + inputs[i];
  } else {
    dp[i] = inputs[i];
  }
}
console.log(Math.max(...dp));
