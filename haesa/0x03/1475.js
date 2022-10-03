const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim();

let count = new Array(10).fill(0);
for (const i of input) count[i]++;

count[6] = Math.ceil((count[6] + count[9]) / 2);
count[9] = 0;

console.log(Math.max(...count));
