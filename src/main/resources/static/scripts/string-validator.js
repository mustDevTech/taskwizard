/**
 * Checks the form for an empty value in the task_description field.
 * If the field is empty, displays an alert and clears the field.
 */
function validateForm() {
    const x = document.forms["myForm"]["task_description"].value;
    if (x == null || x.trim().length === 0) {
        window.alert("Empty string");
        x.clear();
    }
}