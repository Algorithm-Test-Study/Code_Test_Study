const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');
const answer = input.map((v) => v.trim());
const sum = (str) => {
  return str.match(/[\d]/g)?.reduce((acc, cur) => acc + Number(cur), 0) || 0;
};

const temp1 = answer;
const temp2 = answer;

answer.sort((a, b) => {
  if (a.length !== b.length) {
    return a.length - b.length;
  }

  const aSum = sum(a);
  const bSum = sum(b);

  if (aSum !== bSum) {
    return aSum - bSum;
  }

  return a.localeCompare(b);
});

console.log(answer.join('\n'));
