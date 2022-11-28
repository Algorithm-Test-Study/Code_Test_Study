const fs = require('fs');
const [n, ...arr] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');
const names = [];

arr
  .map((v) => v.split(' ').map((vv) => Number(vv) || vv))
  .sort((a, b) => {
    const aScore = (100 - a[1]) * 10 ** 6 + a[2] * 10 ** 3 + (100 - a[3]);
    const bScore = (100 - b[1]) * 10 ** 6 + b[2] * 10 ** 3 + (100 - b[3]);
    if (aScore === bScore) {
      if (a[0] > b[0]) return 1;
      else if (a[0] < b[0]) return -1;
      else return 0;
    } else {
      return aScore - bScore;
    }
  })
  .forEach((v) => names.push(v[0]));
console.log(names.join('\n'));
