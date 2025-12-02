# [Silver II] N과 M (10) - 15664 

[문제 링크](https://www.acmicpc.net/problem/15664) 

### 성능 요약

메모리: 14340 KB, 시간: 100 ms

### 분류

백트래킹

### 제출 일자

2025년 12월 2일 23:11:08

### 문제 설명

<p style="user-select: auto !important;">N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.</p>

<ul style="user-select: auto !important;">
	<li style="user-select: auto !important;">N개의 자연수 중에서 M개를 고른 수열</li>
	<li style="user-select: auto !important;">고른 수열은 비내림차순이어야 한다.
	<ul style="user-select: auto !important;">
		<li style="user-select: auto !important;">길이가 K인 수열 A가 A<sub style="user-select: auto !important;">1</sub> ≤ A<sub style="user-select: auto !important;">2</sub> ≤ ... ≤ A<sub style="user-select: auto !important;">K-1</sub> ≤ A<sub style="user-select: auto !important;">K</sub>를 만족하면, 비내림차순이라고 한다.</li>
	</ul>
	</li>
</ul>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)</p>

<p style="user-select: auto !important;">둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p style="user-select: auto !important;">한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.</p>

<p style="user-select: auto !important;">수열은 사전 순으로 증가하는 순서로 출력해야 한다.</p>

