document.getElementById("calculate_button").addEventListener("click", function() {
    task = new Task(1418);
    task.getOperations();
    task.calculate();
    task.outputResult();
});
