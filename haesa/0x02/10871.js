const fs = require('fs');
const inputs = fs.readFileSync('./input.txt').toString().split('\n');

const x = Number(inputs[0].split(' ')[1]);
const arr = inputs[1].split(' ').map(Number);
const answer = arr.filter((num) => num < x);

console.log(answer.join(' '));
