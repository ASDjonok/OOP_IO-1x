from dataclasses import dataclass

# C3  = 2 -> String
# C17 = 5 -> Надрукувати слова без повторень заданого тексту
#            в алфавітному порядку за першою літерою.


@dataclass
class Char:
    val: str

    def __init__(self, char: str) -> None:
        self.val = char[0]

    def __str__(self) -> str:
        return self.val


@dataclass
class Word:
    val: list[Char]

    def __hash__(self) -> int:
        return hash(str(self))

    def __str__(self) -> str:
        return "".join(map(str, self.val))


@dataclass
class Punctuation:
    val: str

    def __str__(self) -> str:
        return self.val


SentenceComponent = Word | Punctuation


@dataclass
class Sentence:
    val: list[SentenceComponent]

    def __str__(self) -> str:
        return " ".join(map(str, self.val))


@dataclass
class Text:
    val: list[Sentence]

    def __str__(self) -> str:
        return " ".join(map(str, self.val))


def totext(txt: str) -> Text:
    buff_sentence = []
    buff_component = []
    buff_word = []
    for w in txt.split():
        for c in w:
            if c in ',:;".!?':
                if len(buff_word) != 0:
                    buff_component.append(Word(buff_word))
                    buff_word = []
                buff_component.append(Punctuation(c))
                if c in ".!?":
                    buff_sentence.append(Sentence(buff_component))
                    buff_component = []
            else:
                buff_word.append(Char(c))
        if len(buff_word) != 0:
            buff_component.append(Word(buff_word))
            buff_word = []
    return Text(buff_sentence)


class Task:
    def __init__(self, txt: Text) -> None:
        sentence_components: list[SentenceComponent] = []
        for i in map(lambda x: x.val, txt.val):
            for j in i:
                sentence_components.append(j)
        self.words = filter(lambda x: isinstance(x, Word), sentence_components)

    def solve(self) -> None:
        for s in sorted(
            # filter(lambda x: len(set(str(x).lower())) == len(str(x)), self.words),
            set(self.words),
            key=lambda c: str(c.val[0]).lower(),
            reverse=False,
        ):
            print(s)


if __name__ == "__main__":
    with open("test_text_1.txt", "r", encoding="utf8") as text:
        task = Task(totext(text.read()))
        task.solve()
