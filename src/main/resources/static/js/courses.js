const API = "/api/courses";

window.onload = () => loadCourses();

function showAlert(message, type = "success") {
    document.getElementById("alertBox").innerHTML = `
        <div class="alert alert-${type} alert-dismissible fade show">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    `;
}

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
                            <button class="btn btn-danger btn-sm"
                                onclick="deleteCourse('${c.id}')">
                                🗑 Xóa
                            </button>
                        </td>
                    </tr>
                `;
            });
        });
}

document.getElementById("courseForm").onsubmit = function(e) {
    e.preventDefault();

    const code = document.getElementById("course_code").value.trim();
    const name = document.getElementById("course_name").value.trim();
    const credits = document.getElementById("credits").value;

    if (!code || !name || !credits) {
        showAlert("❌ Vui lòng nhập đầy đủ thông tin", "danger");
        return;
    }

    const data = {
        course_code: code,
        course_name: name,
        credits: parseFloat(credits),
        is_active: true
    };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(res => {
        if (!res.ok) throw new Error();
        showAlert("Thêm thành công");
        document.getElementById("courseForm").reset();
        loadCourses();
    })
    .catch(() => showAlert("Lỗi khi thêm", "danger"));
};

function deleteCourse(id) {
    if (!confirm("Bạn chắc chắn muốn xóa?")) return;

    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => {
            showAlert("🗑 Đã xóa");
            loadCourses();
        });
}