from dataclasses import dataclass

# C11 = 5 -> Визначити клас одяг, який складається
#            як мінімум з 5-и полів.


@dataclass(init=True, frozen=True)
class Clothes:
    name: str
    brand: str
    gender: str
    price: float
    quantity: int

    def __repr__(self) -> str:
        return "name:   {}\nbrand:  {}\ngender: {}\nprice:  {}$\nquant.: {}".format(
            self.name, self.brand, self.gender, self.price, self.quantity
        )


class Task:
    def __init__(self, ls: list[Clothes]) -> None:
        self.clothes_unsorted = ls
        self.clothes_asc = sorted(
            self.clothes_unsorted, key=lambda x: x.price, reverse=False
        )
        self.clothes_desc = sorted(
            self.clothes_unsorted, key=lambda x: x.quantity, reverse=True
        )


if __name__ == "__main__":
    arr = map(
        lambda x: Clothes(*x),
        (
            ("Turtleneck", "Prada", "F", 1038, 834),
            ("Rat underwear (limited edition)", "Gucci", "F", 9999.99, 42),
            ("Socks", "Balenciaga", "M", 210, 4132),
            ("Sneakers", "Adidas", "*", 250, 964127),
        ),
    )
    task = Task(list(arr))

    print("Sorted by price, ascending")
    for x in task.clothes_asc:
        print(x, "\n")
    print("Sorted by quantity, descending")
    for x in task.clothes_desc:
        print(x, "\n")
