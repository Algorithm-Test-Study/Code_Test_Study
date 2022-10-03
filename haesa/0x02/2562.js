const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

let max = 0;
let index;
input.forEach((num, i) => num > max && ((max = num), (index = i + 1)));
console.log(`${max}\n${index}`);

// let input = require('fs')
//   .readFileSync('/dev/stdin')
//   .toString()
//   .split('\n')
//   .map(Number;

// let max = Math.max(...input);

// console.log(max);
// console.log(input.indexOf(max) + 1);
