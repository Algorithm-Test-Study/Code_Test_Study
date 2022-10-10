const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [m, n, h] = input.shift().split(' ').map(Number);
const map = [];
let temp = [];
for (let i = 0; i < h; i++) {
  for (let j = 0; j < n; j++)
    temp.push(...input.shift().split(' ').map(Number));
  map.push(temp);
  temp = [];
}

const dh = [1, -1, 0, 0, 0, 0];
const dx = [0, 0, -1, 1, 0, 0];
const dy = [0, 0, 0, 0, -1, 1];

let leftTomato = 0;

class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class Queue {
  constructor() {
    this.head = new Node([]);
    this.tail = this.head;
    this.size = 0;
  }

  push(data) {
    const node = new Node(data);
    this.tail.next = node;
    this.tail = node;
    this.size++;
  }

  shift() {
    if (this.size === 0) return;
    const node = this.head.next;
    if (node === this.tail) this.tail = this.head;
    this.head.next = node.next;
    this.size--;
    return node.data;
  }

  getSize() {
    return this.size;
  }
}

const queue = new Queue();

function isRange(k, x, y) {
  return k >= 0 && k < h && x >= 0 && x < n && y >= 0 && y < m;
}

function bfs() {
  let day = 0;
  while (queue.getSize()) {
    const [h, x, y, d] = queue.shift();
    day = d;
    for (let k = 0; k < 6; k++) {
      const nh = h + dh[k];
      const nx = x + dx[k];
      const ny = y + dy[k];
      if (!isRange(nh, nx, ny) || map[nh][nx * m + ny] !== 0) continue;
      queue.push([nh, nx, ny, d + 1]);
      map[nh][nx * m + ny] = 1;
      leftTomato--;
    }
  }
  return leftTomato === 0 ? day : -1;
}

function solution() {
  for (let k = 0; k < h; k++) {
    for (let i = 0; i < n; i++)
      for (let j = 0; j < m; j++) {
        if (map[k][i * m + j] === 1) queue.push([k, i, j, 0]);
        else if (map[k][i * m + j] === 0) leftTomato++;
      }
  }
  console.log(leftTomato === 0 ? 0 : bfs());
}
solution();
