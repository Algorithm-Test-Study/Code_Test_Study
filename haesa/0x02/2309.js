const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

input.sort((a, b) => a - b);

const solution = (arr) => {
  const sub = arr.reduce((acc, cur) => acc + cur, 0) - 100;

  for (let i = 0; i < 8; i++)
    for (let j = i + 1; j < 9; j++)
      if (arr[i] + arr[j] == sub) {
        arr.splice(j, 1);
        arr.splice(i, 1);
        return arr;
      }
};
console.log(solution(input).join('\n'));
