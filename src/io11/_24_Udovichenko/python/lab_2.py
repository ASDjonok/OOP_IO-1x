from itertools import cycle
from random import uniform
import numpy as np

# C5  = 2 -> C=A+B
# C7  = 0 -> double
# C11 = 5 -> Обчислити суму найбільших елементів в рядках матриці
#            з непарними номерами та найменших елементів в рядках
#            матриці з парними номерами


class Task:
    def __init__(self, a: list[list[float]], b: list[list[float]]) -> None:
        self.a, self.b = a, b

    def solve(self) -> float:
        C = [list(map(sum, zip(*c))) for c in zip(self.a, self.b)]
        print(C, sep=" ")
        return sum(fn(x) for x, fn in zip(C, cycle([max, min])))


if __name__ == "__main__":
    # Generate random matrice of doubles
    def random_matrice(x: int, y: int) -> list[list[float]]:
        return (
            np.array([round(uniform(-999, 9999), 6) for _ in range(x * y)])
            .reshape(x, y)
            .tolist()
        )

    A, B = random_matrice(2, 2), random_matrice(2, 2)
    print(A, B, sep="\n")

    task = Task(A, B)
    print(task.solve())
