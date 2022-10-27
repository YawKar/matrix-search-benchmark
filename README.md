# Реализации трёх алгоритмов

### Линейный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/LinearSearch.java#L8-L21

_Асимптотика:_ O(N+M)

### Бинарный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/BinaryOnRowLinearOnColumnSearch.java#L5-L34

_Асимптотика:_ O(Nlog(M))

### Экспоненциальный + Бинарный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/ExpBinaryOnRowLinearOnColumnSearch.java#L5-L43

_Асимптотика:_ ~O(Nlog(M))

# Реализации двух генераций данных

### Alpha `matrix[i][j] = (N/M * i + j) * 2`
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/matrix/generator/AlphaGenerator.java#L8-L16

### Beta `matrix[i][j] = (N/M * i * j) * 2`
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/matrix/generator/BetaGenerator.java#L8-L16

# Визуализация

## Производительность на матрицах AlphaGenerator
![graph1](https://github.com/YawKar/matrix-search-benchmark/raw/4dacc2592fbadad7553f94c5811a11c60d688ce6/AlphaMatrices.png)

## Производительность на матрицах BetaGenerator
![graph1](https://github.com/YawKar/matrix-search-benchmark/raw/4dacc2592fbadad7553f94c5811a11c60d688ce6/BetaMatrices.png)

