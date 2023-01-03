# OOP.Assignment2

# Scenario 1 : Up to 10 lines in a single file

| 1000 Files |  10000 Files | 10 Files | 100 Files |                           |
|-----------:|-------------:|---------:|----------:|--------------------------:|
|     167 ms | 9 sec 478 ms |    86 ms |    152 ms |           getNumOfLines() |
|     228 ms | 1 sec 733 ms |    47 ms |     61 ms |    getNumOfLinesThreads() |
|     228 ms |  2 sec 90 ms |    47 ms |     55 ms | getNumOfLinesThreadPool() |
|     45309  |        4738  |     476  |       57  |               total lines |