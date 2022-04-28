# C3  = 2 -> String
# C17 = 5 -> Надрукувати слова без повторень заданого тексту
#            в алфавітному порядку за першою літерою.


class Task:
    def __init__(self, txt: str) -> None:
        self.words = (w.strip(",.;:") for w in txt.split())

    def solve(self) -> None:
        for s in sorted(
            filter(lambda a: len(set(a.lower())) == len(a), self.words),
            key=lambda c: c[0].lower(),
            reverse=False,
        ):
            print(s)


if __name__ == "__main__":
    with open("test_text_1.txt", "r", encoding="utf8") as text:
        task = Task(text.read())
        task.solve()
