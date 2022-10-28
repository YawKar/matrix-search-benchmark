# Реализации трёх алгоритмов

### Линейный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/LinearSearch.java#L8-L21

_Асимптотика:_ O(M+N), M x N

### Бинарный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/BinaryOnRowLinearOnColumnSearch.java#L5-L34

_Асимптотика:_ O(Mlog(N)), M x N

### Экспоненциальный + Бинарный
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/4dacc2592fbadad7553f94c5811a11c60d688ce6/src/main/java/dev/yawkar/algorithm/impl/ExpBinaryOnRowLinearOnColumnSearch.java#L5-L43

_Асимптотика:_ ~O(Mlog(N)), M x N

# Реализации двух генераций данных

### Alpha `matrix[i][j] = (N/M * i + j) * 2`
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/ade5e61ed2ded29ebb2068f9cd41a351266a4ea6/src/main/java/dev/yawkar/matrix/generator/AlphaGenerator.java#L8-L16

### Beta `matrix[i][j] = (N/M * i * j) * 2`
_Реализация:_
https://github.com/YawKar/matrix-search-benchmark/blob/ade5e61ed2ded29ebb2068f9cd41a351266a4ea6/src/main/java/dev/yawkar/matrix/generator/BetaGenerator.java#L8-L16

# Полученные замеры
Замеры производились с помощью Java Microbenchmark Harness: https://github.com/openjdk/jmh

https://github.com/YawKar/matrix-search-benchmark/blob/fe2b4cce473d210c4d585b3f5a63a228ee822d6b/sample_results.txt#L1-L79

# Визуализация

## Производительность на матрицах AlphaGenerator (Linear)
![AlphaMatrices](https://github.com/YawKar/matrix-search-benchmark/raw/master/AlphaMatrices.png)

## Производительность на матрицах AlphaGenerator (SemiLog)
![AlphaMatricesSemiLog](https://github.com/YawKar/matrix-search-benchmark/raw/master/AlphaMatricesSemiLog.png)

## Производительность на матрицах BetaGenerator (Linear)
![BetaMatrices](https://github.com/YawKar/matrix-search-benchmark/raw/master/BetaMatrices.png)

## Производительность на матрицах BetaGenerator (SemiLog)
![BetaMatricesSemiLog](https://github.com/YawKar/matrix-search-benchmark/raw/master/BetaMatricesSemiLog.png)

# Выводы

- Во всех тестовых случаях линейный алгоритм, ожидаемо, работает быстрее, за исключением лишь тестов матриц `2x8192, ..., 1024x8192`,
сгенерированных BetaGenerator (`matrix[i][j] = (N/M * i * j) * 2`)
  - Почему быстрее в большинстве случаев: у него минимальная константа и сама асимптотика в `log` раз меньше
  - Почему медленнее на вышеуказанных Beta матрицах: так как `target = const = 16*N + 1 = 16 * 8192 + 1 = 131073` и числа, 
близкие к нему, находятся практически в начале второй строчки уже в матрице `2x8192`, не говоря уже и о больших. Бинарный и экспоненциальный
поиски быстрее приходят к началу, а линейный ещё должен успеть обойти `~8000` элементов, чтобы только дойти до начала второй строки
- На Alpha матрицах бинарный и экспоненциальный идут рука об руку вплоть до матрицы `4096x8192`, на которой ситуация резко меняется. 
Бинарный начинает работать сильно хуже, чем экспоненциальный.
  - Почему так: всё просто - экспоненциальный растёт с этого момента уже только за счёт линейного спуска вниз, т.е. сам экспоненциальный
поиск закончился, дальше все идёт линейно вниз (либо вырождается в бинарный на малых масштабах, см. реализацию экспоненциального+бинарного). 
А вот бинарный начинает буксовать, потому что постоянно двигается влево на 1, но тратя на это `log(префикс текущей строки)` операций, а спускается
всё так же, как это делает эксп+бин