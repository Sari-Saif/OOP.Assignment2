# OOP.Assignment2

# Scenario 1 : Up to 10 lines in a single file
`Ex2_1.createTextFiles(NUM_OF_FILES_4, 1, 10);`

| 10000 Files | 1000 Files | 100 Files |      10 Files |                                |
|------------:|-----------:|----------:|--------------:|-------------------------------:|
| 9 sec 478 ms|     167 ms |    152 ms |   86 ms |                getNumOfLines() |
| 1 sec 733 ms|     228 ms |     61 ms |   47 ms |         getNumOfLinesThreads() |
|  2 sec 90 ms|     228 ms |     55 ms |   47 ms |      getNumOfLinesThreadPool() |
|  45309      |       4738 |       476 |      57 |                    total lines |


# Scenario 2 : Up to 100 lines in a single file
`Ex2_1.createTextFiles(NUM_OF_FILES_4, 1, 100);`

|   10000 Files |   1000 Files | 100 Files | 10 Files |                                |
|--------------:|-------------:|----------:|---------:|-------------------------------:|
| 13 sec 709 ms | 1 sec 601 ms |    448 ms |    95 ms |                getNumOfLines() |
|  1 sec 632 ms |       255 ms |     78 ms |    48 ms |         getNumOfLinesThreads() |
|    2 sec 8 ms |       210 ms |     65 ms |    48 ms |      getNumOfLinesThreadPool() |
|        499039 |        50698 |      4956 |      457 |                    total lines |