function validateForm()
{
    var x = document.forms["myForm"]["task_description"].value;
    if (x == "" || x == null)
    {
        alert("Empty string");
        return false;
    }
}
