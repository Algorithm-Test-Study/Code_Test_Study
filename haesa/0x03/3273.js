// const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// const arr = input[1].split(' ').map(Number);
// const x = Number(input[2]);

// const check = new Array(1000001).fill(0);
// let result = 0;
// arr.forEach((num) => {
//   check[x - num] && result++;
//   check[num] = 1;
// });

// console.log(result);

const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');

const arr = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
const x = Number(input[2]);

let left = 0;
let right = arr.length - 1;
let cnt = 0;

while (left < right) {
  if (arr[left] + arr[right] == x) {
    cnt++;
    left++;
  } else if (arr[left] + arr[right] > x) right--;
  else left++;
}

console.log(cnt);
