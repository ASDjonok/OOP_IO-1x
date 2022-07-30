document.getElementById("generate_button").addEventListener("click", function() {
    task = new Task();
    task.getInputs();
    task.calculateMatrix();
    task.averageColumn();
    task.outputResult();
});
