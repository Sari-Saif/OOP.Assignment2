# OOP.Assignment2

# Scenario 1 : Up to 10 lines in a single file

| Files 10000  | Files 1000 | Files 100 |    Files 10 | function  |
|:-------------|:----------:|----------:|------------:|----------:|
| 9 sec 478 ms |   167 ms   |    152 ms |   86 ms     |getNumOfLines()           |
| 1 sec 733 ms |   228 ms   |     61 ms |   47 ms     |getNumOfLinesThreads()    |
| 2 sec 90 ms  |   228 ms   |     55 ms |   47 ms     |getNumOfLinesThreadPool() |