const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');

const result = { 0: 'D', 1: 'C', 2: 'B', 3: 'A', 4: 'E' };

input.forEach((line) => {
  const count = line
    .split(' ')
    .map(Number)
    .reduce((acc, cur) => acc + cur, 0);
  console.log(result[count]);
});
