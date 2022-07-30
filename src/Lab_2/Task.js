class Task {
    constructor(matrix_a_scale, matrix_b_scale) {
        this.matrix_a_scale = this.matrix_a_scale;
        this.matrix_b_scale = this.matrix_b_scale;
        this.matrix_a = [];
        this.matrix_b = [];
        this.result = [];
        this.average = [];
    }

    getInputs() {
        this.matrix_a_scale = parseInt(document.getElementById("matrix_a_scale").value);
        this.matrix_b_scale = parseInt(document.getElementById("matrix_b_scale").value);
    }

    calculateMatrix() {
        function generateMatrix(scale) {
            var arr = new Array();
            for(var i=0; i<scale; i++){
              arr[i] = new Array();
              for(var j=0; j<scale; j++){
                arr[i][j] = parseInt((Math.random() * 101)); // random int from 0 to 100
              }
            }
            return arr;
        }
        this.matrix_a = generateMatrix(this.matrix_a_scale);
        this.matrix_b = generateMatrix(this.matrix_b_scale);

        for(var i=0; i<this.matrix_a_scale; i++){
            this.result[i] = [];
            for(var j=0; j<this.matrix_b_scale; j++){
                this.result[i][j] = this.matrix_a[i][j] + this.matrix_b[i][j];
            }
        }
        
    }

    averageColumn() {
        for(var i=0; i<this.matrix_b_scale; i++){
            var sum = 0;
            for(var j=0; j<this.matrix_a_scale; j++){
                sum += this.result[j][i];
            }
            this.average[i] = sum/this.matrix_a_scale;
        }
        console.log(this.average);
    }

    outputResult() {
        // function outputMatrix(matrix, table_id, scale) {
        // matrix = document.getElementById(table_id);
        // matrix.innerHTML = "";
        // for(var i=0; i<scale; i++){
        //     var row = matrix.insertRow(i);
        //     for(var j=0; j<scale; j++){
        //         var cell = row.insertCell(j);
        //         cell.innerHTML = matrix[i][j];
        //     }
        // }
        // }

        // outputMatrix.call(this.matrix_a, "matrix_a", this.matrix_a_scale);
        // outputMatrix.call(this.matrix_b, "matrix_b", this.matrix_b_scale);
        // outputMatrix.call(this.result, "result", this.matrix_a_scale);

        //-----------------------------------------------------

        function outputMatrixA() {
            var matrix = document.getElementById("matrix_a_table");
            matrix.innerHTML = "";
            for(var i=0; i<this.matrix_a_scale; i++){
                var row = matrix.insertRow(i);
                for(var j=0; j<this.matrix_a_scale; j++){
                    var cell = row.insertCell(j);
                    cell.innerHTML = this.matrix_a[i][j];
                }
            }
        }
        outputMatrixA.call(this);

        function outputMatrixB() {
            var matrix = document.getElementById("matrix_b_table");
            matrix.innerHTML = "";
            for(var i=0; i<this.matrix_b_scale; i++){
                var row = matrix.insertRow(i);
                for(var j=0; j<this.matrix_b_scale; j++){
                    var cell = row.insertCell(j);
                    cell.innerHTML = this.matrix_b[i][j];
                }
            }
        }
        outputMatrixB.call(this);

        function outputMatrixResult() {
            var matrix = document.getElementById("result_table");
            matrix.innerHTML = "";
            for(var i=0; i<this.matrix_a_scale; i++){
                var row = matrix.insertRow(i);
                for(var j=0; j<this.matrix_b_scale; j++){
                    var cell = row.insertCell(j);
                    cell.innerHTML = this.result[i][j];
                }
            }
        }

        outputMatrixResult.call(this);

        document.getElementById("avarage_column_result").innerHTML = this.average;
    }
}