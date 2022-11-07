const fs = require('fs');
const input = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map((x) => x.split(' ').map(Number));

const card = new Array(20).fill().map((_, i) => i + 1);

for (let i = 0; i < input.length; i++) {
  const [a, b] = input[i];
  card.splice(a - 1, b - a + 1, ...card.slice(a - 1, b).reverse());
}
console.log(card.join(' '));
