const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim();

const getSum = (arr) => {
  return arr
    .split(/[\+-]/)
    .map((v) => +v)
    .reduce((acc, n) => acc + n, 0);
};

const firstMinus = input.indexOf('-');

let answer;

if (firstMinus === -1) {
  answer = getSum(input);
} else {
  const plus = getSum(input.slice(0, firstMinus));
  const minus = getSum(input.slice(firstMinus + 1));
  answer = plus - minus;
}

console.log(answer);
