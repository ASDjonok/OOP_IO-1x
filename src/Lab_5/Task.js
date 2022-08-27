class Task {
    constructor(text) {
        this.text = text;
    }

    //Sort the words of the given text by increasing number of vowels
    sortByVowels() {
        let vowels = new Word("aAeEiIoOuUyY");
        let txt = new Text(this.text);
        let words = txt.get().split(' ');
        let sortedWords = [];

        for (let word of words) {
            if (vowels.get().includes(word.slice(0,1))) {
                sortedWords.push(word);
            }
        }
        sortedWords.sort((a,b)=>(a[1] || a[0]).localeCompare(b[1] || b[0]))

        for (let i=0; i<sortedWords.length; i++) {
            sortedWords[i] = [i] + " " + sortedWords[i]
            sortedWords[i] += '<br>';
        }
        try {
            document.getElementById("result").innerHTML = sortedWords.join(' ');
        } catch (error) {
            console.log("error. element is not found!");
        }
    }
}


class Text {
    constructor(text) {
        this.text = text;
        let ArrOfSentences = [];
        let sentences = this.text.split('.');
        this.text = '';

        for (let sentence of sentences) {
            ArrOfSentences.push(new Sentence(sentence));
            this.text += sentence;
        }
        console.log(ArrOfSentences);
    }
    get() {
        return this.text;
    }
}

class Sentence {
    constructor(sentence) {
        this.sentence = sentence;
        this.words = [];
        let ArrOfWords = [];
        let words = this.sentence.split(' ');
        for (let word of words) {
            if (word != "") {
                ArrOfWords.push(new Word(word));
            }
        }
        console.log(ArrOfWords);
        this.words = ArrOfWords;
    }
    get() {
        return this.words;
    }
}
class Word {
    constructor(word) {
        this.word = word;
        let ArrOfChars = [];
        let chars = this.word.split('');
        for (let char of chars) {
            ArrOfChars.push(char);
        }
        console.log(ArrOfChars);
        this.word = ArrOfChars;
    }
    get() {
        return this.word;
    }
}