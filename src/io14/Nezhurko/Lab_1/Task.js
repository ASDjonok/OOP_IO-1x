//main part
class Task {
    constructor(document_number) {
        this.document_number = document_number;
        this.i_j_index = Symbol;
        this.c = this.c;
        this.j = this.j;
        this.i = this.i;
        this.a = this.a;
        this.b = this.b;
        this.n = this.n;
        this.m = this.m;
    }


    getOperations() {
    // Step №1
    console.log("Your input: " + this.document_number);
    this.c = parseFloat(this.document_number % 3)
    console.log("c = " + this.c);

    // Step №2
    this.a = parseFloat(document.getElementById("a_input").value);
    this.b = parseFloat(document.getElementById("b_input").value);
    this.n = parseFloat(document.getElementById("n_input").value);
    this.m = parseFloat(document.getElementById("m_input").value);
    }

    calculate() {
        const c = this.c;

        if (this.a + c == 0) {
            this.S = "The divisor is less than zero. Try different input data.";
        } else {
            for(this.i = this.a; this.i <= this.n; this.i++) {
                for(this.j = this.b; this.j <= this.m; this.j++) {
                    var S = (this.i + this.j) / (this.i + c);
                }
            }

            console.log(S);
            console.log("a = "+this.a, "b = "+this.b, "c = "+this.c, "i = "+this.i, "j = "+this.j, "n = "+this.n, "m = "+this.m);

            if(S == undefined) {
                this.S = "S = 0.0 Try different input data.";
            } else {
                this.S = this.i_j_index(S);
            }
        }

    }

    outputResult() {
        document.getElementById('result').innerHTML = "<p>Result: " + this.S.toString() + "</p>";
    }
}