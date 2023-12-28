function validateForm() {
    const x = document.forms["myForm"]["task_description"].value;
    if (x == null || x.trim().length === 0) {
        alert("Empty string");
        x.clear();
    }
}
