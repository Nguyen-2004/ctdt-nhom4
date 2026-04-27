ALTER TABLE training_program_courses DROP CONSTRAINT IF EXISTS FK_training_program_courses_courses;

-- XÓA BẢNG NẾU TỒN TẠI
DROP TABLE IF EXISTS training_program_courses;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS training_programs;
DROP TABLE IF EXISTS majors;

-- =======================
-- TABLE: majors
-- =======================
CREATE TABLE majors (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    department_id UNIQUEIDENTIFIER,
    major_code VARCHAR(20) UNIQUE,
    major_name NVARCHAR(255),
    description NVARCHAR(MAX),
    effective_date DATE,
    expiry_date DATE,
    created_at DATETIME2,
    updated_at DATETIME2,
    created_by UNIQUEIDENTIFIER,
    updated_by UNIQUEIDENTIFIER,
    deleted_at DATETIME2,
    deleted_by UNIQUEIDENTIFIER,
    is_active BIT
);

-- =======================
-- TABLE: training_programs
-- =======================
CREATE TABLE training_programs (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    program_code VARCHAR(50),
    program_name NVARCHAR(255),
    program_name_en NVARCHAR(255),
    major_id UNIQUEIDENTIFIER,
    department_id UNIQUEIDENTIFIER,
    degree_level NVARCHAR(50),
    education_type NVARCHAR(50),
    total_credits DECIMAL(5,1),
    required_credits DECIMAL(5,1),
    elective_credits DECIMAL(5,1),
    internship_credits DECIMAL(5,1),
    thesis_credits DECIMAL(5,1),
    admission_year INT,
    duration_years DECIMAL(5,1),
    max_duration_years DECIMAL(5,1),
    effective_date DATE,
    expiry_date DATE,
    description NVARCHAR(MAX),
    objectives NVARCHAR(MAX),
    learning_outcomes NVARCHAR(MAX),
    version VARCHAR(20),
    status VARCHAR(20),
    created_at DATETIME2,
    updated_at DATETIME2,
    created_by UNIQUEIDENTIFIER,
    updated_by UNIQUEIDENTIFIER,
    deleted_at DATETIME2,
    deleted_by UNIQUEIDENTIFIER,
    is_active BIT,
    FOREIGN KEY (major_id) REFERENCES majors(id)
);

-- =======================
-- TABLE: courses
-- =======================
CREATE TABLE courses (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    department_id UNIQUEIDENTIFIER,
    course_code VARCHAR(20) UNIQUE,
    course_name NVARCHAR(255),
    course_name_en NVARCHAR(255),
    credits DECIMAL(5,1),
    course_type VARCHAR(20),
    theory_hours DECIMAL(5,1),
    practice_hours DECIMAL(5,1),
    self_study_hours DECIMAL(5,1),
    internship_hours DECIMAL(5,1),
    description NVARCHAR(MAX),
    created_at DATETIME2,
    updated_at DATETIME2,
    created_by UNIQUEIDENTIFIER,
    updated_by UNIQUEIDENTIFIER,
    deleted_at DATETIME2,
    deleted_by UNIQUEIDENTIFIER,
    is_active BIT
);

-- =======================
-- TABLE: training_program_courses
-- =======================
CREATE TABLE training_program_courses (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    training_program_id UNIQUEIDENTIFIER,
    course_id UNIQUEIDENTIFIER,
    semester_number INT,
    year_number INT,
    is_required BIT,
    group_code VARCHAR(50),
    credits DECIMAL(5,1),
    prerequisite_course_id UNIQUEIDENTIFIER,
    is_prerequisite_required BIT,
    note NVARCHAR(500),
    sort_order INT,
    status VARCHAR(20),
    created_at DATETIME2,
    updated_at DATETIME2,
    created_by UNIQUEIDENTIFIER,
    updated_by UNIQUEIDENTIFIER,
    deleted_at DATETIME2,
    deleted_by UNIQUEIDENTIFIER,
    is_active BIT,
    FOREIGN KEY (training_program_id) REFERENCES training_programs(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);