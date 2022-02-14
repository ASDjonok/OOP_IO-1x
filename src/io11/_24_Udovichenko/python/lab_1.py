from operator import add, sub, mul, truediv, floordiv, mod
from sys import exit

# Class declaration
class Task:
    def __init__(self, var: int):
        # Constants
        self.var = var
        self.C2 = var % 2
        self.C3 = var % 3
        self.C5 = var % 5
        self.C7 = var % 7
        
        self.C = self.C3
        
        # Functions
        # match case newly introduced in python 3.10
        match self.C2:
            case 0: self.O1 = add
            case 1: self.O1 = sub
        
        match self.C5:
            case 0: self.O2 = mul
            case 1:
                if self.C7 in [5, 6]:
                    # Use true div if i and j are floating point type
                    self.O2 = truediv
                else:
                    # Use floor div if i and j are integer type
                    self.O2 = floordiv
            case 2: self.O2 = mod
            case 3: self.O2 = add
            case 4: self.O2 = sub

    def solve(self, a: int, b: int, n: int, m: int) -> float:
        # Use efficient list comprehension instead of for loops
        return sum( sum( self.O2(i, j) / self.O1(i, self.C) for j in range(b, m+1)) for i in range(a, n+1))


# Main method
if __name__ == "__main__":
    # Ticket number 1127
    task = Task(1127)
    try:
        sol = task.solve( a=int(input("a = "))
                        , b=int(input("b = "))
                        , n=int(input("n = "))
                        , m=int(input("m = "))
                        )
    except ZeroDivisionError:
        sol = None
    except ValueError:
        print("\nError: Invalid input")
        exit()
    except KeyboardInterrupt:
        exit()

    print("Solution: ", sol)

