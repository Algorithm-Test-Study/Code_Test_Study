const fs = require('fs');
const [NM, ...input] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const [n, m] = NM.trim().split(' ').map(Number);
const city = input.map((x) => x.trim().split(' ').map(Number));

const house = [];
const chicken = [];
const answer = [];

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (city[i][j] === 1) {
      house.push([i, j]);
      continue;
    }

    if (city[i][j] === 2) {
      chicken.push([i, j]);
      continue;
    }
  }
}

const getCombinations = (arr, m) => {
  const result = [];
  if (m === 1) return arr.map((element) => [element]);

  arr.forEach((fiexd, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, m - 1);
    const attached = combinations.map((element) => [fiexd, ...element]);
    result.push(...attached);
  });

  return result;
};

const temp = getCombinations(chicken, m);

for (const chickenM of temp) {
  let distance = 0;
  house.forEach(([r1, c1]) => {
    distance += Math.min(
      ...chickenM.map(([r2, c2]) => Math.abs(r2 - r1) + Math.abs(c2 - c1))
    );
  });
  answer.push(distance);
}

console.log(Math.min(...answer));
