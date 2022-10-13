const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());
let answer = 0;

if (input % 4 === 0) if (input % 100 !== 0 || input % 400 === 0) answer = 1;
console.log(answer);
