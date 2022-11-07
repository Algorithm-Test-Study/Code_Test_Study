const fs = require('fs');
const input = Number(fs.readFileSync('./input.txt').toString());
let score;

if (input >= 90 && input <= 100) score = 'A';
else if (input >= 80) score = 'B';
else if (input >= 70) score = 'C';
else if (input >= 60) score = 'D';
else score = 'F';
console.log(score);
