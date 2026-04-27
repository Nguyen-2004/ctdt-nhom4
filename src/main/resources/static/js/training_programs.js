const API = "/api/training-programs";

window.onload = () => {
    loadPrograms();
    loadMajors();
};

function showAlert(message, type = "success") {
    document.getElementById("alertBox").innerHTML = `
        <div class="alert alert-${type} alert-dismissible fade show">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    `;
}

function loadPrograms() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("programTable");
            table.innerHTML = "";

            data.forEach(p => {
                table.innerHTML += `
                    <tr>
                        <td>${p.programCode}</td>
                        <td>${p.programName}</td>
                        <td>${p.totalCredits || ""}</td>
                        <td>
                            <button class="btn btn-danger btn-sm"
                                onclick="deleteProgram('${p.id}')">
                                🗑 Xóa
                            </button>
                        </td>
                    </tr>
                `;
            });
        });
}

document.getElementById("programForm").onsubmit = function(e) {
    e.preventDefault();

    const code = document.getElementById("program_code").value.trim();
    const name = document.getElementById("program_name").value.trim();
    const majorId = document.getElementById("major_id").value;

    if (!code || !name || !majorId) {
        showAlert("❌ Vui lòng nhập đầy đủ thông tin", "danger");
        return;
    }

    const data = {
        programCode: code,
        programName: name,
        majorId: majorId,
        totalCredits: parseFloat(document.getElementById("total_credits").value || 0),
        isActive: true
    };

    fetch(API, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(res => {
        if (!res.ok) throw new Error();
        showAlert("Thêm CTĐT thành công");
        document.getElementById("programForm").reset();
        loadPrograms();
    })
    .catch(() => showAlert("Lỗi khi thêm", "danger"));
};

function deleteProgram(id) {
    if (!confirm("Bạn chắc chắn muốn xóa?")) return;

    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => {
            showAlert("🗑 Đã xóa");
            loadPrograms();
        });
}

function loadMajors() {
    fetch("/api/majors")
        .then(res => res.json())
        .then(data => {
            const select = document.getElementById("major_id");
            select.innerHTML = "";

            data.forEach(m => {
                select.innerHTML += `
                    <option value="${m.id}">
                        ${m.majorName}
                    </option>
                `;
            });
        });
}