const input = require('fs')
  .readFileSync('./input.txt')
  .toString()
  .trim()
  .split('\n');

const n = Number(input.shift());

const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

let visit;

let h, w;

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

let fireQ;
let escapeQ;

function isRange(x, y) {
  return x >= 0 && x < h && y >= 0 && y < w;
}

function bfs() {
  while (fireQ.getSize() || escapeQ.getSize()) {
    for (let i = fireQ.getSize(); i > 0; i--) {
      const [x, y] = fireQ.shift();
      for (let i = 0; i < 4; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];
        if (!isRange(nx, ny) || visit[nx][ny] === 1) continue;
        fireQ.push([nx, ny]);
        visit[nx][ny] = 1;
      }
    }

    for (let i = escapeQ.getSize(); i > 0; i--) {
      const [x, y, d] = escapeQ.shift();
      for (let i = 0; i < 4; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];
        if (!isRange(nx, ny)) return d + 1;
        if (visit[nx][ny]) continue;
        escapeQ.push([nx, ny, d + 1]);
        visit[nx][ny] = 2;
      }
    }
  }
  return 'IMPOSSIBLE';
}

function soluition() {
  const answer = [];

  for (let t = 0; t < n; t++) {
    fireQ = new Queue();
    escapeQ = new Queue();
    [w, h] = input.shift().split(' ').map(Number);

    const map = [];
    for (let i = 0; i < h; i++) map.push(input.shift().trim().split(''));

    visit = new Array(h);
    for (let i = 0; i < h; i++) visit[i] = Array.from({ length: w }, () => 0);

    for (let i = 0; i < h; i++) {
      for (let j = 0; j < w; j++) {
        if (map[i][j] === '*') {
          fireQ.push([i, j, 0]);
          visit[i][j] = 1;
        } else if (map[i][j] === '@') {
          escapeQ.push([i, j, 0]);
          visit[i][j] = 2;
        } else if (map[i][j] === '#') visit[i][j] = 1;
      }
    }
    answer.push(bfs());
  }
  console.log(answer.join(' '));
}
soluition();

/** 불과 사람을 큐에 다 넣는 방법도 있음!
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf-8').toString().trim().split('\n');

class Node {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  enqueue(value) {
    this.length++;
    if (this.length === 1) {
      this.head = this.tail = new Node(value);
      return;
    }

    const newNode = new Node(value);
    this.tail.next = newNode;
    this.tail = newNode;
  }

  dequeue() {
    this.length--;
    const value = this.head.value;

    if (this.length === 0) {
      this.head = this.tail = null;
      return value;
    }

    this.head = this.head.next;
    return value;
  }
}

function solution(w, h, building) {
  const isOutOfRange = (r, c) => r < 0 || r >= h || c < 0 || c >= w;
  const dr = [1, -1, 0, 0];
  const dc = [0, 0, 1, -1];
  const queue = new Queue();
  for (let r = 0; r < h; r++) {
    for (let c = 0; c < w; c++) {
      if (building[r][c] === '*') queue.enqueue([r, c, -1]);
    }
  }

  for (let r = 0; r < h; r++) {
    for (let c = 0; c < w; c++) {
      if (building[r][c] === '@') {
        queue.enqueue([r, c, 0]);
        break;
      }
    }
  }

  while (queue.length > 0) {
    const [r, c, time] = queue.dequeue();
    for (let i = 0; i < 4; i++) {
      const [nr, nc] = [r + dr[i], c + dc[i]];
      if (isOutOfRange(nr, nc)) {
        if (time < 0) continue;
        return time + 1;
      }
      if (building[nr][nc] !== '.') continue;
      building[nr][nc] = '#';
      queue.enqueue([nr, nc, time < 0 ? -1 : time + 1]);
    }
  }

  return 'IMPOSSIBLE';
}

let TC = Number(input[0]);
let i = 1;
while (TC-- > 0) {
  const [w, h] = input[i++].split(' ').map(Number);
  console.log(solution(w, h, input.slice(i, i + h).map(v => v.split(''))));
  i += h;
}
 */
