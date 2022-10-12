const fs = require('fs');
const [a, b] = fs.readFileSync('./input.txt').toString().split(' ').map(Number);
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(Math.floor(a / b));
console.log(a % b);
