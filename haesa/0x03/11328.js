const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const n = Number(input[0]);
let answer = '';

function replaceCheck([str1, str2]) {
  const alpha1 = new Array(26).fill(0);
  const alpha2 = new Array(26).fill(0);
  for (let i = 0; i < str1.length; i++) alpha1[str1.charCodeAt(i) - 97]++;
  for (let i = 0; i < str2.length; i++) alpha2[str2.charCodeAt(i) - 97]++;
  console.log(alpha1);
  console.log(alpha2);
  for (let i = 0; i < 26; i++)
    if (alpha1[i] !== alpha2[i]) return 'Impossible ';
  return 'Possible ';
}

for (let i = 1; i <= n; i++) {
  const str = input[i].trim().split(' ');
  answer += replaceCheck(str);
}
console.log(answer);
