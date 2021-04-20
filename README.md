# SumsOfDigitalFactorials
This is my solution for the Project Euler #254: Sums of Digit Factorials problem.


Define f(n) as the sum of the factorials of the digits of n. For example, f(342) = 3! + 4! + 2! = 32
Define sf(n) as the sum of the digits of f(n). For example, sf(342) = 3 + 2 = 5

We now try to find the smallest n that would also be 5 when put in sf(n). For example sf(f(25)) = 5
As proven above is g(5) = 25, we now take the sg(5) = 2 + 5 = 7
Define the sum of sg(i) where i is 1 to n. For example the sum of sg(5) = sg(1) = 1 + sg(2) = 2 + sg(3) = 5 + sg(4) = 6 + sg(5) = 7 = 21


Input format:
number of inputs 
input1 moduledividor
input2 moduledividor

Input format:
2
8 1000000
20 1000000
