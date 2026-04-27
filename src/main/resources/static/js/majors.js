const API = "/api/majors";

window.onload = () => loadMajors();

function showAlert(message, type = "success") {
    document.getElementById("alertBox").innerHTML = `
        <div class="alert alert-${type} alert-dismissible fade show">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    `;
}

function loadMajors() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("majorTable");
            table.innerHTML = "";

            data.forEach(m => {
                table.innerHTML += `
                    <tr>
                        <td>${m.majorCode}</td>
                        <td>${m.majorName}</td>
                        <td>
                            <button class="btn btn-danger btn-sm"
                                onclick="deleteMajor('${m.id}')">
                                🗑 Xóa
                            </button>
                        </td>
                    </tr>
                `;
            });
        });
}

document.getElementById("majorForm").onsubmit = function(e) {
    e.preventDefault();

    const code = document.getElementById("major_code").value.trim();
    const name = document.getElementById("major_name").value.trim();

    if (!code || !name) {
        showAlert("❌ Vui lòng nhập đầy đủ thông tin", "danger");
        return;
    }

    const data = {
        majorCode: code,
        majorName: name,
        isActive: true
    };

    fetch(API, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(res => {
        if (!res.ok) throw new Error();
        showAlert("Thêm ngành thành công");
        document.getElementById("majorForm").reset();
        loadMajors();
    })
    .catch(() => showAlert("Lỗi khi thêm", "danger"));
};

function deleteMajor(id) {
    if (!confirm("Bạn chắc chắn muốn xóa?")) return;

    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => {
            showAlert("🗑 Đã xóa");
            loadMajors();
        });
}