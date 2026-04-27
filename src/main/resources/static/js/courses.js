const API = "/api/courses";

window.onload = () => loadCourses();

function loadCourses() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("courseTable");
            table.innerHTML = "";

            data.forEach(c => {
                table.innerHTML += `
                    <tr>
                        <td>${c.course_code}</td>
                        <td>${c.course_name}</td>
                        <td>${c.credits}</td>
                        <td>
                            <button onclick="deleteCourse('${c.id}')">Xóa</button>
                        </td>
                    </tr>
                `;
            });
        });
}

document.getElementById("courseForm").onsubmit = function(e) {
    e.preventDefault();

    const data = {
        course_code: document.getElementById("course_code").value,
        course_name: document.getElementById("course_name").value,
        credits: parseFloat(document.getElementById("credits").value),
        is_active: true
    };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    }).then(() => loadCourses());
};

function deleteCourse(id) {
    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => loadCourses());
}