const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const [n, k] = input.shift().split(' ').map(Number);
const list = input.map((x) => x.split(' ').map(Number));
const students = new Array(6).fill(0).map((x) => [0, 0]);
let answer = 0;
for (let i = 0; i < list.length; i++) {
  const [s, y] = list[i];
  students[y - 1][s]++;
}
for (let i = 0; i < students.length; i++) {
  answer += Math.ceil(students[i][0] / k);
  answer += Math.ceil(students[i][1] / k);
}
console.log(answer);
