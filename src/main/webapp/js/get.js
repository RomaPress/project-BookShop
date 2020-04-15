function getTwoValues() {
    var val1 = document.getElementById("first_line");
    var line1 = val1.options[val1.selectedIndex].text;
    $.ajax({
        type: "POST",
        url: "/answer",
        dataType: "json",
        data: {line1: line1}
    });
}

// document.getElementById("first_line");