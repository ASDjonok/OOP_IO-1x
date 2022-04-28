from operator import add, sub, mul, truediv, floordiv, mod
from sys import exit


# Class declaration
class Task:
    def __init__(self, var: int):
        # Constants
        self.c_2 = var % 2
        self.c_3 = var % 3
        self.c_5 = var % 5
        self.c_7 = var % 7

        # Functions
        # match case newly introduced in python 3.10
        match self.c_2:
            case 0:
                self.o_1 = add
            case _:
                self.o_1 = sub

        match self.c_5:
            case 0:
                self.o_2 = mul
            case 1:
                if self.c_7 in [5, 6]:
                    # Use true div if i and j are floating point type
                    self.o_2 = truediv
                else:
                    # Use floor div if i and j are integer type
                    self.o_2 = floordiv
            case 2:
                self.o_2 = mod
            case 3:
                self.o_2 = add
            case _:
                self.o_2 = sub

    def solve(self, a: int, b: int, n: int, m: int) -> float:
        # Use efficient list comprehension instead of for loops
        return sum(
            sum(self.o_2(i, j) / self.o_1(i, self.c_3) for j in range(b, m + 1))
            for i in range(a, n + 1)
        )


# Main method
if __name__ == "__main__":
    # Ticket number 1127
    task = Task(var=1127)
    try:
        solution = task.solve(
            a=int(input("a = ")),
            b=int(input("b = ")),
            n=int(input("n = ")),
            m=int(input("m = ")),
        )
    except ZeroDivisionError:
        solution = None
    except ValueError:
        print("\nError: Invalid input")
        exit()
    except KeyboardInterrupt:
        exit()

    print("Solution: ", solution)
