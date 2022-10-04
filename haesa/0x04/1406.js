// const fs = require('fs');
// const [str, n, ...cmd] = fs
//   .readFileSync('/dev/stdin')
//   .toString()
//   .trim()
//   .split('\n');

// const command = cmd.map((line) => line.trim().split(' '));
// const leftStack = str.trim().split('');
// const rightStack = [];

// for (const line of command) {
//   switch (line[0]) {
//     case 'L':
//       leftStack.length != 0 && rightStack.push(leftStack.pop());
//       break;
//     case 'D':
//       rightStack.length != 0 && leftStack.push(rightStack.pop());
//       break;
//     case 'B':
//       leftStack.length != 0 && leftStack.pop();
//       break;
//     case 'P':
//       leftStack.push(line[1]);
//       break;
//   }
// }
// console.log(leftStack.join('') + rightStack.reverse().join(''));

const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');

const leftStack = [...input[0].trim()];
const rightStack = [];

for (let i = 2; i < input.length; i++) {
  if (input[i][0] == 'L')
    leftStack.length != 0 && rightStack.push(leftStack.pop());
  else if (input[i][0] == 'D')
    rightStack.length != 0 && leftStack.push(rightStack.pop());
  else if (input[i][0] == 'B') leftStack.pop();
  else if (input[i][0] == 'P') leftStack.push(input[i][2]);
}

console.log(leftStack.join('') + rightStack.reverse().join(''));
