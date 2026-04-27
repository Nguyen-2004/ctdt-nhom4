const API = "/api/training-program-courses";

/* FIX CỨNG ID Ở ĐÂY */
const FIXED_TRAINING_PROGRAM_ID = "1CFC9166-EB7D-49D0-86E7-385554D3BBA3";

// training_program_id: document.getElementById("programSelect").value

window.onload = () => loadData();

function loadData() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("tpcTable");
            table.innerHTML = "";

            data.forEach(item => {
                table.innerHTML += `
                    <tr>
                        <td>${item.course_id}</td>
                        <td>${item.semester_number}</td>
                        <td>${item.year_number}</td>
                    </tr>
                `;
            });
        });
}

window.onload = () => {
    loadData();

    document.getElementById("tpcForm").onsubmit = function(e) {
        e.preventDefault();

        const data = {
            training_program_id: FIXED_TRAINING_PROGRAM_ID,
            course_id: document.getElementById("course_id").value,
            semester_number: parseInt(document.getElementById("semester").value),
            year_number: parseInt(document.getElementById("year").value),
            is_required: true,
            is_active: true
        };

        fetch(API, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        }).then(() => loadData());
    };
};