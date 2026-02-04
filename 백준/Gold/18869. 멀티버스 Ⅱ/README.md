# [Gold V] 멀티버스 Ⅱ - 18869 

[문제 링크](https://www.acmicpc.net/problem/18869) 

### 성능 요약

메모리: 194140 KB, 시간: 1136 ms

### 분류

정렬, 값 / 좌표 압축

### 제출 일자

2026년 2월 4일 20:59:23

### 문제 설명

<p style="user-select: auto !important;">M개의 우주가 있고, 각 우주에는 1부터 N까지 번호가 매겨진 행성이 N개 있다. 행성의 크기를 알고 있을때, 균등한 우주의 쌍이 몇 개인지 구해보려고 한다. 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 센다.</p>

<p style="user-select: auto !important;">두 우주 A와 B가 있고, 우주 A에 있는 행성의 크기는 A<sub style="user-select: auto !important;">1</sub>, A<sub style="user-select: auto !important;">2</sub>, ..., A<sub style="user-select: auto !important;">N</sub>, 우주 B에 있는 행성의 크기는 B<sub style="user-select: auto !important;">1</sub>, B<sub style="user-select: auto !important;">2</sub>, ..., B<sub style="user-select: auto !important;">N</sub>라고 하자. 두 우주의 행성 크기가 모든 1 ≤ i, j ≤ N에 대해서 아래와 같은 조건을 만족한다면, 두 우주를 균등하다고 한다.</p>

<ul style="user-select: auto !important;">
	<li style="user-select: auto !important;">A<sub style="user-select: auto !important;">i</sub> < A<sub style="user-select: auto !important;">j</sub> → B<sub style="user-select: auto !important;">i</sub> < B<sub style="user-select: auto !important;">j</sub></li>
	<li style="user-select: auto !important;">A<sub style="user-select: auto !important;">i</sub> = A<sub style="user-select: auto !important;">j</sub> → B<sub style="user-select: auto !important;">i</sub> = B<sub style="user-select: auto !important;">j</sub></li>
	<li style="user-select: auto !important;">A<sub style="user-select: auto !important;">i</sub> > A<sub style="user-select: auto !important;">j</sub> → B<sub style="user-select: auto !important;">i</sub> > B<sub style="user-select: auto !important;">j</sub></li>
</ul>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 우주의 개수 M과 각 우주에 있는 행성의 개수 N이 주어진다. 둘째 줄부터 M개의 줄에 공백으로 구분된 행성의 크기가 한 줄에 하나씩 1번 우주부터 차례대로 주어진다.</p>

### 출력 

 <p style="user-select: auto !important;">첫째 줄에 균등한 우주의 쌍의 개수를 출력한다.</p>

