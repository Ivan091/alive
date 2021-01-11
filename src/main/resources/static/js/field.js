$(function () {
    $.getJSON("/api/field/status", function (data) {
        $.each(data, function (_, row) {
            $('#field').append(addColoredRow(row))
        })
    })
})

function addColoredRow(rowData) {
    let tr;
    tr = $('<tr>');
    $.each(rowData, function (_, cell) {
        $(tr).append(
            $('<td>').css({
                backgroundColor: cell.color,
            })
        )
    })
    return tr;
}

function updateField() {
    $.post("/api/field/update");
    let field = "api/field/status";
    $.get(field, {success: update(field)});
}

function update(fieldUrl) {
    $.getJSON(fieldUrl, function (data) {
        let table = document.getElementById("field");
        for (const [i, row] of Object.entries(table.rows)) {
            for (const [j, cell] of Object.entries(row.cells)) {
                cell.style.backgroundColor = data[i][j]['color']
            }
        }
    })
}

let obj = true;

function start() {
    if (obj === true)
        obj = setInterval(updateField, 1000)
}

function stop() {
    clearInterval(obj)
    obj = true;
}