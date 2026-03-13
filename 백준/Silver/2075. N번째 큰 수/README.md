# [Silver III] N번째 큰 수 - 2075 

[문제 링크](https://www.acmicpc.net/problem/2075) 

### 성능 요약

메모리: 298164 KB, 시간: 952 ms

### 분류

자료 구조, 정렬, 우선순위 큐

### 제출 일자

2026년 3월 13일 17:47:58

### 문제 설명

<p style="user-select: auto !important;">N×N의 표에 수 N<sup style="user-select: auto !important;">2</sup>개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다. N=5일 때의 예를 보자.</p>

<table class="table table-bordered" style="width: 15%; user-select: auto !important;">
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<td style="width: 3%; user-select: auto !important;">12</td>
			<td style="width: 3%; user-select: auto !important;">7</td>
			<td style="width: 3%; user-select: auto !important;">9</td>
			<td style="width: 3%; user-select: auto !important;">15</td>
			<td style="width: 3%; user-select: auto !important;">5</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">13</td>
			<td style="user-select: auto !important;">8</td>
			<td style="user-select: auto !important;">11</td>
			<td style="user-select: auto !important;">19</td>
			<td style="user-select: auto !important;">6</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">21</td>
			<td style="user-select: auto !important;">10</td>
			<td style="user-select: auto !important;">26</td>
			<td style="user-select: auto !important;">31</td>
			<td style="user-select: auto !important;">16</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">48</td>
			<td style="user-select: auto !important;">14</td>
			<td style="user-select: auto !important;">28</td>
			<td style="user-select: auto !important;">35</td>
			<td style="user-select: auto !important;">25</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">52</td>
			<td style="user-select: auto !important;">20</td>
			<td style="user-select: auto !important;">32</td>
			<td style="user-select: auto !important;">41</td>
			<td style="user-select: auto !important;">49</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.</p>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 N(1 ≤ N ≤ 1,500)이 주어진다. 다음 N개의 줄에는 각 줄마다 N개의 수가 주어진다. 표에 적힌 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.</p>

### 출력 

 <p style="user-select: auto !important;">첫째 줄에 N번째 큰 수를 출력한다.</p>

