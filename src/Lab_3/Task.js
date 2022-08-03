class Task {
    constructor(text) {
        this.text = text;
    }

    //Sort the words of the given text by increasing number of vowels
    sortByVowels() {
        let vowels = ['a', 'e', 'i', 'o', 'u', 'y'];
        let words = this.text.split(' ');
        let sortedWords = [];

        for (let i=0; i<words.length; i++) {
            if (vowels.includes(words[i].slice(0,1))) {
                sortedWords.push(words[i]);
            }
        }

        console.log(sortedWords);
        sortedWords.sort((a,b)=>(a[1] || a[0]).localeCompare(b[1] || b[0]))

        for (let i=0; i<sortedWords.length; i++) {
            sortedWords[i] = [i] + " " + sortedWords[i]
            sortedWords[i] += '<br>';
        }
        
        document.getElementById("result").innerHTML = sortedWords.join(' ');
    }
}