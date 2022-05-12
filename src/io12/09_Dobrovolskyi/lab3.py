# C3 = 1210 % 3 = 1 - тип: StringBuffer
# C17 = 1210 % 17 = 3 - В усіх питальних реченнях заданого тексту
# знайти та надрукувати без повторень слова заданої довжини.
import re


class Target:
    @staticmethod
    def vikonavchiymethod():
        text_in = open('2.txt').read()
        # text_in = input('input text: ')

        ###############################################################################

        alphabets = "([A-Za-z])"
        prefixes = "(Mr|St|Mrs|Ms|Dr)[.]"
        suffixes = "(Inc|Ltd|Jr|Sr|Co)"
        starters = "(Mr|Mrs|Ms|Dr|He\s|She\s|It\s|They\s|Their\s|Our\s|We\s|But\s|However\s|That\s|This\s|Wherever)"
        acronyms = "([A-Z][.][A-Z][.](?:[A-Z][.])?)"
        websites = "[.](com|net|org|io|gov)"

        def split_into_sentences(text):
            text = " " + text + "  "
            text = text.replace("\n", " ")
            text = re.sub(prefixes, "\\1<prd>", text)
            text = re.sub(websites, "<prd>\\1", text)
            if "Ph.D" in text:
                text = text.replace("Ph.D.", "Ph<prd>D<prd>")
            text = re.sub("\s" + alphabets + "[.] ", " \\1<prd> ", text)
            text = re.sub(acronyms + " " + starters, "\\1<stop> \\2", text)
            text = re.sub(alphabets + "[.]" + alphabets + "[.]" + alphabets + "[.]", "\\1<prd>\\2<prd>\\3<prd>", text)
            text = re.sub(alphabets + "[.]" + alphabets + "[.]", "\\1<prd>\\2<prd>", text)
            text = re.sub(" " + suffixes + "[.] " + starters, " \\1<stop> \\2", text)
            text = re.sub(" " + suffixes + "[.]", " \\1<prd>", text)
            text = re.sub(" " + alphabets + "[.]", " \\1<prd>", text)
            if "”" in text:
                text = text.replace(".”", "”.")
            if "\"" in text:
                text = text.replace(".\"", "\".")
            if "!" in text:
                text = text.replace("!\"", "\"!")
            if "?" in text:
                text = text.replace("?\"", "\"?")
            text = text.replace(".", ".<stop>")
            text = text.replace("?", " ?<stop>")
            text = text.replace("!", "!<stop>")
            text = text.replace("<prd>", ".")
            sentences = text.split("<stop>")
            sentences = sentences[:-1]
            sentences = [s.strip() for s in sentences]
            return sentences

        ################################################################################
        text_in = text_in.replace('“', '')
        text_in = text_in.replace('”', '')
        text_in = text_in.replace(',', '')
        text_in = text_in.replace(':', '')
        text_in = text_in.replace(';', '')
        sentences = split_into_sentences(text_in)
        q_Sentences = []
        for i in sentences:
            if i[-1] == '?':
                q_Sentences.append(i)
        print('interrogative sentences: ')
        for i in q_Sentences:
            print(i)
        print('')
        while True:
            try:
                n = int(input('word length = '))
                break
            except:
                print('you have to input integer number, try again')
        print('')
        words_In_q = []
        answer = []
        for i in q_Sentences:
            words_In_q.append(i.split())
        for i in words_In_q:
            for j in i:
                if len(j) == n:
                    answer.append(j)
        print('words with length = ' + str(n) + ':')
        answer = set(answer)
        for i in answer:
            print(i)
        if answer == []:
            print('there is no words with such length')


Target.vikonavchiymethod()
