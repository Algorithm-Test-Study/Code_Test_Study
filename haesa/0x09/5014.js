const fs = require('fs');
const [F, S, G, U, D] = fs
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split(' ')
  .map(Number);

const visit = new Array(F + 1).fill(false);
const d = [U, D * -1];
let flag = false;

function invalidRange(floor) {
  return floor < 1 || floor > F;
}

function isVisit(floor) {
  return visit[floor];
}

function bfs(start) {
  const queue = [[start, 0]];
  let answer = 0;
  visit[start] = true;

  while (queue.length !== 0) {
    const [currentFloor, count] = queue.shift();

    if (currentFloor === G) {
      answer = count;
      flag = true;
      break;
    }

    for (let i = 0; i < 2; i++) {
      const nextFloor = currentFloor + d[i];

      if (invalidRange(nextFloor) || isVisit(nextFloor)) continue;

      queue.push([nextFloor, count + 1]);
      visit[nextFloor] = true;
    }
  }

  return answer;
}

const value = bfs(S);
const answer = flag ? value : 'use the stairs';
console.log(answer);
