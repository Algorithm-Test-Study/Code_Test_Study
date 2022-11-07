const fs = require('fs');
const [a, b] = fs.readFileSync('./input.txt').toString().split(' ').map(Number);
console.log(a + b);
