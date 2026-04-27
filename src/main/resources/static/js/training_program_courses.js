const API = "/api/training-program-courses";

/* FIX CỨNG ID Ở ĐÂY */

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

    document.getElementById('tpcForm').onsubmit = async (e) => {
    e.preventDefault();

    const data = {
        // trainingProgramId: document.getElementById('trainingProgramId').value,
        trainingProgramId: "92340068-6EA6-4669-913D-9BD9790208B4",
        courseId: document.getElementById('courseId').value,
        semesterNumber: document.getElementById('semester').value,
        yearNumber: document.getElementById('year').value,
        credits: document.getElementById('credits').value,
        isRequired: document.getElementById('isRequired').value === "true"
    };

    await fetch('/api/training-program-courses', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    });

    loadTPC();
    };
};

async function loadTrainingPrograms() {
  const res = await fetch('/api/training-programs');
  const data = await res.json();

  const select = document.getElementById('trainingProgramId');
  select.innerHTML = '';

  data.forEach(tp => {
    select.innerHTML += `
      <option value="${tp.id}">
        ${tp.programName}
      </option>
    `;
  });
}


async function loadTPC() {
  const res = await fetch(API);
  const data = await res.json();

  const table = document.getElementById('tpcTable');
  table.innerHTML = '';

  data.forEach(t => {
    table.innerHTML += `
      <tr>
        <td>${t.trainingProgramId}</td>
        <td>${t.courseId}</td>
        <td>${t.semesterNumber}</td>
        <td>${t.yearNumber}</td>
        <td>${t.credits}</td>
        <td>${t.isRequired ? 'Bắt buộc' : 'Tự chọn'}</td>
      </tr>
    `;
  });
}

async function loadCourses() {
  const res = await fetch('/api/courses');
  const data = await res.json();

  const select = document.getElementById('courseId');
  select.innerHTML = '';

  data.forEach(c => {
    select.innerHTML += `
      <option value="${c.id}">
        ${c.courseName}
      </option>
    `;
  });
}