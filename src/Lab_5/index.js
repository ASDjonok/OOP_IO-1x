document.getElementById("calculate_button").addEventListener("click", function() {
    task = new Task(document.getElementById("text").value);
    task.sortByVowels();
});
