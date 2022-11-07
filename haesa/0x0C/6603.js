const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
input.pop();

const solution = (n, numbers) => {
  let result = '';

  const dfs = (v, pick) => {
    if (pick.length === 6) {
      result += `${pick.join(' ')}\n`;
      return;
    }

    for (let i = v; i < n; i++) {
      dfs(i + 1, [...pick, numbers[i]]);
    }
  };

  dfs(0, []);

  return result;
};

for (let i = 0; i < input.length; i++) {
  const [n, ...cur] = input[i].trim().split(' ').map(Number);
  console.log(solution(n, cur));
}
