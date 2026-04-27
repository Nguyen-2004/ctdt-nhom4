-- =======================
-- majors
-- =======================
INSERT INTO majors VALUES
(NEWID(), NEWID(), 'CNTT', N'Công nghệ thông tin', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'QTKD', N'Quản trị kinh doanh', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'KT', N'Kế toán', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'TCNH', N'Tài chính ngân hàng', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'DL', N'Du lịch', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'NN', N'Ngôn ngữ Anh', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'XD', N'Xây dựng', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CK', N'Cơ khí', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'DT', N'Điện tử', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'MT', N'Môi trường', N'Mô tả', GETDATE(), NULL, GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1);

-- =======================
-- courses
-- =======================
INSERT INTO courses VALUES
(NEWID(), NEWID(), 'CS101', N'Lập trình C', N'C Programming', 3, 'CORE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS102', N'Lập trình Java', N'Java Programming', 3, 'CORE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS103', N'Cơ sở dữ liệu', N'Database', 3, 'CORE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS104', N'Mạng máy tính', N'Networking', 3, 'CORE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS105', N'Hệ điều hành', N'OS', 3, 'CORE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS106', N'AI cơ bản', N'AI Basic', 3, 'ELECTIVE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS107', N'Machine Learning', N'ML', 3, 'ELECTIVE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS108', N'Deep Learning', N'DL', 3, 'ELECTIVE', 30, 15, 45, 0, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS109', N'Thực tập', N'Internship', 5, 'CORE', 0, 0, 0, 120, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), NEWID(), 'CS110', N'Khóa luận', N'Thesis', 6, 'CORE', 0, 0, 0, 150, N'Mô tả', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1);

-- =======================
-- training_programs
-- =======================
INSERT INTO training_programs VALUES
(NEWID(), 'CTDT01', N'CNTT 2023', N'IT 2023', (SELECT TOP 1 id FROM majors), NEWID(), N'Đại học', N'Chính quy', 120, 90, 30, 5, 6, 2023, 4, 6, GETDATE(), NULL, N'Mô tả', N'Mục tiêu', N'Chuẩn đầu ra', 'v1', 'ACTIVE', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1);

-- =======================
-- training_program_courses
-- =======================
INSERT INTO training_program_courses VALUES
(NEWID(), (SELECT TOP 1 id FROM training_programs), (SELECT TOP 1 id FROM courses), 1, 1, 1, NULL, 3, NULL, 0, NULL, 1, 'ACTIVE', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), (SELECT TOP 1 id FROM training_programs), (SELECT id FROM courses OFFSET 1 ROWS FETCH NEXT 1 ROWS ONLY), 2, 1, 1, NULL, 3, NULL, 0, NULL, 2, 'ACTIVE', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1),
(NEWID(), (SELECT TOP 1 id FROM training_programs), (SELECT id FROM courses OFFSET 2 ROWS FETCH NEXT 1 ROWS ONLY), 3, 2, 1, NULL, 3, NULL, 0, NULL, 3, 'ACTIVE', GETDATE(), GETDATE(), NEWID(), NEWID(), NULL, NULL, 1);