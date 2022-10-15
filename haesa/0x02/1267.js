const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input.shift());
const sec = input[0].trim().split(' ').map(Number);

const rate = () => {
  let youngsikRate = 0;
  let minsikRate = 0;

  for (let i = 0; i < n; i++) {
    youngsikRate += (parseInt(sec[i] / 30) + 1) * 10;
    minsikRate += (parseInt(sec[i] / 60) + 1) * 15;
  }

  if (youngsikRate < minsikRate) return `Y ${youngsikRate}`;
  else if (youngsikRate > minsikRate) return `M ${minsikRate}`;
  else return `Y M ${youngsikRate}`;
};

console.log(rate());
