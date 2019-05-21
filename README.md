# java-coordinate
좌표계산기 미션을 진행하기 위한 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 좌표 계산기

### 입력

- 좌표 입력
  - 좌표정보는 괄호(",")로 둘러쌓여 있으며 쉼표(,)로 x,y값을 구분한다.
    - 예시 : `(10,10)`
  - 좌표 값을 두개 입력한 경우 좌표값과 좌표값 사이는'-'문자로 구분한다.
    - 예시 : `(10,10)-(24,22)`
  - 입력 범위를 초과시 에러문구 출력 후 다시 입력받는다.

### 기능

- 두점 사이 거리 계산
  - 직선인 경우는 두점 사이 거리를 계산한다.
  - 정상적인 좌표값을 입력한 경우, 해당좌표에 특수문자를 표시한다.