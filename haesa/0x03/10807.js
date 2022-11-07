const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input.shift());
const arr = input.shift().split(' ').map(Number);
const v = Number(input[0]);
console.log(arr.filter((x) => x === v).length);

// const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const arr = input[1].trim().split(' ');
// console.log(arr.filter((x) => x === input[2]).length);
