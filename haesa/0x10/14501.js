let [n, ...arr] = require('fs')
  .readFileSync('input.txt')
  .toString()
  .split('\n')
  .map((v) => v.split(' ').map(Number));

n = n[0];
const dp = new Array(n).fill(0);

for (let i = 0; i < n; i++) {
  const [duration, profit] = arr[i];
  if (i + duration > n) continue;
  dp[i] += profit;

  for (let j = i + duration; j < n; j++) {
    dp[j] = Math.max(dp[j], dp[i]);
  }
}
console.log(Math.max(...dp));
