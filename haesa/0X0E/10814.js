const fs = require('fs');
const [n, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

input.sort((a, b) => {
  const [aAge] = a.split(' ').map(Number);
  const [bAge] = b.split(' ').map(Number);
  return aAge - bAge;
});
console.log(input.join('\n'));
