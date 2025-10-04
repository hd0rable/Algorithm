# [Bronze II] 카드 역배치 - 10804 

[문제 링크](https://www.acmicpc.net/problem/10804) 

### 성능 요약

메모리: 14348 KB, 시간: 112 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 10월 4일 22:27:16

### 문제 설명

<p style="user-select: auto !important;">1부터 20까지 숫자가 하나씩 쓰인 20장의 카드가 아래 그림과 같이 오름차순으로 한 줄로 놓여있다. 각 카드의 위치는 카드 위에 적힌 숫자와 같이 1부터 20까지로 나타낸다. </p>

<table class="table table-bordered" style="user-select: auto !important;">
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;"> </th>
			<th style="user-select: auto !important;">1</th>
			<th style="user-select: auto !important;">2</th>
			<th style="user-select: auto !important;">3</th>
			<th style="user-select: auto !important;">4</th>
			<th style="user-select: auto !important;">5</th>
			<th style="user-select: auto !important;">6</th>
			<th style="user-select: auto !important;">7</th>
			<th style="user-select: auto !important;">8</th>
			<th style="user-select: auto !important;">9</th>
			<th style="user-select: auto !important;">10</th>
			<th style="user-select: auto !important;">11</th>
			<th style="user-select: auto !important;">12</th>
			<th style="user-select: auto !important;">13</th>
			<th style="user-select: auto !important;">14</th>
			<th style="user-select: auto !important;">15</th>
			<th style="user-select: auto !important;">16</th>
			<th style="user-select: auto !important;">17</th>
			<th style="user-select: auto !important;">18</th>
			<th style="user-select: auto !important;">19</th>
			<th style="user-select: auto !important;">20</th>
		</tr>
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;">카드</th>
			<td style="user-select: auto !important;">1</td>
			<td style="user-select: auto !important;">2</td>
			<td style="user-select: auto !important;">3</td>
			<td style="user-select: auto !important;">4</td>
			<td style="user-select: auto !important;">5</td>
			<td style="user-select: auto !important;">6</td>
			<td style="user-select: auto !important;">7</td>
			<td style="user-select: auto !important;">8</td>
			<td style="user-select: auto !important;">9</td>
			<td style="user-select: auto !important;">10</td>
			<td style="user-select: auto !important;">11</td>
			<td style="user-select: auto !important;">12</td>
			<td style="user-select: auto !important;">13</td>
			<td style="user-select: auto !important;">14</td>
			<td style="user-select: auto !important;">15</td>
			<td style="user-select: auto !important;">16</td>
			<td style="user-select: auto !important;">17</td>
			<td style="user-select: auto !important;">18</td>
			<td style="user-select: auto !important;">19</td>
			<td style="user-select: auto !important;">20</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">이제 여러분은 다음과 같은 규칙으로 카드의 위치를 바꾼다: 구간 [a, b] (단, 1 ≤ a ≤ b ≤ 20)가 주어지면 위치 a부터 위치 b까지의 카드를 현재의 역순으로 놓는다.</p>

<p style="user-select: auto !important;">예를 들어, 현재 카드가 놓인 순서가 위의 그림과 같고 구간이 [5, 10]으로 주어진다면, 위치 5부터 위치 10까지의 카드 5, 6, 7, 8, 9, 10을 역순으로 하여 10, 9, 8, 7, 6, 5로 놓는다. 이제 전체 카드가 놓인 순서는 아래 그림과 같다.</p>

<table class="table table-bordered" style="user-select: auto !important;">
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;"> </th>
			<th style="user-select: auto !important;">1</th>
			<th style="user-select: auto !important;">2</th>
			<th style="user-select: auto !important;">3</th>
			<th style="user-select: auto !important;">4</th>
			<th style="user-select: auto !important;">5</th>
			<th style="user-select: auto !important;">6</th>
			<th style="user-select: auto !important;">7</th>
			<th style="user-select: auto !important;">8</th>
			<th style="user-select: auto !important;">9</th>
			<th style="user-select: auto !important;">10</th>
			<th style="user-select: auto !important;">11</th>
			<th style="user-select: auto !important;">12</th>
			<th style="user-select: auto !important;">13</th>
			<th style="user-select: auto !important;">14</th>
			<th style="user-select: auto !important;">15</th>
			<th style="user-select: auto !important;">16</th>
			<th style="user-select: auto !important;">17</th>
			<th style="user-select: auto !important;">18</th>
			<th style="user-select: auto !important;">19</th>
			<th style="user-select: auto !important;">20</th>
		</tr>
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;">카드</th>
			<td style="user-select: auto !important;">1</td>
			<td style="user-select: auto !important;">2</td>
			<td style="user-select: auto !important;">3</td>
			<td style="user-select: auto !important;">4</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">10</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">9</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">8</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">7</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">6</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">5</td>
			<td style="user-select: auto !important;">11</td>
			<td style="user-select: auto !important;">12</td>
			<td style="user-select: auto !important;">13</td>
			<td style="user-select: auto !important;">14</td>
			<td style="user-select: auto !important;">15</td>
			<td style="user-select: auto !important;">16</td>
			<td style="user-select: auto !important;">17</td>
			<td style="user-select: auto !important;">18</td>
			<td style="user-select: auto !important;">19</td>
			<td style="user-select: auto !important;">20</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">이 상태에서 구간 [9, 13]이 다시 주어진다면, 위치 9부터 위치 13까지의 카드 6, 5, 11, 12, 13을 역순으로 하여 13, 12, 11, 5, 6으로 놓는다. 이제 전체 카드가 놓인 순서는 아래 그림과 같다.</p>

<table class="table table-bordered" style="user-select: auto !important;">
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;"> </th>
			<th style="user-select: auto !important;">1</th>
			<th style="user-select: auto !important;">2</th>
			<th style="user-select: auto !important;">3</th>
			<th style="user-select: auto !important;">4</th>
			<th style="user-select: auto !important;">5</th>
			<th style="user-select: auto !important;">6</th>
			<th style="user-select: auto !important;">7</th>
			<th style="user-select: auto !important;">8</th>
			<th style="user-select: auto !important;">9</th>
			<th style="user-select: auto !important;">10</th>
			<th style="user-select: auto !important;">11</th>
			<th style="user-select: auto !important;">12</th>
			<th style="user-select: auto !important;">13</th>
			<th style="user-select: auto !important;">14</th>
			<th style="user-select: auto !important;">15</th>
			<th style="user-select: auto !important;">16</th>
			<th style="user-select: auto !important;">17</th>
			<th style="user-select: auto !important;">18</th>
			<th style="user-select: auto !important;">19</th>
			<th style="user-select: auto !important;">20</th>
		</tr>
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;">카드</th>
			<td style="user-select: auto !important;">1</td>
			<td style="user-select: auto !important;">2</td>
			<td style="user-select: auto !important;">3</td>
			<td style="user-select: auto !important;">4</td>
			<td style="user-select: auto !important;">10</td>
			<td style="user-select: auto !important;">9</td>
			<td style="user-select: auto !important;">8</td>
			<td style="user-select: auto !important;">7</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">13</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">12</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">11</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">5</td>
			<td style="background-color: rgb(204, 204, 204); user-select: auto !important;">6</td>
			<td style="user-select: auto !important;">14</td>
			<td style="user-select: auto !important;">15</td>
			<td style="user-select: auto !important;">16</td>
			<td style="user-select: auto !important;">17</td>
			<td style="user-select: auto !important;">18</td>
			<td style="user-select: auto !important;">19</td>
			<td style="user-select: auto !important;">20</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">오름차순으로 한 줄로 놓여있는 20장의 카드에 대해 10개의 구간이 주어지면, 주어진 구간의 순서대로 위의 규칙에 따라 순서를 뒤집는 작업을 연속해서 처리한 뒤 마지막 카드들의 배치를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p style="user-select: auto !important;">총 10개의 줄에 걸쳐 한 줄에 하나씩 10개의 구간이 주어진다. i번째 줄에는 i번째 구간의 시작 위치 a<sub style="user-select: auto !important;">i</sub>와 끝 위치 b<sub style="user-select: auto !important;">i</sub>가 차례대로 주어진다. 이때 두 값의 범위는 1 ≤ a<sub style="user-select: auto !important;">i</sub> ≤ b<sub style="user-select: auto !important;">i</sub> ≤ 20이다.</p>

### 출력 

 <p style="user-select: auto !important;">1부터 20까지 오름차순으로 놓인 카드들에 대해, 입력으로 주어진 10개의 구간 순서대로 뒤집는 작업을 했을 때 마지막 카드들의 배치를 한 줄에 출력한다. </p>

