const fs = require('fs');
const [str1, str2] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n')
  .map((x) => x.trim());

function replaceCheck(str1, str2) {
  const alpha1 = new Array(26).fill(0);
  const alpha2 = new Array(26).fill(0);
  let count = 0;
  for (let i = 0; i < str1.length; i++) alpha1[str1.charCodeAt(i) - 97]++;
  for (let i = 0; i < str2.length; i++) alpha2[str2.charCodeAt(i) - 97]++;

  for (let i = 0; i < 26; i++) {
    if (alpha1[i] === alpha2[i]) continue;
    count += Math.abs(alpha1[i] - alpha2[i]);
  }
  return count;
}
console.log(replaceCheck(str1, str2));
