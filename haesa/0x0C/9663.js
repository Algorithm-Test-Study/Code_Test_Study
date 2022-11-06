const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim();
const n = Number(input);

let answer = 0;
const isUsed1 = new Array(n).fill(false);
const isUsed2 = new Array(2 * n - 1).fill(false);
const isUsed3 = new Array(2 * n - 1).fill(false);

const solution = (k) => {
  if (k === n) {
    answer += 1;
    return;
  }

  for (let i = 0; i < n; i++) {
    if (isUsed1[i] || isUsed2[k + i] || isUsed3[k - i + n - 1]) continue;
    isUsed1[i] = true;
    isUsed2[k + i] = true;
    isUsed3[k - i + n - 1] = true;
    solution(k + 1);
    isUsed1[i] = false;
    isUsed2[k + i] = false;
    isUsed3[k - i + n - 1] = false;
  }
};

solution(0);
console.log(answer);
