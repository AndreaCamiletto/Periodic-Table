# PeriodicTable

## Build and run
The application has been built and run using Intellij IDE.
I'm used to compile and run java applications using respectively the following instructions: 
+ javac ClassName.java
+ java ClassName

But I have never built or run a kotlin application from the command line.


##  ElementList.kt
I have divided the elements using the terminating character `\n`
Hence I have divided the fields of the elements (symbol, atomic number, group and period) using the blank spaces which separated them.
After these two operations, I was able to get the list of element.

## FrameDefaultImpl.kt
The FrameDefaultImpl class implements the Frame interface.
+ The variable `lines` contains a list of the strings which are passed creating FrameDefaultImpl object
+ The method `onTopOf(other:Frame): Frame` returns the arguments of the Frame with two blank characters before and after them, if its period is bigger than the Frame **"other"**
+ The method `atLeftOf(other:Frame): Frame` returns the arguments with blank lines before and after them, if its group is bigger than the Frame **"other"**
+ The method `toString(): String` returns the strings which are contained in `lines` list

## Main.kt
First of all I instantiated `hl` and `vl`, and then the empty Frame.
I created the elementFrame and elementBox methods.
Then I grouped the elements by period and I printed them to the console. When printing the complete table with the empty frames, I realized I had to center the elements' atomic number and symbol. This is why I created two functions:
+ `centeredStr` which adds blank spaces depending on how long is the String passed as argument
+ `centeredStr` which adds blank spaces depending on how big is the atomic number

### Final release
To complete the assignment, I created two methods to handle the elements 57, 58, 71, 89, 90 and 103:
+ `elementBoxAfterParticularElements` which is equals to the elementBox `function`, but `vl` is substituted with \ or / at the end of the string
+ `elementBoxBeforeParticularElements` which is equals to the elementBox `function`, but `vl` is substituted with \ or / at the beginning of the string

The final step was about fixing the duplicated lines.
I made a change in the elementBox functions, deleting the `vl` after the element's parameters.
This caused a problem with the alignment of all the boxes, I handled the situation by adding a space in case of empty column and a `vl` whether the current column is not null, but the next is empty, or the current column is the last one.
Running the application, the result is the following:
```
 -----                                                                                                 -----
|  1  |                                                                                               |  2  |
|  H  |                                                                                               |  He |
|     |                                                                                               |     |
 ----- -----                                                             ----- ----- ----- ----- ----- -----
|  3  |  4  |                                                           |  5  |  6  |  7  |  8  |  9  |  10 |
|  Li |  Be |                                                           |  B  |  C  |  N  |  O  |  F  |  Ne |
|     |     |                                                           |     |     |     |     |     |     |
 ----- -----                                                             ----- ----- ----- ----- ----- -----
|  11 |  12 |                                                           |  13 |  14 |  15 |  16 |  17 |  18 |
|  Na |  Mg |                                                           |  Al |  Si |  P  |  S  |  Cl |  Ar |
|     |     |                                                           |     |     |     |     |     |     |
 ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
|  19 |  20 |  21 |  22 |  23 |  24 |  25 |  26 |  27 |  28 |  29 |  30 |  31 |  32 |  33 |  34 |  35 |  36 |
|  K  |  Ca |  Sc |  Ti |  V  |  Cr |  Mn |  Fe |  Co |  Ni |  Cu |  Zn |  Ga |  Ge |  As |  Se |  Br |  Kr |
|     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
 ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
|  37 |  38 |  39 |  40 |  41 |  42 |  43 |  44 |  45 |  46 |  47 |  48 |  49 |  50 |  51 |  52 |  53 |  54 |
|  Rb |  Sr |  Y  |  Zr |  Nb |  Mo |  Tc |  Ru |  Rh |  Pd |  Ag |  Cd |  In |  Sn |  Sb |  Te |  I  |  Xe |
|     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
 ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
|  55 |  56 |  57 \  72 |  73 |  74 |  75 |  76 |  77 |  78 |  79 |  80 |  81 |  82 |  83 |  84 |  85 |  86 |
|  Cs |  Ba |  La /  Hf |  Ta |  W  |  Re |  Os |  Ir |  Pt |  Au |  Hg |  Tl |  Pb |  Bi |  Po |  At |  Rn |
|     |     |     \     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
 ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
|  87 |  88 |  89 \ 104 | 105 | 106 | 107 | 108 | 109 | 110 | 111 | 112 | 113 | 114 | 115 | 116 | 117 | 118 |
|  Fr |  Ra |  Ac /  Rf |  Db |  Sg |  Bh |  Hs |  Mt |  Ds |  Rg |  Cn |  Nh |  Fl |  Mc |  Lv |  Ts |  Og |
|     |     |     \     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
 ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----



                   ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
                  \  58 |  59 |  60 |  61 |  62 |  63 |  64 |  65 |  66 |  67 |  68 |  69 |  70 |  71 \
                  /  Ce |  Pr |  Nd |  Pm |  Sm |  Eu |  Gd |  Tb |  Dy |  Ho |  Er |  Tm |  Yb |  Lu /
                  \     |     |     |     |     |     |     |     |     |     |     |     |     |     \
                   ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
                  \  90 |  91 |  92 |  93 |  94 |  95 |  96 |  97 |  98 |  99 | 100 | 101 | 102 | 103 \
                  /  Th |  Pa |  U  |  Np |  Pu |  Am |  Cm |  Bk |  Cf |  Es |  Fm |  Md |  No |  Lr /
                  \     |     |     |     |     |     |     |     |     |     |     |     |     |     \
                   ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
                  

