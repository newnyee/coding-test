# Day4 - 자료구조

## 📌스택과 큐
배열에서 발전된 형태의 자료구조

### 스택(Stack)
- 데이터의 삽입과 삭제 연산이 후입선출(Last-in First-out, LIFO)로 이루어지는 자료구조
- 깊이 우선 탐색(Depth First Search, DFS), 백트래킹 종류의 코딩 테스트에 효과적으로 사용됨
- 위치
  - top : 삽입과 삭제가 일어나는 위치
- 연산
  - push : top 위치에 새로운 데이터를 삽입하는 연산
  - pop : top 위치에 있는 데이터를 삭제하고 확인하는 연산
  - peek : top 위치에 있는 데이터를 단순 확인하는 연산
  
### 큐(Queue)
- 데이터의 삽입과 삭제 연산이 선입선출(First-in First-out, FIFO)로 이루어지는 자료구조
- 너비 우선 탐색(Breadth Fist Search, BFS)에서 자주 사용됨
- 영역
  - rear : 큐에서 가장 끝 데이터를 가리키는 영역 (새 값이 들어오는 영역)
  - front : 큐에서 가장 앞의 데이터를 가리키는 영역 (값이 나가는 영역)
- 연산
  - add : rear 영역에 새로운 데이터를 삽입하는 연산
  - poll : front 영역에 있는 데이터를 삭제하고 확인하는 연산
  - peek : front 영역에 있는 데이터를 단순 확인하는 연산